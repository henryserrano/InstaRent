package com.henryserrano.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.henryserrano.demo.model.Customer;

@Service
public interface ICustomerService {
	List<Customer> findPaginated(int pageNo,int pageSize);
}
