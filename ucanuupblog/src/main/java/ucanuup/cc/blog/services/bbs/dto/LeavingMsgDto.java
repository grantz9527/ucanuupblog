package ucanuup.cc.blog.services.bbs.dto;

import java.util.List;

public class LeavingMsgDto {
	
	private String content;
	
	private String headpic;
	
	private String userName;
	
	private Integer priase;
	
	List<LeavingMsgSonDto> son;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHeadpic() {
		return headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}

	public List<LeavingMsgSonDto> getSon() {
		return son;
	}

	public void setSon(List<LeavingMsgSonDto> son) {
		this.son = son;
	}

	public Integer getPriase() {
		return priase;
	}

	public void setPriase(Integer priase) {
		this.priase = priase;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}

