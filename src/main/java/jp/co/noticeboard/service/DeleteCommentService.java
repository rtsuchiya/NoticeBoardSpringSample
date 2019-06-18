package jp.co.noticeboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.noticeboard.mapper.CommentsMapper;

@Service
public class DeleteCommentService {
	@Autowired
	private CommentsMapper commentsMapper;

	public void delete(Integer id) {
		commentsMapper.delete(id);
	}
}
