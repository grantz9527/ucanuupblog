package ucanuup.cc.blog.services.bbs.dto;

import java.util.List;

public class LeavingMsgDto {
	
	private String content;
	
	private String headpic;
	
	private String priase;
	
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

	public String getPriase() {
		return priase;
	}

	public void setPriase(String priase) {
		this.priase = priase;
	}
}

