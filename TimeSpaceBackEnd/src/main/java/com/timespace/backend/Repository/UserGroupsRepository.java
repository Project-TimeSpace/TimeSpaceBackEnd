package com.timespace.backend.Repository;

import com.timespace.backend.Entity.UserGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGroupsRepository extends JpaRepository<UserGroups, Integer> {
}
