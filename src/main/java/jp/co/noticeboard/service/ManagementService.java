package jp.co.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.noticeboard.dto.UserManagementDto;
import jp.co.noticeboard.dto.factory.UserDtoFactory;
import jp.co.noticeboard.mapper.UsersMapper;

@Service
public class ManagementService {
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private UserDtoFactory userDtoFactory;

	public List<UserManagementDto> getUsers() {
		return userDtoFactory.create(usersMapper.getAllForManagement());
	}

}
