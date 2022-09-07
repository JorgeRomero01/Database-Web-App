package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustmoerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
