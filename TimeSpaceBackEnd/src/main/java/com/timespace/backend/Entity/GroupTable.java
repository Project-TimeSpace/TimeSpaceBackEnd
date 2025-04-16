package com.timespace.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Group_Table")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(name = "master_id", nullable = false)
    private Integer masterId;

    @Column(name = "unique_key", length = 36, nullable = false, unique = true)
    private String uniqueKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, columnDefinition = "ENUM('normal', '친구', '조별과제', '스터디', '수업모임', '동아리', '프로젝트', '운동', '이벤트', '학회', '학생회') DEFAULT 'normal'")
    private GroupCategory category = GroupCategory.normal;

    @Column(length = 50, nullable = false)
    private String grade = "basic";

    @Column(name = "max_members", nullable = false)
    private Integer maxMembers = 6;

    @Column(name = "group_image_url", columnDefinition = "TEXT")
    private String groupImageUrl;

    @Column(name = "created_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    public enum GroupCategory {
        normal, 친구, 조별과제, 스터디, 수업모임,
        동아리, 프로젝트, 운동, 이벤트, 학회, 학생회
    }
}
