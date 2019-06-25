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
import jp.co.noticeboard.dto.factory.MessageDtoFactory;
import jp.co.noticeboard.form.PostForm;
import jp.co.noticeboard.service.PostService;

@Controller
public class PostController {
	@Autowired
	private HttpSession session;
	@Autowired
	private PostService postService;
	@Autowired
	private MessageDtoFactory messageDtoFactory;

	@RequestMapping(value = "/post", method = RequestMethod.GET)
	public String post(@ModelAttribute PostForm postForm, Model model) {
		model.addAttribute("postForm", postForm);
		return "/post";
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String post(@ModelAttribute @Valid PostForm postForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("postForm", postForm);
			return "/post";
		}

		// 投稿を登録する
		postService.regist(messageDtoFactory.create(postForm, ((UserDto) session.getAttribute("loginUser")).getId()));

		return "redirect:top";
	}
}
