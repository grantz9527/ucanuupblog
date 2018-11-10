package ucanuup.cc.blog.services.article.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ucanuup.cc.config.db.jpa.BaseEntity;

@Table(name="BLOG_ARTICLE")
@Entity
public class BlogArticle  extends BaseEntity{

	private static final long serialVersionUID = 1L;

	
	/**文章名*/
	@Column(name="ARTICLE_NAME",length=255,nullable=false)
	private String articleName;
	
	/**文章描述,摘要*/
	@Column(name="ARTICLE_DESC",length=500,nullable=false)
	private String articleDesc;
	
	/**文章内容*/
	@Column(name="ARTICLE_Content",nullable=false,columnDefinition=" LONGTEXT comment '内容' ")
	private String articleContent;
	
	@Column(name="PRAISE",columnDefinition=" INTEGER comment '点赞数' ")
	private Integer praise;
	
	/**一级类别*/
	@Column(name="FIRST_TYPE",length=20,nullable=false)
	private String firstType;
	
	/**二级类别*/
	@Column(name="NEXT_TYPE",length=300,nullable=false)
	private String nextType;
	
	/**是否发布 ， 1 是  0 否*/
	@Column(name="PUBLISH_FLAG",columnDefinition=" varchar(2) comment '是否发布 ， 1 是  0 否' ")
	private String publishFlag;

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public String getArticleDesc() {
		return articleDesc;
	}

	public void setArticleDesc(String articleDesc) {
		this.articleDesc = articleDesc;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getFirstType() {
		return firstType;
	}

	public void setFirstType(String firstType) {
		this.firstType = firstType;
	}

	public String getNextType() {
		return nextType;
	}

	public void setNextType(String nextType) {
		this.nextType = nextType;
	}

	public Integer getPraise() {
		return praise;
	}

	public void setPraise(Integer praise) {
		this.praise = praise;
	}

	public String getPublishFlag() {
		return publishFlag;
	}

	public void setPublishFlag(String publishFlag) {
		this.publishFlag = publishFlag;
	}
}
