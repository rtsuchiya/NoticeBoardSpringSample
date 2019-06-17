package jp.co.noticeboard.dto.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.dto.MessageDto;
import jp.co.noticeboard.entity.Message;
import jp.co.noticeboard.form.PostForm;

@Component
public class MessageDtoFactory {

	/** create dto from form */
	public MessageDto create(PostForm form, Integer userId) {
		return new MessageDto(
				null,
				userId,
				form.getSubject(),
				form.getText(),
				form.getCategory(),
				null,
				null);
	}

	/** create dtoList from entityList */
	public List<MessageDto> create(List<Message> entityList) {
		List<MessageDto> list = new ArrayList<MessageDto>();
		for (Message entity : entityList) {
			list.add(create(entity));
		}
		return list;
	}

	/** create dto from entity */
	public MessageDto create(Message entity) {
		return new MessageDto(
				entity.getId(),
				entity.getUserId(),
				entity.getSubject(),
				entity.getText(),
				entity.getCategory(),
				entity.getCreatedAt(),
				entity.getUpdatedAt());
	}
}
