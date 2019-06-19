package jp.co.noticeboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.noticeboard.dto.CommentDto;
import jp.co.noticeboard.dto.MessageDto;
import jp.co.noticeboard.form.CommentForm;
import jp.co.noticeboard.form.DeleteCommentForm;
import jp.co.noticeboard.form.DeleteMessageForm;
import jp.co.noticeboard.form.SearchForm;
import jp.co.noticeboard.service.TopService;

@Controller
public class TopController {
	@Autowired
	private TopService topService;

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String top(@ModelAttribute SearchForm searchForm, Model model) {
		model.addAttribute("commentForm", new CommentForm());
		model.addAttribute("searchForm", searchForm);
		model.addAttribute("deleteMessageForm", new DeleteMessageForm());
		model.addAttribute("deleteCommentForm", new DeleteCommentForm());
		return "/top";
	}

	@ModelAttribute("messageList")
	public List<MessageDto> getMessageList(@ModelAttribute SearchForm searchForm) {
		return topService.getMessageList(searchForm.getCategory(), searchForm.getStartDate(), searchForm.getEndDate());
	}

	@ModelAttribute("commentList")
	public List<CommentDto> getCommentList() {
		return topService.getCommentList();
	}

}
