package com.codebetter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codebetter.entities.Service;

public interface ServiceRepository extends JpaRepository<Service , String>{

}
