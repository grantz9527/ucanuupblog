package ucanuup.cc.blog.services.core.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.core.entity.PowerRelationUserRole;

public interface PowerRelationUserRoleDao   extends CrudRepository<PowerRelationUserRole, String>,JpaSpecificationExecutor<PowerRelationUserRole> {

}
