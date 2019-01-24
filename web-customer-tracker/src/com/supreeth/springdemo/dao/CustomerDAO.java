package com.supreeth.springdemo.dao;

import java.util.List;

import com.supreeth.springdemo.entity.Customer;

public interface CustomerDAO {
	
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer cust);

	public Customer getCustomer(int theId);

	public Customer deleteCustomer(int id);
}
