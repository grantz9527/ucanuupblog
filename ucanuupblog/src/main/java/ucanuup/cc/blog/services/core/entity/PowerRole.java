package ucanuup.cc.blog.services.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ucanuup.cc.config.db.jpa.BaseEntity;

@Table(name="POWER_ROLE")
@Entity
public class PowerRole extends BaseEntity{

	private static final long serialVersionUID = 1L;

	/**角色描述*/
	@Column(name="ROLE_DESC", columnDefinition = " varchar(255)  comment '角色描述'")
	private String roleDesc;
	
	/**角色名称*/
	@Column(name="ROLE_NAME", columnDefinition = " varchar(36)  comment '角色名称'")
	private String roleName;
	
	/**角色名称*/
	@Column(name="ROLE_PERMISSION", columnDefinition = " varchar(36)  comment '角色权限'")
	private String rolePermission;
	
	/**系统类型 -用于区分权限所属系统*/
	@Column(name="SYSTEM_TYPE", columnDefinition = " varchar(36)  comment '系统类型'")
	private Long systemType;
	
	/**权限类型  -用于区分用户的权限级别 */
	@Column(name="POWER_TYPE", columnDefinition = " varchar(36)  comment '权限类型  默认-default 用户-user 部门-dept 管理员-manager'")
	private String powerType;
	
	/**状态 1启用 0 失效*/
	@Column(name="STATUS")
	private Long status;
	
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Long getSystemType() {
		return systemType;
	}
	public void setSystemType(Long systemType) {
		this.systemType = systemType;
	}
	public String getPowerType() {
		return powerType;
	}
	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
}
