package ucanuup.cc.blog.services.bbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ucanuup.cc.config.db.jpa.BaseEntity;

@Table(name="BLOG_LEAVING_MSG")
@Entity
public class BlogLeavingMsg extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**留言内容*/
	@Column(name="CONTENT",length=2000,nullable=false)
	private String content;
	
	/**信息类型*/
	@Column(name="MSG_TYPE",length=50,nullable=false)
	private String msgType;
	
	/**信息类型*/
	@Column(name="FATHER_ID",length=36)
	private String fatherId;
	
	@Column(name="PRAISE",columnDefinition=" INTEGER comment '点赞数' ")
	private Integer praise;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getFatherId() {
		return fatherId;
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
