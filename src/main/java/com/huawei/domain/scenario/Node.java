package com.huawei.domain.scenario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * @author zhangxincheng
 *
 */
@Entity
@Table(name = "node")
public class Node {

	// #region Fields
	
    @Id
    @GeneratedValue
    @Setter
    @Getter
    private Long id;

    @Column(nullable = false)
    @Setter
    @Getter
    private String name;

    @Column(nullable = false)
    @Setter
    @Getter
    private String vendor;
    
    // #endreigon

    // #region Constructor
    
    public Node(){}

    public Node(Long id)
    {
    	this.id = id;
    }
    
    public Node(String name, String vendor) {
        this.name = name;
        this.vendor = vendor;
    }
    
    // #endregion
}
