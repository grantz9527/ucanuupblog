package ucanuup.cc.blog.services.core.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.core.entity.PowerRole;

public interface PowerRoleDao extends CrudRepository<PowerRole, String>,JpaSpecificationExecutor<PowerRole> {

}
