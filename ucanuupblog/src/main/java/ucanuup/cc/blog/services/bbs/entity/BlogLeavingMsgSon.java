package ucanuup.cc.blog.services.bbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ucanuup.cc.config.db.jpa.BaseEntity;

@Table(name="BLOG_LEAVING_MSG_SON")
@Entity
public class BlogLeavingMsgSon  extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	/**留言内容*/
	@Column(name="CONTENT",length=500,nullable=false)
	private String content;
	
	/**父表主键*/
	@Column(name="FATHER_ID",length=36)
	private String fatherId;
	
	/**评论@的人*/
	@Column(name="CALLED",length=36)
	private String called;
	
	@Column(name="PRAISE",columnDefinition=" INTEGER comment '点赞数' ")
	private Integer praise;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFatherId() {
		return fatherId;
	}

	public String getCalled() {
		return called;
	}

	public void setCalled(String called) {
		this.called = called;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}


	public Integer getPraise() {
		return praise;
	}

	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	
}
