package com.huawei.domain.scenario;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author zhangxincheng
 *
 */
public interface NodeRepository extends JpaRepository<Node, Long> {

	/**
	 * 输入网元名称，返回网元对象，或NULL<br>
	 * @param name
	 * @return
	 */
	public Node findByName(String name);
}
