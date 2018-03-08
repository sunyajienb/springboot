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
			result.setResult("�����ɹ�");
		} catch (Exception e) {
			log.error("�����û�ʧ��:" + user + " " + e.getMessage());
			result.setCode("-10001");
			result.setResult("����ʧ��");
			result.setReason("�������ڲ�����");
		}
		return result;
	}

	@DeleteMapping(value="/{id}")
	public Result deleteUser(@PathVariable int id) {
		Result result = new Result();
		
		try {
			userService.deleteUser(id);
			result.setCode("+00000");
			result.setResult("�����ɹ�");
		} catch (Exception e) {
			log.error("ɾ���û�ʧ�ܣ�" + id + " " + e.getMessage());
			result.setCode("-10002");
			result.setResult("ɾ��ʧ��");
			result.setReason("�������ڲ�����");
		}
		return result;
	}

	@PutMapping
	public Result updateUser(User user) {
		Result result = new Result();
		
		try {
			userService.updateUser(user);
			result.setCode("+00000");
			result.setResult("�����ɹ�");
		} catch (Exception e) {
			log.error("�����û�ʧ�ܣ�" + user + " " + e.getMessage());
			result.setCode("-10003");
			result.setResult("����ʧ��");
			result.setReason("�������ڲ�����");
		}
		return result;
	}

	@GetMapping(value="/{id}")
	public User findUserById(@PathVariable int id) {
		User user = null;
		try {
			user = userService.findUserById(id);
		} catch (Exception e) {
			log.error("��ѯ�û�ʧ�ܣ�" + id);
		}
		
		return user;
	}

	@GetMapping(value="/all")
	public List<User> findUsers() {
		try {
			return userService.findUsers();
		} catch (Exception e) {
			log.error("��ѯ�����û�ʧ��");
			return Collections.emptyList();
		}
	}
	
}
