package pl.jwrabel.trainings.javandwro3.ja3springTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jakubwrabel on 31/05/2017.
 */
@Controller
public class HelloController {
	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	@ResponseBody
	public String hello() {
		System.out.println("GET /hello");
		return "Hello World";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/hello2/{name}")
	@ResponseBody
	public String helloPathParam(@PathVariable String name) {
		return "Hello " + name;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/hello3")
	@ResponseBody
	public String helloRequestParam(@RequestParam String name, @RequestParam String surname) {
		return "Hello " + name + ", " + surname;
	}
}
