package com.AnandCoder.SmartClassRoom.repository;

import com.AnandCoder.SmartClassRoom.Model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource,Long> {

    List<Resource> findByType(String type); // Custom method to find resources by type

    List<Resource> findByStatus(String status); // Custom method to find resources by status

}
