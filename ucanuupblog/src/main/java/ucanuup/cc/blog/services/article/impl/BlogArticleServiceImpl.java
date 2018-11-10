package ucanuup.cc.blog.services.article.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ucanuup.cc.blog.services.article.dao.BlogArticleDao;
import ucanuup.cc.blog.services.article.dto.BlogArticleDto;
import ucanuup.cc.blog.services.article.entity.BlogArticle;
import ucanuup.cc.blog.services.article.inter.BlogArticleService;
import ucanuup.cc.common.consts.AppConsts;
import ucanuup.cc.common.utils.DateUtil;
import ucanuup.cc.common.utils.StringUtil;
import ucanuup.cc.common.web.query.BaseQueryModel;
import ucanuup.cc.common.web.rt.RtPage;

@Service
public class BlogArticleServiceImpl implements BlogArticleService{

	@Autowired
	private BlogArticleDao blogArticleDao;

	@Override
	public BlogArticle saveBlogArticle(BlogArticle entity) {
		return blogArticleDao.save(entity);
	}

	@Override
	public RtPage<BlogArticleDto> queryBlogArticleDto(BaseQueryModel page) {
		return queryBlogArticleDto(page, null, null, "1");
	}
	
	private RtPage<BlogArticleDto> pop(Page<BlogArticle> rtPage){
		List<BlogArticleDto> list =  new ArrayList<BlogArticleDto>();
		BlogArticleDto dto = null ;
		if(rtPage.getContent()!=null && rtPage.getContent().size()>0) {
			for(BlogArticle msg : rtPage.getContent()) {
				dto = new BlogArticleDto();
				dto.setArticleContent(msg.getArticleContent());
				dto.setArticleDesc(msg.getArticleDesc());
				dto.setArticleName(msg.getArticleName());
				dto.setCreateDate(DateUtil.formartDateNYRSF(msg.getCreatedAt()));
				dto.setPriase(msg.getPraise() == null ? 0 : msg.getPraise());
				list.add(dto);
			}
		}
		return new RtPage<>(rtPage.getPageable().getPageNumber(), rtPage.getPageable().getPageSize(), list, rtPage.getTotalElements());
	}

	@Override
	public RtPage<BlogArticleDto> queryBlogArticleDto(BaseQueryModel page, String firstType, String[] nextType,String isPublish) {
		// 获取排序信息
		PageRequest pageable = PageRequest.of(page.getPageNo(), page.getPageSize(), Direction.DESC, "createdAt");
		Specification<BlogArticle> spec = new Specification<BlogArticle>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<BlogArticle> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				// 查询未删除的信息
				Predicate deleted = criteriaBuilder.equal(root.get("deleted").as(Integer.class),AppConsts.DELETED_EXIST);
				list.add(deleted);
				// 查询   是否发布
				if(StringUtil.isNotEmpty(isPublish)) {
					Predicate publish = criteriaBuilder.equal(root.get("publishFlag").as(String.class),isPublish);
					list.add(publish);
				}
				// 查询  第一类别
				if(StringUtil.isNotEmpty(firstType)) {
					Predicate first = criteriaBuilder.equal(root.get("firstType").as(String.class),firstType);
					list.add(first);
				}
				// 查询 第二类别
				if(nextType != null && nextType.length >0) {
					Predicate[] arr = new Predicate[nextType.length];
					for(int i = 0 ; i< nextType.length ; i++) {
						arr[i] = criteriaBuilder.like(root.get("nextType").as(String.class), "%" + nextType[i] + "%");
					}
					Predicate next = criteriaBuilder.or(arr);
					list.add(next);
				}
				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		};
		
		Page<BlogArticle> rtPage = blogArticleDao.findAll(spec, pageable);
		return pop(rtPage);
	}
	
	
}
