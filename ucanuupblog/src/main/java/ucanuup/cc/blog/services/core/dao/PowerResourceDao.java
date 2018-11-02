package ucanuup.cc.blog.services.core.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.core.entity.PowerResource;

public interface PowerResourceDao   extends CrudRepository<PowerResource, String>,JpaSpecificationExecutor<PowerResource> {

}
