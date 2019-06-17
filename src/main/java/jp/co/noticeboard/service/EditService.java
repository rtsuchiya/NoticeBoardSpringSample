package jp.co.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.noticeboard.dto.BranchDto;
import jp.co.noticeboard.dto.PositionDto;
import jp.co.noticeboard.dto.UserDto;
import jp.co.noticeboard.dto.factory.BranchDtoFactory;
import jp.co.noticeboard.dto.factory.PositionDtoFactory;
import jp.co.noticeboard.dto.factory.UserDtoFactory;
import jp.co.noticeboard.entity.factory.UserFactory;
import jp.co.noticeboard.mapper.BranchesMapper;
import jp.co.noticeboard.mapper.PositionsMapper;
import jp.co.noticeboard.mapper.UsersMapper;

@Service
public class EditService {
	@Autowired
	private UsersMapper usersMapper;
	@Autowired
	private BranchesMapper branchesMapper;
	@Autowired
	private PositionsMapper positionsMapper;
	@Autowired
	private UserDtoFactory userDtoFactory;
	@Autowired
	private BranchDtoFactory branchDtoFactory;
	@Autowired
	private PositionDtoFactory positionDtoFactory;
	@Autowired
	private UserFactory userFactory;

	public UserDto getEditUser(Integer id) {
		return userDtoFactory.create(usersMapper.getUserById(id));
	}

	public void update(UserDto dto) {
		usersMapper.update(userFactory.create(dto));
	}

	public List<BranchDto> getBranchList() {
		return branchDtoFactory.create(branchesMapper.getAll());
	}

	public List<PositionDto> getPositionList() {
		return positionDtoFactory.create(positionsMapper.getAll());
	}

}
