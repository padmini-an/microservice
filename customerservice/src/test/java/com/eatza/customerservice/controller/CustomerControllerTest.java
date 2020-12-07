package com.eatza.customerservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eatza.customerservice.dto.CustomerDto;
import com.eatza.customerservice.model.Customer;
import com.eatza.customerservice.service.customerservice.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@WebMvcTest(value= CustomerController.class)
class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Autowired
	private ObjectMapper objectMapper;
	
	@InjectMocks
	CustomerController customerController;

	
	String jwt="";
	private static final long EXPIRATIONTIME = 900000;
	@BeforeEach
	public void setup() {
		jwt = "Bearer "+Jwts.builder().setSubject("user").claim("roles", "user").setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME)).compact();
	}

	@Test
	void testAddCustomer() throws Exception {
		CustomerDto customerDto=new CustomerDto();
		customerDto.setCustomerName("Gouthami");
		customerDto.setAddress("Rajajinagar");
		customerDto.setEmail("gouthami@mindtree.com");
		when(customerService.addCustomer(any(CustomerDto.class))).thenReturn(new CustomerDto());
		RequestBuilder request = MockMvcRequestBuilders.post(
				"/customer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString((customerDto)))
				.header(HttpHeaders.AUTHORIZATION,
						jwt);
		mockMvc.perform(request)
		.andExpect(status().is(200))
		.andReturn();
		
	}

	@Test
	void testGetCustomerById() throws Exception {
		Customer customer=new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("gouthami");
		customer.setEmail("email");
		customer.setAddress("address");
		when(customerService.getCustomerById(anyInt())).thenReturn(customer);
		RequestBuilder request = MockMvcRequestBuilders
				.get("/customer/1")
				.accept(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION,
						jwt);

		mockMvc.perform(request)
		.andExpect(status().isOk())
		.andReturn();
		
	}


	@Test
	void testUpdateCustomer() throws Exception {
		CustomerDto customerDto=new CustomerDto();
		customerDto.setCustomerName("Gouthami");
		customerDto.setAddress("Rajajinagar");
		customerDto.setEmail("gouthami@mindtree.com");
		when(customerService.updateCustomer(customerDto,1)).thenReturn("Customer details updated successfully");
		RequestBuilder request = MockMvcRequestBuilders.put(
				"/customer/reform/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString((customerDto)))
				.header(HttpHeaders.AUTHORIZATION,
						jwt);
		mockMvc.perform(request)
		.andExpect(status().is(200))
		.andReturn();
	}

	@Test
	void testGetAllCustomer() throws Exception {
		List<Customer>customerList=new ArrayList<Customer>();
		Customer customer=new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("gouthami");
		customer.setEmail("email");
		customer.setAddress("address");
		customerList.add(customer);
		when(customerService.getAllCustomer()).thenReturn(customerList);
		RequestBuilder request = MockMvcRequestBuilders
				.get("/fetchCustomers")
				.accept(MediaType.APPLICATION_JSON)
				.header(HttpHeaders.AUTHORIZATION,
						jwt);

		mockMvc.perform(request)
		.andExpect(status().isOk())
		.andReturn();
	}

}
