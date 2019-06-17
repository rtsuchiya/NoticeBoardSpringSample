package jp.co.noticeboard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.noticeboard.dto.BranchDto;
import jp.co.noticeboard.dto.PositionDto;
import jp.co.noticeboard.dto.UserDto;
import jp.co.noticeboard.dto.factory.UserDtoFactory;
import jp.co.noticeboard.form.EditForm;
import jp.co.noticeboard.form.ManagementForm;
import jp.co.noticeboard.form.factory.EditFormFactory;
import jp.co.noticeboard.service.EditService;

@Controller
public class EditController {
	@Autowired
	private EditService editService;
	@Autowired
	private EditFormFactory editFormFactory;
	@Autowired
	private UserDtoFactory userDtoFactory;

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(@ModelAttribute ManagementForm managementForm, Model model) {
		// 編集対象のユーザー情報を取得する
		UserDto editUser = editService.getEditUser(managementForm.getId());

		// TODO 存在しないユーザーの場合

		model.addAttribute("editForm", editFormFactory.create(editUser));
		return "/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute @Valid EditForm editForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "/edit";
		}
		// TODO PK重複エラー
		editService.update(userDtoFactory.create(editForm));

		return "redirect:management";
	}

	@ModelAttribute("branchList")
	public List<BranchDto> getBranchList() {
		return editService.getBranchList();
	}

	@ModelAttribute("positionList")
	public List<PositionDto> getPositionList() {
		return editService.getPositionList();
	}
}
