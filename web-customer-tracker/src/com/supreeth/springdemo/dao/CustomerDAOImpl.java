package com.supreeth.springdemo.dao;

import java.util.List;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.supreeth.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		//get current session
		
		Session s1 = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> q = s1.createQuery("FROM Customer ORDER BY firstName",Customer.class);
		
		//get result and store in object
		
		List<Customer> customers = q.getResultList();
		
		//return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer cust) {
		Session s2 = sessionFactory.getCurrentSession();
		
		s2.saveOrUpdate(cust);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session s3 = sessionFactory.getCurrentSession();
		
		Customer CusUpdate = s3.get(Customer.class, theId);
		
		return CusUpdate;
	}

	@Override
	public Customer deleteCustomer(int id) {
		
		Session s3 = sessionFactory.getCurrentSession();
		Customer cd = s3.get(Customer.class, id);
		s3.delete(cd);
		return null;
	}

}
