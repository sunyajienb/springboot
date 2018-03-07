package restful.service;

import java.util.List;

import restful.bean.User;

public interface UserService {

	void addUser(User user) throws Exception;

	void deleteUser(int id) throws Exception;

	void updateUser(User user) throws Exception;

	User findUserById(int id) throws Exception;

	List<User> findUsers() throws Exception;

}
