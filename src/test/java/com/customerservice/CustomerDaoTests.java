package com.customerservice;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.customerservice.dao.CustomerDao;
import com.customerservice.entity.Customer;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class CustomerDaoTests {	
    
	@Autowired
	private CustomerDao repo;
	
	@Test
    @Rollback(false)
	@Order(1)
	public void testSaveNewCustomer() {
		
		Customer saveCustomer = repo.save(new Customer("Agilan", "S","Male",29,7502222));
		
		assertThat(saveCustomer.getId()).isGreaterThan(0);
	}
    
    @Test
	@Order(2)
	public void testListCustomers() {
		List<Customer> customer = (List<Customer>) repo.findAll();		
		assertThat(customer).size().isGreaterThan(0);
	}
}
