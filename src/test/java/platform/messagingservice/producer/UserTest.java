package platform.messagingservice.producer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import sat.recruitment.api.controller.User;

public class UserTest {
	
	@Test
	public void when_same_email_or_same_phone_then_equals() {
		User u1 = new User("Dario","dario@paramo.com","1122223333","Calle 1 111","Normal",100.0);
		User u2 = new User("Martin","dario@paramo.com","1133334444","Calle 2 222","SuperUser",200.0);
		assertEquals(u1, u2);
		
		u2.setEmail("martin@paramo.com");
		u2.setPhone("1122223333");
		assertEquals(u1,u2);
	}
	@Test
	public void when_same_name_and_address_then_equals() {
		User u1 = new User("Dario","dario@paramo.com","1122223333","Calle 1 111","Normal",100.0);
		User u2 = new User("Dario","ddddd@paramo.com","1133334444","Calle 1 111","SuperUser",200.0);
		assertEquals(u1,u2);
	}
	
	@Test
	public void when_same_name_only_then_not_equals(){
		User u1 = new User("Dario","dario@paramo.com","1122223333","Calle 1 111","Normal",100.0);
		User u2 = new User("Dario","ddddd@paramo.com","1133334444","Calle 2 222","SuperUser",200.0);
		assertNotEquals(u1, u2);
	}
	
	@Test
	public void when_all_different_then_not_equals(){
		User u1 = new User("Dario","dario@paramo.com","1122223333","Calle 1 111","Normal",100.0);
		User u2 = new User("martin","martin@paramo.com","1133334444","Calle 2 222","SuperUser",200.0);
		assertNotEquals(u1, u2);
	}	


}
