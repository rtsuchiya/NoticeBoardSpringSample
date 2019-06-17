package jp.co.noticeboard.entity.factory;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.dto.UserDto;
import jp.co.noticeboard.entity.User;
import jp.co.noticeboard.utils.CipherUtil;

@Component
public class UserFactory {

	/** create entity from dto */
	public User create(UserDto dto) {
		return new User(
				dto.getId(),
				dto.getLoginId(),
				dto.getPassword(),
				dto.getName(),
				dto.getBranchId(),
				dto.getPositionId(),
				dto.getIsWorking(),
				null,
				null);
	}

	/** create entity from dto */
	public User createEncrypt(UserDto dto) {
		return new User(
				dto.getId(),
				dto.getLoginId(),
				CipherUtil.encrypt(dto.getPassword()),
				dto.getName(),
				dto.getBranchId(),
				dto.getPositionId(),
				dto.getIsWorking(),
				null,
				null);
	}
}
