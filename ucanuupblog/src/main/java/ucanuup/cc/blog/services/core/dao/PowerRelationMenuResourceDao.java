package ucanuup.cc.blog.services.core.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.core.entity.PowerRelationMenuResource;

public interface PowerRelationMenuResourceDao   extends CrudRepository<PowerRelationMenuResource, String>,JpaSpecificationExecutor<PowerRelationMenuResource> {

}
