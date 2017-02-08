package com.huawei.domain.project;

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
@Table(name = "project")
public class Project {

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
    private String creator;
    
    // #endregion

    // #region Constructor
    
    public Project(){}
    
    public Project(Long id){
    	this.id = id;
    }

    public Project(String name, String creator) {
        this.name = name;
        this.creator = creator;
    }

    // #endregion
}
