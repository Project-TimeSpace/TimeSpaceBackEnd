package com.timespace.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "UserSchedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(nullable = false, length = 100)
    private String summary; // 스케쥴 이름.

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 100)
    private String location;

    @Column(length = 20)
    private String colorId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('default', 'private', 'public') DEFAULT 'default'")
    private Visibility visibility = Visibility.normal;

    @Column(name = "start_date", nullable = false)
    private java.sql.Date startDate;

    @Column(name = "end_date", nullable = false)
    private java.sql.Date endDate;

    @Column(name = "start_time")
    private java.sql.Time startTime;

    @Column(name = "end_time")
    private java.sql.Time endTime;

    @Column(name = "all_day", nullable = false)
    private Boolean allDay = false;

    @Column(name = "is_recurring", nullable = false)
    private Boolean isRecurring = false;

    @Column(length = 200)
    private String recurrence;

    @Column(name = "day_week")
    private Integer dayWeek;

    @Column(name = "google_event_id", length = 100)
    private String googleEventId;

    @Column(name = "created_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    public enum Visibility {
        @Enumerated(EnumType.STRING)
        normal, hidden
        }
}
