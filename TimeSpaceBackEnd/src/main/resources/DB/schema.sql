
CREATE SCHEMA IF NOT EXISTS timespace;
USE timespace;

CREATE TABLE User (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(70) NOT NULL UNIQUE,
    password VARCHAR(100),
    user_name VARCHAR(50) NOT NULL,
    university VARCHAR(50),
    major VARCHAR(50),
    phone_number VARCHAR(15) UNIQUE,
    summary TEXT,
    profile_image_url TEXT,
    city ENUM('서울', '부산', '대전', '대구', '광주', '울산', '인천', '세종'),
    address VARCHAR(50),
    num_friends INT DEFAULT 0 NOT NULL,
    num_groups INT DEFAULT 0 NOT NULL,
    grade VARCHAR(10) DEFAULT 'basic' NOT NULL,
    calendar_visibility BOOLEAN DEFAULT TRUE NOT NULL,
    active BOOLEAN DEFAULT TRUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL
);


CREATE TABLE Friend (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    friend_id INT NOT NULL,
    nickname VARCHAR(50),
    visibility ENUM('visible', 'secret', 'notvisible') DEFAULT 'secret' NOT NULL,
    is_favorite BOOLEAN DEFAULT FALSE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    UNIQUE KEY (user_id, friend_id),
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (friend_id) REFERENCES User(id)
);

CREATE TABLE FriendRequest (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL,
    status ENUM('pending', 'accepted') DEFAULT 'pending' NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (sender_id) REFERENCES User(id),
    FOREIGN KEY (receiver_id) REFERENCES User(id)
);

CREATE TABLE Group_Table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    master_id INT NOT NULL,
    unique_key VARCHAR(36) NOT NULL UNIQUE,
    category VARCHAR(50) DEFAULT 'normal' NOT NULL,
    grade VARCHAR(50) DEFAULT 'basic' NOT NULL,
    max_members INT DEFAULT 6 NOT NULL,
    group_image_url TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (master_id) REFERENCES User(id)
);

CREATE TABLE User_Groups (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    group_id INT NOT NULL,
    is_favorite BOOLEAN DEFAULT FALSE NOT NULL,
    UNIQUE KEY (user_id, group_id),
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (group_id) REFERENCES Group_Table(id)
);

CREATE TABLE GroupMemberRequest (
    id INT AUTO_INCREMENT PRIMARY KEY,
    group_id INT NOT NULL,
    target_user_id INT NOT NULL,
    status ENUM('pending', 'accepted') DEFAULT 'pending' NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (group_id) REFERENCES Group_Table(id),
    FOREIGN KEY (target_user_id) REFERENCES User(id)
);

CREATE TABLE UserSchedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    summary VARCHAR(100) NOT NULL,
    description TEXT,
    location VARCHAR(100),
    colorId VARCHAR(20),
    visibility ENUM('normal', 'hidden') NOT NULL DEFAULT 'normal',

    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    start_time TIME,
    end_time TIME,
    all_day BOOLEAN DEFAULT FALSE NOT NULL,

    is_recurring BOOLEAN DEFAULT FALSE NOT NULL,
    recurrence VARCHAR(200),
    day_week INT,
    google_event_id VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE FriendSchedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    requester_id INT NOT NULL,
    receiver_id INT NOT NULL,
    summary VARCHAR(100) NOT NULL,
    description TEXT,
    location VARCHAR(100),
    colorId VARCHAR(20),
    visibility ENUM('default', 'private', 'public') DEFAULT 'default',
    start_date DATE NOT NULL,
    start_time TIME,
    end_time TIME,
    all_day BOOLEAN DEFAULT FALSE NOT NULL,
    status ENUM('pending', 'accepted') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (requester_id) REFERENCES User(id),
    FOREIGN KEY (receiver_id) REFERENCES User(id)
);

CREATE TABLE GroupSchedule (
    id INT AUTO_INCREMENT PRIMARY KEY,
    group_id INT NOT NULL,
    summary VARCHAR(100) NOT NULL,
    description TEXT,
    location VARCHAR(100),
    colorId VARCHAR(20),
    start_date DATE NOT NULL,
    start_time TIME,
    end_time TIME,
    all_day BOOLEAN DEFAULT FALSE NOT NULL,
    created_by INT NOT NULL,
    status ENUM('pending', 'accepted') DEFAULT 'pending',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (group_id) REFERENCES Group_Table(id),
    FOREIGN KEY (created_by) REFERENCES User(id)
);

CREATE TABLE GroupScheduleMember (
    id INT AUTO_INCREMENT PRIMARY KEY,
    schedule_id INT NOT NULL,
    user_id INT NOT NULL,
    response_status ENUM('accepted', 'declined', 'pending') DEFAULT 'accepted',
    FOREIGN KEY (schedule_id) REFERENCES GroupSchedule(id),
    FOREIGN KEY (user_id) REFERENCES User(id)
);

CREATE TABLE Notification (
    id INT AUTO_INCREMENT PRIMARY KEY,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL,
    type ENUM('group_invite', 'group_schedule', 'friend_request') NOT NULL,
    related_id INT,
    message TEXT,
    is_read BOOLEAN DEFAULT FALSE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (sender_id) REFERENCES User(id),
    FOREIGN KEY (receiver_id) REFERENCES User(id)
);

CREATE TABLE Token (
    token VARCHAR(255) PRIMARY KEY,
    user_id INT NOT NULL,
    expires_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id)
);
