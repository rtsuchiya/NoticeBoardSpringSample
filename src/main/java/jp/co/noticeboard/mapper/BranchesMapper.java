package jp.co.noticeboard.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.noticeboard.entity.Branch;

@Component
public interface BranchesMapper {
	List<Branch> getAll();
}
