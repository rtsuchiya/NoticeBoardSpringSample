package jp.co.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.noticeboard.dto.MessageDto;
import jp.co.noticeboard.dto.factory.MessageDtoFactory;
import jp.co.noticeboard.mapper.MessagesMapper;

@Service
public class TopService {
	@Autowired
	private MessagesMapper messagesMapper;
	@Autowired
	private MessageDtoFactory messageDtoFactory;

	public List<MessageDto> getAll() {
		return messageDtoFactory.create(messagesMapper.getAll());
	}

}
