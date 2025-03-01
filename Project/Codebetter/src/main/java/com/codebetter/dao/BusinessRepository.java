package com.codebetter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codebetter.entities.Business;

public interface BusinessRepository extends JpaRepository<Business, String>{

}
