package com.luv2code.springdemo.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	//@Transactional 
	//moved this to service layer 
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute  query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		//return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer to the db
		currentSession.saveOrUpdate(theCustomer);
		
		
	}

	@Override
	public Customer getCustomers(int theId) {
		//get session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//read obj from the db using primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		//get session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//delete obj from the db using primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id=:CustomerId");
			theQuery.setParameter("CustomerId", theId);
				
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		//not done
		return null;
	}
	
	

}
