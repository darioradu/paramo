package platform.messagingservice.api.controller;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import sat.recruitment.SatRecruitmentApplication;
//import sat.recruitment.api.controller.SatRecruitmentController;
import sat.recruitment.api.controller.User;

@SpringBootTest(classes = SatRecruitmentApplication.class)
class MessagesActionsControllerTest {
    //@Autowired
    //private SatRecruitmentController controller;

	public MessagesActionsControllerTest() {
		RestAssured.baseURI="http://localhost:8080/api/v1";
	}


    @Test
    void testCreateUser() {
    	User u1 = new User("Dario","dario@paramo.com","1122223333","Calle 1 111","Normal",100.0);
    	given()
    		.header("Content-Type","application/json")
    		.and()
    		.body(u1)
    	.when()
    		.post("/create-user")
    	.then()
    		.statusCode(HttpStatus.SC_CREATED);
    }
    
    @Test
    void when_user_with_null_name_ThenError404() {
    	User u1 = new User(null,"dario@paramo.com","1122223333","Calle 1 111","Normal",100.0);
    	given()
    		.header("Content-Type","application/json")
    		.and()
    		.body(u1)
    	.when()
    		.post("/create-user")
    	.then()
    		.statusCode(HttpStatus.SC_BAD_REQUEST);
    }
    
    @Test
    void when_user_isDuplicated_thenReturn_BadRequest() {
    	User u = new User("Franco","Franco.Perez@gmail.com","+534645213542","Alvear y Colombres","Premium",112234.0);
	    given()
			.header("Content-Type","application/json")
			.and()
			.body(u)
		.when()
			.post("/create-user")
		.then()
			.statusCode(HttpStatus.SC_BAD_REQUEST);
    }
    

}
