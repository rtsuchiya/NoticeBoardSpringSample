package jp.co.noticeboard.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.entity.Comment;

@Component
public interface CommentsMapper {

	List<Comment> getAll();

	void regist(Comment comment);

}
