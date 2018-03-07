package restful.web.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import restful.bean.User;
import restful.service.UserService;

@RestController
@RequestMapping(path={"/user"})
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping(value="/add")
	public void addUser(User user) {
		try {
			userService.addUser(user);
		} catch (Exception e) {
			log.error("插入用户失败:" + user);
		}
	}

	@DeleteMapping(value="/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			log.error("删除用户失败：" + id);
		}
	}

	@PutMapping(value="/update")
	public void updateUser(User user) {
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			log.error("更新用户失败：" + user);
		}
	}

	@GetMapping(value="/find/{id}")
	public User findUserById(@PathVariable int id) {
		User user = null;
		try {
			user = userService.findUserById(id);
		} catch (Exception e) {
			log.error("查询用户失败：" + id);
		}
		
		return user;
	}

	@GetMapping(value="/find/all")
	public List<User> findUsers() {
		try {
			return userService.findUsers();
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	
}
