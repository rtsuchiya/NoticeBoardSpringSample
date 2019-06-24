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
import jp.co.noticeboard.dto.factory.CommentDtoFactory;
import jp.co.noticeboard.form.CommentForm;
import jp.co.noticeboard.service.CommentService;

@Controller
public class CommentController {
	@Autowired
	private HttpSession session;
	@Autowired
	private CommentService commentService;
	@Autowired
	private CommentDtoFactory commentDtoFactory;

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public String comment(@ModelAttribute @Valid CommentForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "redirect:top";
		}

		// コメントを登録する
		commentService.regist(commentDtoFactory.create(form, ((UserDto) session.getAttribute("loginUser")).getId()));

		return "redirect:top";
	}
}
