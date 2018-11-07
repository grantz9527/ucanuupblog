package ucanuup.cc.blog.services.bbs.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsgSun;

public interface BlogLeavingMsgSunDao  extends CrudRepository<BlogLeavingMsgSun, String>,JpaSpecificationExecutor<BlogLeavingMsgSun>{

}
