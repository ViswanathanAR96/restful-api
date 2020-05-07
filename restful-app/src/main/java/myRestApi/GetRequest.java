package myRestApi;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/users")
public class GetRequest {
	
	private ObjectMapper objectMapper;
	private String currentDirectory = System.getProperty("user.dir");
	
//	@Autowired
//	private UserItem userItem;


//	public void jsonGet() throws IOException {
//		//read json file data to String
//		
//		byte[] jsonData = Files.readAllBytes(Paths.get(currentDirectory + "//src//test//java//myRestApi//contents.json"));	
//		//create ObjectMapper instance
//		ObjectMapper objectMapper = new ObjectMapper();
//		//convert json string to object		
//		emp = objectMapper.readValue(jsonData, new TypeReference<List<UserItem>>(){});
//		System.out.println("Tes\n" + this.emp.get(0));
//	}
		
//		@RequestMapping("/{userId}")
//		public List<UserItem> getUser(@PathVariable("userId") int userId){
//			return Collections.singletonList(
//					 new UserItem(1, "123", "qwe", "SDSD", "ASDD")
//					);
//			
//		}
		
//		@RequestMapping()
//		public int  getUsers() throws IOException{
//			int id=0;
//			JsonNode jsonNode = objectMapper.readTree(new File(currentDirectory + "//src//test//java//myRestApi//contents.json"));
//			for(JsonNode root : jsonNode) {
//				id = root.path("id").asInt();
//				//System.out.println(id);
//				
//			}
//			return id;
//		}
		
		@RequestMapping()
		public List<UserItem> getUsers(){
			return Collections.singletonList(
					 new UserItem(1, "123", "qwe", "SDSD", "ASDD")
					);
		}
		
	}
	
	
