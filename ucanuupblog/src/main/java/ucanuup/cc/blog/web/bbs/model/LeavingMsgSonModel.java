package ucanuup.cc.blog.web.bbs.model;

import io.swagger.annotations.ApiModelProperty;

public class LeavingMsgSonModel {
	
	@ApiModelProperty(value="内容",name="content",required=true)
	private String content;
	
	@ApiModelProperty(value="父id",name="fatherId",required=true)
	private String fatherId;
	
	@ApiModelProperty(value="@的用户,回复的用户",name="call",required=true)
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

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}
}
