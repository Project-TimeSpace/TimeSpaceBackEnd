package com.timespace.backend.Repository;

import com.timespace.backend.Entity.GroupSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupScheduleRepository extends JpaRepository<GroupSchedule, Integer> {
}
