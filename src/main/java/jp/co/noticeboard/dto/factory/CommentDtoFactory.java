package jp.co.noticeboard.dto.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.dto.CommentDto;
import jp.co.noticeboard.entity.Comment;
import jp.co.noticeboard.form.CommentForm;

@Component
public class CommentDtoFactory {

	/** create dto from form */
	public CommentDto create(CommentForm form, Integer userId) {
		return new CommentDto(
				null,
				userId,
				form.getMessageId(),
				form.getText(),
				null);
	}

	/** create dtoList from entityList */
	public List<CommentDto> create(List<Comment> entityList) {
		List<CommentDto> list = new ArrayList<CommentDto>();
		for (Comment entity : entityList) {
			list.add(create(entity));
		}
		return list;
	}

	/** create dto from entity */
	public CommentDto create(Comment entity) {
		return new CommentDto(
				entity.getId(),
				entity.getUserId(),
				entity.getMessageId(),
				entity.getText(),
				entity.getCreatedAt());
	}
}
