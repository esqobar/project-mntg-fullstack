package com.esqobar.projectmngtbackend.services;

import com.esqobar.projectmngtbackend.ProjectMngtBackendApplication;
import com.esqobar.projectmngtbackend.exceptions.ProjectIdException;
import com.esqobar.projectmngtbackend.models.Project;
import com.esqobar.projectmngtbackend.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository projectRepository;
    
    public Project createProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch ( Exception e){
            throw new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }

    }

    public Project updateProject(Project project){
            return projectRepository.save(project);

    }

    public Project findByProjectIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Project ID '"+projectId+"' does not exist");
        }

        return project;
    }

    public List<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteByProjectIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());

        if(project == null){
            throw new ProjectIdException("Cannot Delete Project  With ID '"+projectId+"'. This project does not exist");
        }

        projectRepository.delete(project);
    }

}
