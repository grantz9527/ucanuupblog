package ucanuup.cc.blog.services.article.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ucanuup.cc.blog.services.article.entity.BlogArticle;

public interface BlogArticleDao  extends CrudRepository<BlogArticle, String>,JpaSpecificationExecutor<BlogArticle>{

}
