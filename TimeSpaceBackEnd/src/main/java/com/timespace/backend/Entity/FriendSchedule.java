package com.timespace.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "FriendSchedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FriendSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "requester_id", nullable = false)
    private Integer requesterId;

    @Column(name = "receiver_id", nullable = false)
    private Integer receiverId;

    @Column(nullable = false, length = 100)
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 100)
    private String location;

    @Column(length = 20)
    private String colorId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('normal', 'hidden') DEFAULT 'normal'")
    private Visibility visibility = Visibility.normal;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "all_day", nullable = false)
    private Boolean allDay = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('pending', 'accepted') DEFAULT 'pending'")
    private ScheduleStatus status = ScheduleStatus.pending;

    @Column(name = "created_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    public enum Visibility {
        normal, hidden
    }

    public enum ScheduleStatus {
        pending, accepted
    }
}
