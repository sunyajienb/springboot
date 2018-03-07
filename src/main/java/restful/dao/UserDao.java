package restful.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import restful.bean.User;

@Mapper
public interface UserDao {
	
	@Insert("insert into user(name,password) values(#{name},#{password})")
	void addUser(User user) throws Exception;
	
	@Delete("delete from user where id = #{id}")
	void deleteUser(int id) throws Exception;
	
	@Update("update user set name = #{name},password = #{password} where id = #{id}")
	void updateUser(User user) throws Exception;
	
	@Select("select name,password from user where id = #{id}")
	User findUserById(int id) throws Exception;
	
	@Select("select * from user")
	List<User> findUsers() throws Exception;
	
}
