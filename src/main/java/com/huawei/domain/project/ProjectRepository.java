package com.huawei.domain.project;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author zhangxincheng
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

	/**
	 * ���빤���������ع��̶���<br>
	 * @param name
	 * @return
	 */
	public Project findByName(String name);
}
