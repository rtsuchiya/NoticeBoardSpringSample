package jp.co.noticeboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.noticeboard.dto.factory.UserDtoFactory;
import jp.co.noticeboard.form.ChangeStatusForm;
import jp.co.noticeboard.service.ChangeStatusService;

@Controller
public class ChangeStatusController {
	@Autowired
	private ChangeStatusService changeStatusService;
	@Autowired
	private UserDtoFactory userDtoFactory;

	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
	public String changeStatus(@ModelAttribute ChangeStatusForm form) {
		// 停止復活フラグを更新
		changeStatusService.update(userDtoFactory.create(form));

		return "redirect:management";
	}
}
