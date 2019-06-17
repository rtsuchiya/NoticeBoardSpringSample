package jp.co.noticeboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.noticeboard.dto.UserManagementDto;
import jp.co.noticeboard.form.ChangeStatusForm;
import jp.co.noticeboard.form.ManagementForm;
import jp.co.noticeboard.service.ManagementService;

@Controller
public class ManagementController {
	@Autowired
	private ManagementService managementService;

	@RequestMapping(value = "/management", method = RequestMethod.GET)
	public String management(Model model) {
		model.addAttribute("managementForm", new ManagementForm());
		model.addAttribute("changeStatusForm", new ChangeStatusForm());
		return "/management";
	}

	@ModelAttribute("userList")
	public List<UserManagementDto> getUserList() {
		return managementService.getUsers();
	}
}
