package ucanuup.cc.blog.services.about.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.about.entity.BlogAbout;

public interface BlogAboutDao  extends CrudRepository<BlogAbout, String>,JpaSpecificationExecutor<BlogAbout>{

}
