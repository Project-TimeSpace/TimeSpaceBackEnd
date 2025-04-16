package com.timespace.backend.Repository;

import com.timespace.backend.Entity.GroupScheduleMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupScheduleMemberRepository extends JpaRepository<GroupScheduleMember, Integer> {
}
