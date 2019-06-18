package jp.co.noticeboard.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.entity.Message;

@Component
public interface MessagesMapper {

	List<Message> getAll();

	void regist(Message message);

	void delete(Integer id);
}
