package com.timespace.backend.Repository;

import com.timespace.backend.Entity.UserSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScheduleRepository extends JpaRepository<UserSchedule, Integer> {
}
