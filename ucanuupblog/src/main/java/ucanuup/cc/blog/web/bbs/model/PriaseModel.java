package ucanuup.cc.blog.web.bbs.model;

import io.swagger.annotations.ApiModelProperty;

public class PriaseModel {

	@ApiModelProperty(value="id,需要赞的ID",name="id",required=true)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
