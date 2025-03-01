package com.codebetter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codebetter.dao.ServiceRepository;
import com.codebetter.entities.Service;

@Component
public class ServiceBL {

	@Autowired
	private ServiceRepository sr;
	public void addService(Service s) {
		// TODO Auto-generated method stub
		sr.save(s);
	}

}
