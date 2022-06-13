package sat.recruitment.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import sat.recruitment.api.controller.User;

@Repository
public class UserDao implements IUserDao{
	
	private List<User> users = new ArrayList<User>();

	@Override
	public void save(User newUser) throws Exception {
		InputStream fstream = null;
		try {
			fstream = getClass().getResourceAsStream("/users.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

			loadUsers(br);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			
		}finally {
			try {
				fstream.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}
		
		if(users.contains(newUser)) {
			throw new DuplicatedException("User already exists");
		}
		
		//TO-DO actual save
		
	}
	
	private void loadUsers(BufferedReader br) throws NumberFormatException, IOException{
		String strLine;
		while ((strLine = br.readLine()) != null) {
			String[] line = strLine.split(",");
			User u = User.builder()
						.name(line[0])
						.email(line[1])
						.phone(line[2])
						.address(line[3])
						.userType(line[4])
						.money(Double.valueOf(line[5]))
						.build();
			users.add(u);
		}
	}

}
