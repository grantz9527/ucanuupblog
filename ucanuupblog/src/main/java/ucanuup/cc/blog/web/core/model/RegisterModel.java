package ucanuup.cc.blog.web.core.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * 注册信息的基本类型信息
 */
public class RegisterModel {
	
	@ApiModelProperty(value="用户名",name="userName",required=true)
	private String userName;
	
	@ApiModelProperty(value="邮箱",name="email",required=true)
	private String email;
	
	@ApiModelProperty(value="电话",name="phone",required=true)
	private String phone;
	
	@ApiModelProperty(value="密码",name="password",required=true)
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
