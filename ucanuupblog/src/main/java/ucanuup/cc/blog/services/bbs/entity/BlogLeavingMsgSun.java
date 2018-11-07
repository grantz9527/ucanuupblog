package ucanuup.cc.blog.services.bbs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ucanuup.cc.config.db.jpa.BaseEntity;

@Table(name="BLOG_LEAVING_MSG_SUN")
@Entity
public class BlogLeavingMsgSun  extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	/**留言内容*/
	@Column(name="CONTENT",length=500,nullable=false)
	private String content;
	
	/**父表主键*/
	@Column(name="FATHER_ID",length=36)
	private String fatherId;
	
	/**本表主键*/
	@Column(name="MOTHER_ID",length=36)
	private String motherId;
	
	/**评论@的人*/
	@Column(name="CALL",length=36)
	private String call;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFatherId() {
		return fatherId;
	}

	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}

	public String getMotherId() {
		return motherId;
	}

	public void setMotherId(String motherId) {
		this.motherId = motherId;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}
}
