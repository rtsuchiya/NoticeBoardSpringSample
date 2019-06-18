package jp.co.noticeboard.dto.factory;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.dto.CommentDto;
import jp.co.noticeboard.form.CommentForm;

@Component
public class CommentDtoFactory {

	/** create dto from form */
	public CommentDto create(CommentForm form, Integer userId) {
		return new CommentDto(
				userId,
				form.getMessageId(),
				form.getText());
	}
}
