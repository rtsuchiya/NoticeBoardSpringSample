package jp.co.noticeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.noticeboard.dto.CommentDto;
import jp.co.noticeboard.entity.factory.CommentFactory;
import jp.co.noticeboard.mapper.CommentsMapper;

@Service
public class CommentService {
	@Autowired
	private CommentsMapper commentsMapper;
	@Autowired
	private CommentFactory commentFactory;

	public void regist(CommentDto dto) {
		commentsMapper.regist(commentFactory.create(dto));
	}
}
