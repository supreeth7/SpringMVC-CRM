package com.supreeth.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supreeth.springdemo.dao.CustomerDAO;
import com.supreeth.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer cust) {
		customerDAO.saveCustomer(cust);
		
	}

	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional
	public Customer deleteCustomer(int id) {
		return customerDAO.deleteCustomer(id);
	}

}
