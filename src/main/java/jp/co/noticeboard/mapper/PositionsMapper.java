package jp.co.noticeboard.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.entity.Position;

@Component
public interface PositionsMapper {
	List<Position> getAll();
}
