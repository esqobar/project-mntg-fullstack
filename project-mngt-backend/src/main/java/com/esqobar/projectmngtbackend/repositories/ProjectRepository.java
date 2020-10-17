package com.esqobar.projectmngtbackend.repositories;

import com.esqobar.projectmngtbackend.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long > {
    Project findByProjectIdentifier(String projectId);
}
