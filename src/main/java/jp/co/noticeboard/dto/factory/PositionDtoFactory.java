package jp.co.noticeboard.dto.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.dto.PositionDto;
import jp.co.noticeboard.entity.Position;

@Component
public class PositionDtoFactory {

	/** create dtoList from entityList */
	public List<PositionDto> create(List<Position> entities) {
		List<PositionDto> list = new ArrayList<PositionDto>();
		for (Position entity : entities) {
			PositionDto dto = create(entity);
			list.add(dto);
		}
		return list;
	}

	/** create dto from entity */
	public PositionDto create(Position entity) {
		return new PositionDto(
				entity.getId(),
				entity.getName());
	}
}
