package myRestApi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class GetRequest {
	private String currentDirectory = System.getProperty("user.dir");
	
	@RequestMapping()
	public List<List<String>> getUsers() throws JsonProcessingException, IOException{
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(new File(currentDirectory + "//contents.json"));
		String fnameNode="", lnameNode="", phoneNumberNode="", emailAddressNode="";
		List<Integer> id = new ArrayList<Integer>();
		List<String> userList = new ArrayList<String>();
		List<List<String>> usersList = new ArrayList<List<String>>();
		for(JsonNode root : jsonNode) {	
			
			 fnameNode = root.path("firstName").asText();
			 lnameNode = root.path("lastName").asText();
			 phoneNumberNode = root.path("phoneNumber").asText();
			 emailAddressNode = root.path("emailAddress").asText();
			 JsonNode ordersNode = root.path("orders");
			 
			 userList.add(fnameNode);
			 userList.add(lnameNode);
			 userList.add(phoneNumberNode);
			 userList.add(emailAddressNode);
			
			 for( JsonNode order : ordersNode) {
				 userList.add(order.asText());
			 }
			 
		}
		usersList.add(userList);
		return (usersList);
	}

	@RequestMapping("/{userId}")
	public List<String> getId(@PathVariable("userId") int userId)  throws IOException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(new File(currentDirectory + "//contents.json"));
		String fnameNode="", lnameNode="", phoneNumberNode="", emailAddressNode="";
		List<Integer> id = new ArrayList<Integer>();
		List<String> userList = new ArrayList<String>();
		for(JsonNode root : jsonNode) {	
			if(userId == root.path("userId").asInt()) {	
				 fnameNode = root.path("firstName").asText();
				 lnameNode = root.path("lastName").asText();
				 phoneNumberNode = root.path("phoneNumber").asText();
				 emailAddressNode = root.path("emailAddress").asText();
				 JsonNode ordersNode = root.path("orders");
				 
				 userList.add(fnameNode);
				 userList.add(lnameNode);
				 userList.add(phoneNumberNode);
				 userList.add(emailAddressNode);
				 
				 for( JsonNode order : ordersNode) {
					 userList.add(order.asText());
				 
				 }
			}				
		}
		return (userList);
	}
	
	@RequestMapping("/{userId}/orders")
	public List<String> getUserOrders(@PathVariable("userId") int userId)  throws IOException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(new File(currentDirectory + "//contents.json"));
		List<Integer> id = new ArrayList<Integer>();
		List<String> userList = new ArrayList<String>();
		for(JsonNode root : jsonNode) {	
			if(userId == root.path("userId").asInt()) {	

				 JsonNode ordersNode = root.path("orders");
			 
				 for( JsonNode order : ordersNode) {
					 userList.add(order.asText());
				 
				 }
			}				
		}
		return (userList);
	}
	
	@RequestMapping("/{userId}/orders/{orderId}")
	public List<String> getUserOrders(@PathVariable("userId") int userId,
			@PathVariable("orderId") String orderId)  throws IOException{
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(new File(currentDirectory + "//contents.json"));
		List<Integer> id = new ArrayList<Integer>();
		List<String> userList = new ArrayList<String>();
		for(JsonNode root : jsonNode) {	
			if(userId == root.path("userId").asInt()) {	
				 JsonNode ordersNode = root.path("orders");
				 Iterator<Entry<String, JsonNode>> fields = ordersNode.fields();
				
				 while(fields.hasNext()) {
					 Entry<String, JsonNode> jsonField = fields.next();
					 
					 if(jsonField.getKey().equals(orderId)) {					 
						 userList.add(jsonField.getValue().asText());
						 break;
					 }
				 }	
			}				
		}
		return (userList);
	}
	
}
