package jp.co.noticeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.noticeboard.dto.UserDto;
import jp.co.noticeboard.dto.factory.UserDtoFactory;
import jp.co.noticeboard.mapper.UsersMapper;
import jp.co.noticeboard.utils.CipherUtil;

@Service
public class LoginService {
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private UserDtoFactory userDtoFactory;

	public UserDto getUser(String loginId, String password) {
		return userDtoFactory.create(usersMapper.getUser(loginId, CipherUtil.encrypt(password)));
	}

}
