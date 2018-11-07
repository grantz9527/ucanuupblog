package ucanuup.cc.blog.services.bbs.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsg;

public interface BlogLeavingMsgDao  extends CrudRepository<BlogLeavingMsg, String>,JpaSpecificationExecutor<BlogLeavingMsg>{

}
