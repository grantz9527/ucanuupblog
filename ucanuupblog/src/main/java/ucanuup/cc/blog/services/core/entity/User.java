package ucanuup.cc.blog.services.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ucanuup.cc.config.db.jpa.BaseEntity;


@Table(name="TB_USER")
@Entity
public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	/**账号-唯一*/
	@Column(name="USER_ACCOUNT",length=255,nullable=false,unique=true)
	private String userAccount;
	
	/**密码-不可为空*/
	@Column(name="USER_PASSWORD",length=255,nullable=false)
	private String userPassword;
	
	/**邮箱-唯一*/
	@Column(name="EMAIL",length=300,nullable=false,unique=true)
	private String email;
	
	/**电话-唯一*/
	@Column(name="PHONE",length=30,nullable=false,unique=true)
	private String phone;

	public String getUserAccount() {

		return userAccount;
	}

	public void setUserAccount(String userAccount) {

		this.userAccount = userAccount;
	}

	public String getUserPassword() {

		return userPassword;
	}

	public void setUserPassword(String userPassword) {

		this.userPassword = userPassword;
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
}
