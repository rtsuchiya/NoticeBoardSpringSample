package jp.co.noticeboard.entity.factory;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.dto.CommentDto;
import jp.co.noticeboard.entity.Comment;

@Component
public class CommentFactory {

	public Comment create(CommentDto dto) {
		return new Comment(
				null,
				dto.getUserId(),
				null,
				dto.getMessageId(),
				dto.getText(),
				null,
				null);
	}
}
