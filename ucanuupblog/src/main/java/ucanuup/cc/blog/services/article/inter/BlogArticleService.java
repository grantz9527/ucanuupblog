package ucanuup.cc.blog.services.article.inter;

import org.springframework.stereotype.Service;

import ucanuup.cc.blog.services.article.dto.BlogArticleDto;
import ucanuup.cc.blog.services.article.entity.BlogArticle;
import ucanuup.cc.common.web.query.BaseQueryModel;
import ucanuup.cc.common.web.rt.RtPage;

@Service
public interface BlogArticleService {

	
	BlogArticle saveBlogArticle(BlogArticle entity);
	
	RtPage<BlogArticleDto> queryBlogArticleDto(BaseQueryModel page);
	
	RtPage<BlogArticleDto> queryBlogArticleDto(BaseQueryModel page,String firstType,String[] nextType,String isPublish);
}
