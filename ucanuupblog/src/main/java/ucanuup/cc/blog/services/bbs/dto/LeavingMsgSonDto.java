package ucanuup.cc.blog.services.bbs.dto;

public class LeavingMsgSonDto {
	
	private String content;
	
	private String headpic;
	
	private String userName;
	
	private Integer priase;
	
	private String call;

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

	public Integer getPriase() {
		return priase;
	}

	public void setPriase(Integer priase) {
		this.priase = priase;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}

