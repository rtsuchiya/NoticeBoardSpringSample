package jp.co.noticeboard.dto.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.dto.BranchDto;
import jp.co.noticeboard.entity.Branch;

@Component
public class BranchDtoFactory {

	/** create dtoList from entityList */
	public List<BranchDto> create(List<Branch> entityList) {
		List<BranchDto> list = new ArrayList<BranchDto>();
		for (Branch entity : entityList) {
			BranchDto dto = create(entity);
			list.add(dto);
		}
		return list;
	}

	/** create dto from entity */
	public BranchDto create(Branch entity) {
		return new BranchDto(
				entity.getId(),
				entity.getName());
	}
}
