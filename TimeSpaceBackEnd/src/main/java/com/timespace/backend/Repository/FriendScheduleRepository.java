package com.timespace.backend.Repository;

import com.timespace.backend.Entity.FriendSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendScheduleRepository extends JpaRepository<FriendSchedule, Integer> {
}
