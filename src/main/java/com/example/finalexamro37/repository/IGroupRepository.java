package com.example.finalexamro37.repository;

import com.example.finalexamro37.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.awt.print.Pageable;

public interface IGroupRepository extends JpaRepository<Group, Integer>, JpaSpecificationExecutor<Group> {
    boolean existsByGroupName(String groupName);
}
