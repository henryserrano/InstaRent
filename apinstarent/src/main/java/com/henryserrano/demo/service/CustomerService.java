package com.henryserrano.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.henryserrano.demo.model.Customer;
import com.henryserrano.demo.repository.ListCustomerRepository;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ListCustomerRepository repository;

	@Override
	public List<Customer> findPaginated(int pageNo, int pageSize) {
		Pageable paging=PageRequest.of(pageNo, pageSize) ;
		Page<Customer> pagedResult = repository.findAll(paging);
		return pagedResult.toList();
	}
	
}
