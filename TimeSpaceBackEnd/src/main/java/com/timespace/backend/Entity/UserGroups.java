package com.timespace.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User_Groups", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "group_id"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "group_id", nullable = false)
    private Integer groupId;

    @Column(name = "is_favorite", nullable = false)
    private Boolean isFavorite = false;
}
