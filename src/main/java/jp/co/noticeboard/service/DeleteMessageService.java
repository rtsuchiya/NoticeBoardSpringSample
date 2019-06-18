package jp.co.noticeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.noticeboard.mapper.MessagesMapper;

@Service
public class DeleteMessageService {
	@Autowired
	private MessagesMapper messagesMapper;

	public void delete(Integer id) {
		messagesMapper.delete(id);
	}
}
