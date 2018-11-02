package ucanuup.cc.blog.services.core.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.core.entity.PowerManager;

public interface PowerManagerDao extends CrudRepository<PowerManager, String>,JpaSpecificationExecutor<PowerManager>{

}
