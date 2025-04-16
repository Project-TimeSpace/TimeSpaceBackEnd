package com.timespace.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Friend", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "friend_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "friend_id", nullable = false)
    private Integer friendId;

    @Column(length = 50)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('visible', 'secret', 'notvisible') DEFAULT 'visible'")
    private Visibility visibility = Visibility.visible;

    @Column(name = "is_favorite", nullable = false)
    private Boolean isFavorite = false;

    @Column(name = "created_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    public enum Visibility {
        visible, secret, notvisible
    }
}

