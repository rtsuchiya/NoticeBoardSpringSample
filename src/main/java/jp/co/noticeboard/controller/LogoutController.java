package jp.co.noticeboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	@Autowired
	private HttpSession session;

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		// セッションを削除
		session.invalidate();

		return "redirect:login";
	}
}
