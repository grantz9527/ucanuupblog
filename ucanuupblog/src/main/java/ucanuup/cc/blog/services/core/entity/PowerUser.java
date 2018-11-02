package ucanuup.cc.blog.services.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ucanuup.cc.config.db.jpa.BaseEntity;

@Table(name="POWER_USER")
@Entity
public class PowerUser extends BaseEntity{

	private static final long serialVersionUID = 1L;

	/**账号-唯一*/
	@Column(name="USER_ACCOUNT",length=255,nullable=false,unique=true)
	private String userAccount;
	
	/**账号-唯一*/
	@Column(name="USER_NAME",length=255,nullable=false)
	private String userName;

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
