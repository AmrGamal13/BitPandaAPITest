package BitPandaAPIs;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import TestBase.BaseTest;
import apiBuilders.postAPIBuilder;
import apiConfig.APIPath;
import apiConfig.HeaderConfigs;
import apiVerification.APIVerification;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.JavaUtilities;
import utils.readprop;

public class PostCreateUser extends BaseTest {
	
	readprop readObj;
	HeaderConfigs headerObj;
	
	@Test(priority = 1, description = "Create a user using new username")
	public void CreateUserAPI() throws IOException {
		readObj = new readprop();
		headerObj = new HeaderConfigs();
		
		test.log(LogStatus.INFO,"create UserAPITest started..." );

		Response response = RestAssured.given().
				headers(headerObj.defaultHeaders()).
		body(postAPIBuilder.createUserRequestBody(readObj.getPropValues("NewUserName", "data.properties"))).
		when().
		post(APIPath.POST_CREATE_USER);
		
		test.log(LogStatus.INFO, "Status code is .." +response.getStatusCode());
		test.log(LogStatus.INFO, "Response Body is is .." +response.getBody().prettyPrint());

		APIVerification.responseCodeValiddation(response, 200);		
		
		test.log(LogStatus.INFO,"create UserAPITest ended..." );

	}
	
	@Test(priority = 2, description = "Retrieve the user information by the username")
	public void getUserInfobyUserName() throws IOException {
		headerObj = new HeaderConfigs();
		readObj = new readprop();
		
		test.log(LogStatus.INFO,"get UserInfoAPITest started..." );

		Response resp = RestAssured.given()
				.headers(headerObj.defaultHeaders())
				.when()
				.get(APIPath.GET_USER_USERNAME.concat("/"+ readObj.getPropValues("NewUserName", "data.properties") ));
		
		
		test.log(LogStatus.INFO, "Status code is .." +resp.getStatusCode());
		test.log(LogStatus.INFO, "Response Body is is .." +resp.getBody().prettyPrint());

		JsonPath jp = JavaUtilities.convertToJson(resp.getBody().asString());
		
		Assert.assertEquals(jp.getString("username"), readObj.getPropValues("NewUserName", "data.properties"));
		APIVerification.responseCodeValiddation(resp, 200);		
		test.log(LogStatus.INFO,"get UserInfoAPITest ended..." );

	}
	@Test(priority = 3, description = "Update the user info by the username")
	public void UpdateUserInfobyUserName() throws IOException {
		headerObj = new HeaderConfigs();
		readObj = new readprop();
		
		test.log(LogStatus.INFO,"Update UserAPITest started..." );

		Response resp = RestAssured.given()
				.headers(headerObj.defaultHeaders())
				.body(postAPIBuilder.updateUserRequestBody(readObj.getPropValues("UpdatedUserName", "data.properties"),
						readObj.getPropValues("UpdatedFirstName", "data.properties")))
				.when()
				.put(APIPath.PUT_UPDATE_USER.concat("/"+ readObj.getPropValues("NewUserName", "data.properties") ));
		
		test.log(LogStatus.INFO, "Status code is .." +resp.getStatusCode());
		test.log(LogStatus.INFO, "Response Body is is .." +resp.getBody().prettyPrint());		
		APIVerification.responseCodeValiddation(resp, 200);		

		test.log(LogStatus.INFO,"update UserAPITest ended..." );

		
	}
	
	@Test(priority = 4, description = "Delete the user by the username")
	public void DeleteUserbyUserName() throws IOException {
		headerObj = new HeaderConfigs();
		readObj = new readprop();
		
		test.log(LogStatus.INFO,"Delete UserAPITest started..." );

		Response resp = RestAssured.given()
				.headers(headerObj.defaultHeaders())
				.when()
				.delete(APIPath.PUT_UPDATE_USER.concat("/"+ readObj.getPropValues("UpdatedUserName", "data.properties") ));
		
		test.log(LogStatus.INFO, "Status code is .." +resp.getStatusCode());
		test.log(LogStatus.INFO, "Response Body is is .." +resp.getBody().prettyPrint());
		
		APIVerification.responseCodeValiddation(resp, 200);		
		
		test.log(LogStatus.INFO,"Delete UserAPITest ended..." );

	}
	
	@Test(priority = 5, description = "Delete a user by username doesn't exist")
	public void DeleteUserbyUserNameNotExist() throws IOException {
		headerObj = new HeaderConfigs();
		readObj = new readprop();
		
		test.log(LogStatus.INFO,"Delete UserAPITestnotExist started..." );

		Response resp = RestAssured.given()
				.headers(headerObj.defaultHeaders())
				.when()
				.delete(APIPath.PUT_UPDATE_USER.concat("/"+ readObj.getPropValues("NotExistUser", "data.properties") ));
		
		test.log(LogStatus.INFO, "Status code is .." +resp.getStatusCode());
		
		APIVerification.responseCodeValiddation(resp, 404);		
		
		test.log(LogStatus.INFO,"Delete UserAPITestnotExist ended..." );
	}
	
	@Test(priority = 6, description = "Retrieve the user information by not exist username")
	public void getUserInfobyNotExistUserName() throws IOException {
		headerObj = new HeaderConfigs();
		readObj = new readprop();
		
		test.log(LogStatus.INFO,"get UserInfoAPITestnotExist started..." );

		Response resp = RestAssured.given()
				.headers(headerObj.defaultHeaders())
				.when()
				.get(APIPath.GET_USER_USERNAME.concat("/"+ readObj.getPropValues("NotExistUser", "data.properties") ));
		
		
		test.log(LogStatus.INFO, "Status code is .." +resp.getStatusCode());
		test.log(LogStatus.INFO, "Response Body is is .." +resp.getBody().prettyPrint());

		JsonPath jp = JavaUtilities.convertToJson(resp.getBody().asString());
		
		Assert.assertEquals(jp.getString("message"), "User not found");
		APIVerification.responseCodeValiddation(resp, 404);		
		test.log(LogStatus.INFO,"get UserInfoAPITest ended..." );

	}
}
