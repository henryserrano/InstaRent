package com.henryserrano.demo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.henryserrano.demo.model.Customer;

public interface ListCustomerRepository extends PagingAndSortingRepository<Customer, Integer>  {

}
