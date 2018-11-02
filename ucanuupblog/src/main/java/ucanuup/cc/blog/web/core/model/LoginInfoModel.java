package ucanuup.cc.blog.web.core.model;

import io.swagger.annotations.ApiModelProperty;

public class LoginInfoModel {

	@ApiModelProperty(value="账户（账号，邮箱，手机号）",name="username",required=true)
	private String username;
	
	@ApiModelProperty(value="密码",name="password",required=true)
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
