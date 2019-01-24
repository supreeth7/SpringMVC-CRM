package com.supreeth.springdemo.service;
import java.util.List;

import com.supreeth.springdemo.entity.Customer;

public interface CustomerService {
	
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer cust);

	public Customer getCustomers(int theId);

	public Customer deleteCustomer(int id);

}
