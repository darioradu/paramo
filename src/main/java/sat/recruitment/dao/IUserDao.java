package sat.recruitment.dao;

import sat.recruitment.api.controller.User;

public interface IUserDao {
	public void save(User user) throws Exception;

}
