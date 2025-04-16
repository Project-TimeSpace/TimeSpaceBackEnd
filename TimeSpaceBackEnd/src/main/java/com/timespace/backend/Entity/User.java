package com.timespace.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "email", length = 70, nullable = false, unique = true)
    private String email;

    @Column(name = "password", length = 100)
    private String password;

    @Column(name = "user_name", length = 50, nullable = false)
    private String userName;

    @Column(name = "university", length = 50)
    private String university;

    @Column(name = "major", length = 50)
    private String major;

    @Column(name = "phone_number", length = 15, unique = true)
    private String phoneNumber;

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "profile_image_url", columnDefinition = "TEXT")
    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "city", columnDefinition = "ENUM('서울', '부산', '대전', '대구', '광주', '울산', '인천', '세종')")
    private City city;

    @Column(name = "address", length = 30)
    private String address;

    @Column(name = "num_friends", nullable = false)
    private Integer numFriends = 0;

    @Column(name = "num_groups", nullable = false)
    private Integer numGroups = 0;

    @Column(name = "grade", length = 10, nullable = false)
    private String grade = "basic";

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Column(name = "calendar_visibility", nullable = false)
    private Boolean calendarVisibility = true;

    @Column(name = "created_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    public enum City {
        서울, 부산, 대전, 대구, 광주, 울산, 인천, 세종
    }
}
