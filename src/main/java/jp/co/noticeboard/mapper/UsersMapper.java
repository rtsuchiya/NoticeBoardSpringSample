package jp.co.noticeboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import jp.co.noticeboard.entity.User;
import jp.co.noticeboard.entity.UserManagement;

@Component
public interface UsersMapper {
	User getUser(@Param("loginId") String loginId, @Param("password") String password);

	User getUserById(@Param("id") Integer id);

	List<UserManagement> getAllForManagement();

	void regist(User user);

	void update(User user);

	void updateIsWorking(User user);
}
