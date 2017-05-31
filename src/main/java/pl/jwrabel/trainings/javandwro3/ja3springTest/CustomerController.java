package pl.jwrabel.trainings.javandwro3.ja3springTest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
	List<Customer> customers = new ArrayList<>();

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

	@RequestMapping(method = RequestMethod.POST, value = "/customer")
	@ResponseBody
	public void addCustomer(@RequestBody Customer customer) {
		customers.add(customer);
	}

}
