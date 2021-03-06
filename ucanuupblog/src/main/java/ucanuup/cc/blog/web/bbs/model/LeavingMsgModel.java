package ucanuup.cc.blog.web.bbs.model;

import io.swagger.annotations.ApiModelProperty;

public class LeavingMsgModel {
	
	@ApiModelProperty(value="内容",name="content",required=true)
	private String content;
	
	@ApiModelProperty(value="父id",name="fatherId")
	private String fatherId;
	
	@ApiModelProperty(value="评论类型",name="commentType",required=true)
	private String commentType;

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

	public String getCommentType() {
		return commentType;
	}

	public void setCommentType(String commentType) {
		this.commentType = commentType;
	}
}
