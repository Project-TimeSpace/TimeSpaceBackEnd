package com.timespace.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "GroupSchedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(nullable = false, length = 100)
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 100)
    private String location;

    @Column(length = 20)
    private String colorId;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "start_time")
    private Time startTime;

    @Column(name = "end_time")
    private Time endTime;

    @Column(name = "all_day", nullable = false)
    private Boolean allDay = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('pending', 'accepted') DEFAULT 'accepted'")
    private ScheduleStatus status = ScheduleStatus.accepted;

    @Column(name = "created_by", nullable = false)
    private Integer createdBy;

    @Column(name = "created_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    public enum ScheduleStatus {
        pending, accepted
    }
}
