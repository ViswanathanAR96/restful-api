package myRestApi;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class GetRequest {
	@RequestMapping("/{userId}")
	public List<UserItem> getUser(@PathVariable("userId") int userId){
		return Collections.singletonList(
				new UserItem(1, "123", "qwe", "SDSD", "ASDD")
				);
	}
	
	@RequestMapping()
	public List<UserItem> getUsers(){
		return Collections.singletonList(
				 new UserItem(1, "123", "qwe", "SDSD", "ASDD")
				);
	}
}
