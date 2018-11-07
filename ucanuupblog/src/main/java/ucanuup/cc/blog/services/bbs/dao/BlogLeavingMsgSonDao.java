package ucanuup.cc.blog.services.bbs.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsgSon;

public interface BlogLeavingMsgSonDao  extends CrudRepository<BlogLeavingMsgSon, String>,JpaSpecificationExecutor<BlogLeavingMsgSon>{

}
