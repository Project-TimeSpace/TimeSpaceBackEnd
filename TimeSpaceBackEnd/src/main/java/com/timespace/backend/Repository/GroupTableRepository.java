package com.timespace.backend.Repository;

import com.timespace.backend.Entity.GroupTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTableRepository extends JpaRepository<GroupTable, Integer> {
}
