package jp.co.noticeboard.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.noticeboard.dto.UserDto;
import jp.co.noticeboard.form.LoginForm;
import jp.co.noticeboard.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute LoginForm loginForm, Model model, BindingResult result) {
		model.addAttribute("loginForm", loginForm);
		return "/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute @Valid LoginForm loginForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("loginForm", loginForm);
			return "/login";
		}

		UserDto user = loginService.getUser(loginForm.getLoginId(), loginForm.getPassword());
		if (user == null || user.getIsWorking() != 1) {
			result.rejectValue("loginId", "ログインに失敗しました", "ログインに失敗しました");
			return "/login";
		}

		session.setAttribute("loginUser", user);

		return "redirect:top";
	}
}
