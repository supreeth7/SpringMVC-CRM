package com.supreeth.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.supreeth.springdemo.entity.Customer;
import com.supreeth.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject DAO
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(Model m) {
		
		//get customer from DAO
		
		List<Customer> customers = customerService.getCustomers();
		
		//add customer to Spring
		m.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer c = new Customer();
		
		theModel.addAttribute("customer",c);
		
		return "customer-form";
		
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer cust) {
		
		 customerService.saveCustomer(cust);
		
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/showFormUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model m) {
		
		Customer c_up = customerService.getCustomers(theId);
		
		m.addAttribute("customer", c_up);
		
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int id, Model m) {
		
		Customer c = customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}

}
