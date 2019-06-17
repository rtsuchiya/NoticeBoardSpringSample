package jp.co.noticeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.noticeboard.dto.UserDto;
import jp.co.noticeboard.entity.factory.UserFactory;
import jp.co.noticeboard.mapper.UsersMapper;

@Service
public class ChangeStatusService {
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private UserFactory userFactory;

	public void update(UserDto dto) {
		usersMapper.updateIsWorking(userFactory.create(dto));
	}
}
