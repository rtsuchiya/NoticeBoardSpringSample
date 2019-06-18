package jp.co.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.noticeboard.dto.CommentDto;
import jp.co.noticeboard.dto.MessageDto;
import jp.co.noticeboard.dto.factory.CommentDtoFactory;
import jp.co.noticeboard.dto.factory.MessageDtoFactory;
import jp.co.noticeboard.mapper.CommentsMapper;
import jp.co.noticeboard.mapper.MessagesMapper;

@Service
public class TopService {
	@Autowired
	private MessagesMapper messagesMapper;
	@Autowired
	private CommentsMapper commentsMapper;
	@Autowired
	private MessageDtoFactory messageDtoFactory;
	@Autowired
	private CommentDtoFactory commentsDtoFactory;

	public List<MessageDto> getMessageList() {
		return messageDtoFactory.create(messagesMapper.getAll());
	}

	public List<CommentDto> getCommentList() {
		return commentsDtoFactory.create(commentsMapper.getAll());
	}

}
