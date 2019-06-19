package jp.co.noticeboard.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

	public List<MessageDto> getMessageList(String category, String startDate, String endDate) {

		// categoryがnullの場合は明示的に空文字にする
		if (StringUtils.isEmpty(category)) {
			category = "";
		}

		// 開始日と終了日の補正を行う
		if (StringUtils.isEmpty(startDate)) {
			startDate = "2019-01-01 00:00:00";
		} else {
			startDate += " 00:00:00";
		}
		if (StringUtils.isEmpty(endDate)) {
			endDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		} else {
			endDate += " 23:59:59";
		}

		return messageDtoFactory.create(messagesMapper.getAll(category, startDate, endDate));
	}

	public List<CommentDto> getCommentList() {
		return commentsDtoFactory.create(commentsMapper.getAll());
	}

}
