package jp.co.noticeboard.form.factory;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.dto.UserDto;
import jp.co.noticeboard.form.EditForm;

@Component
public class EditFormFactory {

	/** create form from dto */
	public EditForm create(UserDto dto) {
		EditForm form = new EditForm();
		form.setId(dto.getId());
		form.setLoginId(dto.getLoginId());
		form.setAccountName(dto.getName());
		form.setBranchId(dto.getBranchId().toString());
		form.setPositionId(dto.getPositionId().toString());
		return form;
	}
}
