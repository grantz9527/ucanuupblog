package ucanuup.cc.blog.services.article.dto;

public class BlogArticleDto {
	
	private String id ;

	/**文章名*/
	private String articleName;
	
	/**文章描述,摘要*/
	private String articleDesc;
	
	/**文章内容*/
	private String articleContent;
	
	/**赞的数量*/
	private Integer priase;
	
	/**创建日期*/
	private String createDate;

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

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public Integer getPriase() {
		return priase;
	}

	public void setPriase(Integer priase) {
		this.priase = priase;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
