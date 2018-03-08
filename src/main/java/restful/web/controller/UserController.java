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

import restful.bean.Result;
import restful.bean.User;
import restful.service.UserService;

@RestController
@RequestMapping(path={"/user"})
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public Result addUser(User user) {
		Result result = new Result();
		
		try {
			userService.addUser(user);
			result.setCode("+00000");
			result.setResult("操作成功");
		} catch (Exception e) {
			log.error("插入用户失败:" + user + " " + e.getMessage());
			result.setCode("-10001");
			result.setResult("插入失败");
			result.setReason("服务器内部错误");
		}
		return result;
	}

	@DeleteMapping(value="/{id}")
	public Result deleteUser(@PathVariable int id) {
		Result result = new Result();
		
		try {
			userService.deleteUser(id);
			result.setCode("+00000");
			result.setResult("操作成功");
		} catch (Exception e) {
			log.error("删除用户失败：" + id + " " + e.getMessage());
			result.setCode("-10002");
			result.setResult("删除失败");
			result.setReason("服务器内部错误");
		}
		return result;
	}

	@PutMapping
	public Result updateUser(User user) {
		Result result = new Result();
		
		try {
			userService.updateUser(user);
			result.setCode("+00000");
			result.setResult("操作成功");
		} catch (Exception e) {
			log.error("更新用户失败：" + user + " " + e.getMessage());
			result.setCode("-10003");
			result.setResult("更新失败");
			result.setReason("服务器内部错误");
		}
		return result;
	}

	@GetMapping(value="/{id}")
	public User findUserById(@PathVariable int id) {
		User user = null;
		try {
			user = userService.findUserById(id);
		} catch (Exception e) {
			log.error("查询用户失败：" + id);
		}
		
		return user;
	}

	@GetMapping(value="/all")
	public List<User> findUsers() {
		try {
			return userService.findUsers();
		} catch (Exception e) {
			log.error("查询所有用户失败");
			return Collections.emptyList();
		}
	}
	
}
