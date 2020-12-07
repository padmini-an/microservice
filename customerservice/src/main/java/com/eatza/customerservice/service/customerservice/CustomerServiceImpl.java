package com.eatza.customerservice.service.customerservice;


import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eatza.customerservice.dto.CustomerDto;
import com.eatza.customerservice.exception.CustomerException;
import com.eatza.customerservice.exception.CustomerNotFoundException;
import com.eatza.customerservice.exception.InputMismatchException;
import com.eatza.customerservice.model.Customer;
import com.eatza.customerservice.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
		
	private ModelMapper modelMapper =new ModelMapper();
	
//	@Autowired
//	private RestaurantProxy restaurantProxy;
//	@Autowired
//    private KafkaTemplate<String, ReviewDto> kafkaTemplate;
//
//    private static final String REVIEW_TOPIC = "reviewTopic";

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public CustomerDto addCustomer(CustomerDto customerDto) {
		Customer customer = modelMapper.map(customerDto, Customer.class);
		logger.info("customer added successfully");
		customerDto = modelMapper.map(customerRepository.save(customer), CustomerDto.class);
		return customerDto;
	}
	
	@Override
	public Customer getCustomerById(long customerId) throws CustomerException {
		logger.info("customer deleted successfully");
		if(customerId<1) {
			throw new InputMismatchException("Customer ID Should not be negative value..!");
		}
		Optional<Customer> customerFetched =  customerRepository.findById(customerId);
		if(!customerFetched.isPresent()) {
			throw new CustomerNotFoundException("Customer does not exists...!");
		}
		return customerFetched.get();
	}


//	@Override
//	public String deleteCustomer(long customerId) throws CustomerException {
//		logger.info("fetching customer by using id  successfully");
//		Optional<Customer> customerFetched =  customerRepository.findById(customerId);
//		if(customerId<1) {
//			throw new InputMismatchException("Customer ID  Should not be negative...!");
//		}
//		if(!customerFetched.isPresent()) {
//			throw new CustomerNotFoundException("Customer does not exists...!");
//		}
//		customerRepository.deleteById(customerId);;
//		return "Customer has been deleted SuccessFully..!";
//	}

	@Override
	public String updateCustomer(CustomerDto customerDto,long customerId) throws CustomerException {
		logger.info("fetching customer by using id  successfully");
		Optional<Customer> customerFetched =  customerRepository.findById(customerId);
		if(customerId<1) {
			throw new InputMismatchException("Customer ID  Should not be negative...!");
		}
		if(!customerFetched.isPresent()) {
			throw new CustomerNotFoundException("Customer does not exists...!");
		}
		customerDto.setCustomerName(customerDto.getCustomerName());
		customerDto.setAddress(customerDto.getAddress());
		customerDto.setEmail(customerDto.getEmail());
		Customer customer = modelMapper.map(customerDto, Customer.class);
		customer.setCustomerId(customerId);
		customerRepository.saveAndFlush(customer);
	
		return "Customer details updated successfully";
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}

//	@Override
//	public String provideReview(String authorization, ReviewDto reviewDto) throws ReviewException{
//		try {
//			restaurantProxy.verifyRestaurant(authorization,reviewDto.getRestaurantId());
//		} catch (FeignException e) {
//			throw new ReviewException(e.contentUTF8());
//		}
//		if(!(customerRepository.existsById(reviewDto.getCustomerId()))){
//			throw new ReviewException("Customer Not Found...!");
//		}
//		kafkaTemplate.send(REVIEW_TOPIC,reviewDto);
//		return "Review submitted successfully";
//	}


	
}
