package ucanuup.cc.common.web.rt;

import java.util.List;

public class RtPage<T> implements RtBasePage{

	private List<T> content;
	
	private Long total;
	
	private Integer pageSize;
	
	private Integer pageNo;
	
	public RtPage(){
		
	}
	
	public RtPage(Integer pageNo,Integer pageSize,List<T> content,Long total){
		this.content 	= content;
		this.total 		= total;
		this.pageNo 	= pageNo;
		this.pageSize 	= pageSize;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
}
