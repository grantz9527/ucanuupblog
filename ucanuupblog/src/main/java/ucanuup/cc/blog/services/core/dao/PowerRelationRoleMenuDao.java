package ucanuup.cc.blog.services.core.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.core.entity.PowerRelationRoleMenu;

public interface PowerRelationRoleMenuDao   extends CrudRepository<PowerRelationRoleMenu, String>,JpaSpecificationExecutor<PowerRelationRoleMenu> {

}
