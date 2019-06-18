package jp.co.noticeboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.noticeboard.form.DeleteMessageForm;
import jp.co.noticeboard.service.DeleteMessageService;

@Controller
public class DeleteMessageController {
	@Autowired
	private DeleteMessageService deleteMessageService;

	@RequestMapping(value = "deleteMessage", method = RequestMethod.POST)
	public String deleteMessage(@ModelAttribute DeleteMessageForm form) {
		// 投稿を削除する
		deleteMessageService.delete(form.getId());

		return "redirect:top";
	}
}
