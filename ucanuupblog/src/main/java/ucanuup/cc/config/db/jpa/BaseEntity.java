package ucanuup.cc.config.db.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 文件名： com.bozhon.config.BaseEntity.java
 * 作者：   WenBin
 * 日期：   2017年11月24日
 * 功能说明： 基础的实体类
 * =========================================================
 * 修改记录：
 * 修改作者    日期      修改内容
 * =========================================================
 *  Copyright (c) 2010-2011 .All rights reserved.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID",length=36)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "system-uuid")
	protected String id;
	@Column(name="CREATED_AT")
	@CreatedDate
	protected Date createdAt;
	@Column(name="CREATED_BY",length=36)
	@CreatedBy
	protected String createdBy;
	@Column(name="UPDATED_AT")
	@LastModifiedDate
	protected Date updatedAt;
	@Column(name="UPDATED_BY",length=36)
	@LastModifiedBy
	protected String updatedBy;
	// 1 删除  0  未删除
	@Column(name="DELETED",precision=1,scale=0,nullable=false)
	protected Integer deleted = 0;
	@Version
	protected Long version = 0L;

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public Date getCreatedAt() {

		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {

		this.createdAt = createdAt;
	}

	public String getCreatedBy() {

		return createdBy;
	}

	public void setCreatedBy(String createdBy) {

		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() {

		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {

		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {

		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {

		this.updatedBy = updatedBy;
	}

	public Integer getDeleted() {

		return deleted;
	}

	public void setDeleted(Integer deleted) {

		this.deleted = deleted;
	}

	public Long  getVersion() {

		return version;
	}

	public void setVersion(Long  version) {

		this.version = version;
	}
}
