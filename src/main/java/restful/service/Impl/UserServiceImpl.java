package restful.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restful.bean.User;
import restful.dao.UserDao;
import restful.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserDao userDao;
	
	@Override
	public void addUser(User user) throws Exception {
		userDao.addUser(user);
	}

	@Override
	public void deleteUser(int id) throws Exception {
		userDao.deleteUser(id);
	}

	@Override
	public void updateUser(User user) throws Exception {
		userDao.updateUser(user);
	}

	@Override
	public User findUserById(int id) throws Exception {
		return userDao.findUserById(id);
	}

	@Override
	public List<User> findUsers() throws Exception {
		return userDao.findUsers();
	}

}
