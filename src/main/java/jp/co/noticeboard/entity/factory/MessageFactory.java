package jp.co.noticeboard.entity.factory;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.dto.MessageDto;
import jp.co.noticeboard.entity.Message;

@Component
public class MessageFactory {

	/** create entity from dto */
	public Message create(MessageDto dto) {
		return new Message(
				null,
				dto.getUserId(),
				null,
				dto.getSubject(),
				dto.getText(),
				dto.getCategory(),
				null,
				null);
	}
}
