package com.huawei.domain.scenario;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author zhangxincheng
 *
 */
public interface NodeRepository extends JpaRepository<Node, Long> {

	/**
	 * ������Ԫ���ƣ�������Ԫ���󣬻�NULL<br>
	 * @param name
	 * @return
	 */
	public Node findByName(String name);
}
