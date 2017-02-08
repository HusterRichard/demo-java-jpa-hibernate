package com.huawei.domain.project;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author zhangxincheng
 *
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

	/**
	 * 输入工程名，返回工程对象<br>
	 * @param name
	 * @return
	 */
	public Project findByName(String name);
}
