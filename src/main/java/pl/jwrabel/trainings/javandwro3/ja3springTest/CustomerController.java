package pl.jwrabel.trainings.javandwro3.ja3springTest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CustomerController {

	List<Customer> customers = new ArrayList<>();
//	List<Customer> list = Collections.synchronizedList(new ArrayList<Customer>());

	@RequestMapping(method = RequestMethod.GET, value = "/customer")
	@ResponseBody
	public Customer customer() {
		return new Customer(0, "Adam", "Kowalski", "1234");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/customerStatus")
	@ResponseBody
	public ResponseEntity<Customer> customerStatus() throws CustomerDoesNotExists {
		// SPOSOBY ZWRACANIA KODÓW ODPOWIEDZI
		throw new CustomerDoesNotExists();
//		return ResponseEntity.ok(new Customer());

//		return new ResponseEntity<Customer>(HttpStatus.CONFLICT);
	}


	@RequestMapping(method = RequestMethod.GET, value = "/customers")
	@ResponseBody
	public List<Customer> customers() {
		return customers;
	}


	@RequestMapping(method = RequestMethod.GET, value = "/customer/{id}")
	@ResponseBody
	public Customer findById(@PathVariable int id) {

		for (Customer customer : customers) {
			if (customer.getId() == id) {
				return customer;
			}
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/customer/{id}")
	@ResponseBody
	public void deleteById(@PathVariable int id) {
		customers = customers
				.stream()
				.filter(customer -> customer.getId() != id)
				.collect(Collectors.toList());

		// LUB
		for (int i = 0; i < customers.size(); i++) {
			if(customers.get(i).getId() == id){
				customers.remove(i);
				break;
			}
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/customer/{id}")
	@ResponseBody
	public void update(@RequestBody Customer customer, @PathVariable int id) {
		Customer foundCustomer = findById(id);
		if(foundCustomer != null){
			foundCustomer.setName(customer.getName());
			foundCustomer.setPesel(customer.getPesel());
			foundCustomer.setSurname(customer.getSurname());
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/customer")
	@ResponseBody
	public void addCustomer(@RequestBody Customer customer) {
		customers.add(customer);
	}


}
