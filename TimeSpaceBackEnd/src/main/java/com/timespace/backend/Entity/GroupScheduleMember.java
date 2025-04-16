package com.timespace.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "GroupScheduleMember")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupScheduleMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "schedule_id", nullable = false)
    private Integer scheduleId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "response_status", nullable = false,
            columnDefinition = "ENUM('accepted', 'declined', 'pending') DEFAULT 'accepted'")
    private ResponseStatus responseStatus = ResponseStatus.accepted;

    public enum ResponseStatus {
        accepted, declined, pending
    }
}
