package sat.recruitment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import sat.recruitment.api.controller.User;
import sat.recruitment.dao.DuplicatedException;
import sat.recruitment.dao.IUserDao;

@Service
public class UserService implements IUserService {
	
	@Autowired
	IUserDao userDao;

	@Override
	public void save(User user) throws Exception {
		Double gif = Utils.calculateGif(user);
		Gson gson = new Gson();
		User userCopy = gson.fromJson(gson.toJson(user), User.class);
		userCopy.setMoney(user.getMoney()+gif);
		
		try {
			userDao.save(userCopy);
		}catch(DuplicatedException de) {
			throw de;
		}catch(Exception e) {
			throw e;
		}
	}

}
