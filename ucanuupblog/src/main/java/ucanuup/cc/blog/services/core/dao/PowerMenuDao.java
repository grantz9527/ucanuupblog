package ucanuup.cc.blog.services.core.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.core.entity.PowerMenu;

public interface PowerMenuDao extends CrudRepository<PowerMenu, String>,JpaSpecificationExecutor<PowerMenu> {

}
