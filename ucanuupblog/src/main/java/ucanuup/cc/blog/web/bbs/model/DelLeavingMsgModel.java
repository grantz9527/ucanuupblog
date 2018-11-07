package ucanuup.cc.blog.web.bbs.model;

import io.swagger.annotations.ApiModelProperty;

public class DelLeavingMsgModel {

	@ApiModelProperty(value="id,需要删除的评论的ID",name="id",required=true)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
