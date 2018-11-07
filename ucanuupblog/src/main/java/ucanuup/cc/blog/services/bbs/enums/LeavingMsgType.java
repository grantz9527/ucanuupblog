package ucanuup.cc.blog.services.bbs.enums;

public enum LeavingMsgType {

	BBS("BBS"),ARTICLE("ARTICLE");
	
	LeavingMsgType(String type){
		this.type = type;
	}
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
