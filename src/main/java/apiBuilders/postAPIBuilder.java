package apiBuilders;

public class postAPIBuilder {

	
	public static String createUserRequestBody(String UserName) {
		
		
		return "{\n" + 
				"  \"id\": 1,\n" + 
				"  \"username\": \""+UserName+"\",\n" + 
				"  \"firstName\": \"sara\",\n" + 
				"  \"lastName\": \"sara\",\n" + 
				"  \"email\": \"tesst@email.com\",\n" + 
				"  \"password\": \"123s44\",\n" + 
				"  \"phone\": \"1234s5\",\n" + 
				"  \"userStatus\": 1\n" + 
				"}";
	}
	
	
	
public static String updateUserRequestBody(String UserName, String firstName) {
		
		
		return "{\n" + 
				"  \"id\": 1,\n" + 
				"  \"username\": \""+UserName+"\",\n" + 
				"  \"firstName\": \""+firstName+"\",\n" + 
				"  \"lastName\": \"sara\",\n" + 
				"  \"email\": \"tesst@email.com\",\n" + 
				"  \"password\": \"123s44\",\n" + 
				"  \"phone\": \"1234s5\",\n" + 
				"  \"userStatus\": 1\n" + 
				"}";
	}

}
