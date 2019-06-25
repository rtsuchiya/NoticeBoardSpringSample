package jp.co.noticeboard.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.noticeboard.dto.BranchDto;
import jp.co.noticeboard.dto.PositionDto;
import jp.co.noticeboard.dto.factory.UserDtoFactory;
import jp.co.noticeboard.form.SignupForm;
import jp.co.noticeboard.service.SignupService;

@Controller
public class SignupController {
	@Autowired
	private SignupService signupService;
	@Autowired
	private UserDtoFactory userDtoFactory;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@ModelAttribute SignupForm signupForm, Model model) {
		model.addAttribute("signupForm", signupForm);
		return "/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute @Valid SignupForm signupForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "/signup";
		}

		try {
			signupService.registUser(userDtoFactory.create(signupForm));
		} catch (DuplicateKeyException ex) {
			result.rejectValue("loginId", "ログインIDが既に使用されています", "ログインIDが既に使用されています");
			return "/signup";
		}

		return "redirect:management";
	}

	@ModelAttribute("branchList")
	public List<BranchDto> getBranchList() {
		return signupService.getBranchList();
	}

	@ModelAttribute("positionList")
	public List<PositionDto> getPositionList() {
		return signupService.getPositionList();
	}
}
