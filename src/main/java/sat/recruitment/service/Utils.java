package sat.recruitment.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import sat.recruitment.api.controller.User;

public class Utils {
	
	public static Double calculateGif(User user) {
		//These Lists MUST be ordered from higher to lower money amount
		List<AbstractMap.SimpleEntry<Integer,Double>> parameters4NormalUser =
				List.of(new AbstractMap.SimpleEntry<>(100,0.12),
						new AbstractMap.SimpleEntry<>(10,0.8));
		List<AbstractMap.SimpleEntry<Integer,Double>> parameters4SuerUser =
				List.of(new AbstractMap.SimpleEntry<>(100,0.2));
		List<AbstractMap.SimpleEntry<Integer,Double>> parameters4PremiumUser =
				List.of(new AbstractMap.SimpleEntry<>(100,1.0));
		Map<String,List<AbstractMap.SimpleEntry<Integer,Double>>> typeUser2parameters =
				Map.of("Normal",parameters4NormalUser,"Super",parameters4SuerUser,"Premium",parameters4PremiumUser);
	
		Double percentage = typeUser2parameters.get(user.getUserType())
			.stream().filter(pair -> pair.getKey() < user.getMoney())
			.findFirst().orElse(new AbstractMap.SimpleEntry<>(0,0.0)) //Because of the findFirst the list MUST be orderer from higher to lower money amount  
			.getValue();
		
		return BigDecimal.valueOf(user.getMoney() * percentage).setScale(2,RoundingMode.HALF_UP).doubleValue();		
	}

}
