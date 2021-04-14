package com.henryserrano.demo.controller;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.henryserrano.demo.model.Customer;
import com.henryserrano.demo.repository.CustomerRepository;
import com.henryserrano.demo.service.ICustomerService;


/**
 * @author user
 *
 */
@Controller
public class MyController {
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	CustomerRepository repo;
	
	/**
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/customer/{pageNo}/{pageSize}")
	@ResponseBody
	public List<Customer> getPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
		return customerService.findPaginated(pageNo, pageSize);
	}
	
	@RequestMapping("home")
	public String homeFun(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("totalCustomer", repo.count());
		return "homePage";
	}
	
	
	@PostMapping( "/customer/create")
	@ResponseBody
	public Customer saveUser(@Validated @RequestBody Customer customer) {
	    return repo.save(customer);
	}
	

	/**
	 * @param customer
	 * @param id
	 * @return
	 */
	@PutMapping("/customer/{id}")
	@ResponseBody
	public ResponseEntity<Object> updateStudent(@RequestBody Customer customer, @PathVariable int id) {
		Optional<Customer> customerOptional = repo.findById(id);

		if (!customerOptional.isPresent())
			return ResponseEntity.notFound().build();
		customer.setId(id);	
		repo.save(customer);
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * @param id
	 */

	@DeleteMapping("/customer/{id}")
	@ResponseBody
	public void deleteCustomer(@PathVariable int id) {
		repo.deleteById(id);
		
		
	}
	
	

	
	
}
