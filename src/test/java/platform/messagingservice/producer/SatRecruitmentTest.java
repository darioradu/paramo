package platform.messagingservice.producer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import sat.recruitment.api.controller.User;
import sat.recruitment.service.Utils;

public class SatRecruitmentTest {

	User u = new User("Dario","dario@paramo.com","1122223333","Calle 1 111","Normal",0.0);
	
    @Test
    public void main() {
    }
    
    @Test
    public void whenNormalUser_has_120_money_thenGifIs_14_4() {
    	u.setMoney(120.0);
    	assertEquals(Utils.calculateGif(u),14.4);
    }
    
    @Test
    public void whenNormalUser_has_11_money_thenGifIs_8_8() {
    	u.setMoney(11.0);
    	assertEquals(Utils.calculateGif(u),8.8);
    }

    @Test
    public void whenNormalUser_has_9_money_thenGifIs_0() {
    	u.setMoney(9.0);
    	assertEquals(Utils.calculateGif(u),0.0);
    }
    
    
}