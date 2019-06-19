package jp.co.noticeboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import jp.co.noticeboard.entity.Message;

@Component
public interface MessagesMapper {

	List<Message> getAll(@Param("category") String category,
			@Param("startDate") String startDate,
			@Param("endDate") String endDate);

	void regist(Message message);

	void delete(Integer id);
}
