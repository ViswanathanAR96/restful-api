package myRestApi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestMethods {
	@RequestMapping("/hello")
	public String test() {
		return "Test";
	}
}
	
