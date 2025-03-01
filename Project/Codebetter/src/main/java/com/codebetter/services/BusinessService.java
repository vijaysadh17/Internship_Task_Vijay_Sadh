package com.codebetter.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codebetter.dao.BusinessRepository;
import com.codebetter.entities.Business;

@Component
public class BusinessService {

	@Autowired
	private BusinessRepository br;

	public void addBusiness(Business b) {
		// TODO Auto-generated method stub
		br.save(b);

	}

	public Optional<Business> getBusinessById(String id) {
		// TODO Auto-generated method stub
		Optional<Business> op = br.findById(id);
		return op;
	}

	public void updateBusinessById(Business b, String id) {
		// TODO Auto-generated method stub
		Optional<Business> op = br.findById(id);
		if (op.isPresent()) {
			Business bb = op.get();
			bb.setName(b.getName());
			bb.setMobile(b.getMobile());
			bb.setAddress(b.getAddress());
			bb.setLogo(b.getLogo());
			bb.setUserId(b.getUserId());
			br.save(bb);

		}
	}

	public void deleteBusinessById(Business b, String id) {
		// TODO Auto-generated method stub
		br.deleteById(id);
	}
	
	

}
