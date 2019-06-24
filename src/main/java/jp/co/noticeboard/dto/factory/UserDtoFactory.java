package jp.co.noticeboard.dto.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import jp.co.noticeboard.dto.UserDto;
import jp.co.noticeboard.dto.UserManagementDto;
import jp.co.noticeboard.entity.User;
import jp.co.noticeboard.entity.UserManagement;
import jp.co.noticeboard.form.ChangeStatusForm;
import jp.co.noticeboard.form.EditForm;
import jp.co.noticeboard.form.SignupForm;

@Component
public class UserDtoFactory {

	/** create dto from form */
	public UserDto create(SignupForm form) {
		return new UserDto(
				null,
				form.getLoginId(),
				form.getPassword(),
				form.getAccountName(),
				form.getBranchId(),
				form.getPositionId(),
				1);
	}

	/** create dto from fom */
	public UserDto create(EditForm form) {
		if (StringUtils.isEmpty(form.getPassword())) {
			form.setPassword(null);
		}
		return new UserDto(
				form.getId(),
				form.getLoginId(),
				form.getPassword(),
				form.getAccountName(),
				form.getBranchId(),
				form.getPositionId(),
				null);
	}

	/** create dto from fom */
	public UserDto create(ChangeStatusForm form) {
		return new UserDto(
				form.getId(),
				null,
				null,
				null,
				null,
				null,
				form.getIsWorking());
	}

	/** create dto from entity */
	public UserDto create(User entity) {
		if (entity == null) {
			return null;
		}
		return new UserDto(
				entity.getId(),
				entity.getLoginId(),
				entity.getPassword(),
				entity.getName(),
				entity.getBranchId(),
				entity.getPositionId(),
				entity.getIsWorking());
	}

	/** create dtoList from entityList */
	public List<UserManagementDto> create(List<UserManagement> entityList) {
		List<UserManagementDto> list = new ArrayList<UserManagementDto>();
		for (UserManagement entity : entityList) {
			list.add(create(entity));
		}
		return list;
	}

	/** create dto from entity */
	public UserManagementDto create(UserManagement entity) {
		return new UserManagementDto(
				entity.getId(),
				entity.getLoginId(),
				entity.getName(),
				entity.getBranchId(),
				entity.getBranchName(),
				entity.getPositionId(),
				entity.getPositionName(),
				entity.getIsWorking());
	}
}
