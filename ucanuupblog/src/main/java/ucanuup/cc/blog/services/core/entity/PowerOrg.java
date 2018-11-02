package ucanuup.cc.blog.services.core.entity;

import javax.persistence.Column;

public class PowerOrg {

	/**账号-唯一*/
	@Column(name="USER_ACCOUNT",length=255,nullable=false)
	private String userAccount;
	/**部门路径*/
	@Column(name="ORG_PATH",length=300)
	private String orgPath;
	/**组织目录*/
	@Column(name="ORG_PATH_NAME",length=600)
	private String orgPathName;
	/**部门名称*/
	@Column(name="ORG_NAME",length=255)
	private String orgName;
	/**公司名称*/
	@Column(name="COMPANY_NAME",length=255)
	private String companyName;
	
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getOrgPath() {
		return orgPath;
	}
	public void setOrgPath(String orgPath) {
		this.orgPath = orgPath;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getOrgPathName() {
		return orgPathName;
	}
	public void setOrgPathName(String orgPathName) {
		this.orgPathName = orgPathName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
