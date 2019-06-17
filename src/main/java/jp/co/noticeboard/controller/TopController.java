package jp.co.noticeboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.noticeboard.dto.MessageDto;
import jp.co.noticeboard.service.TopService;

@Controller
public class TopController {
	@Autowired
	private TopService topService;

	@RequestMapping(value = "/top", method = RequestMethod.GET)
	public String top() {
		return "/top";
	}

	@ModelAttribute("messageList")
	public List<MessageDto> getMessageList() {
		return topService.getAll();
	}

}
