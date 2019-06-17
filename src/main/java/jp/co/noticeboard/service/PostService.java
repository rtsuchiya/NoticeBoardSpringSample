package jp.co.noticeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.noticeboard.dto.MessageDto;
import jp.co.noticeboard.entity.factory.MessageFactory;
import jp.co.noticeboard.mapper.MessagesMapper;

@Service
public class PostService {
	@Autowired
	private MessagesMapper messagesMapper;
	@Autowired
	private MessageFactory mesasgeFactory;

	public void regist(MessageDto dto) {
		messagesMapper.regist(mesasgeFactory.create(dto));
	}
}
