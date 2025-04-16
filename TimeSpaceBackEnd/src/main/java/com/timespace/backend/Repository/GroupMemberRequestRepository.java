package com.timespace.backend.Repository;

import com.timespace.backend.Entity.GroupMemberRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMemberRequestRepository extends JpaRepository<GroupMemberRequest, Integer> {
}
