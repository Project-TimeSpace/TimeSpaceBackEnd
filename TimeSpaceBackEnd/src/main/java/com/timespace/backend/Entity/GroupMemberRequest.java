package com.timespace.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "GroupMemberRequest")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupMemberRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(name = "target_user_id", nullable = false)
    private Integer targetUserId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('pending', 'accepted') DEFAULT 'pending'")
    private RequestStatus status = RequestStatus.pending;

    @Column(name = "created_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    public enum RequestStatus {
        pending, accepted
    }
}
