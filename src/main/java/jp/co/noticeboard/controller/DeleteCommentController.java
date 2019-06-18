package jp.co.noticeboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.noticeboard.form.DeleteCommentForm;
import jp.co.noticeboard.service.DeleteCommentService;

@Controller
public class DeleteCommentController {
	@Autowired
	private DeleteCommentService deleteCommentService;

	@RequestMapping(value = "deleteComment", method = RequestMethod.POST)
	public String deleteComment(@ModelAttribute DeleteCommentForm form) {
		// コメントを削除する
		deleteCommentService.delete(form.getId());

		return "redirect:top";
	}
}
