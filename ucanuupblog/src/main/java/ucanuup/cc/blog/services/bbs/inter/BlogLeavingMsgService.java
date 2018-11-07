package ucanuup.cc.blog.services.bbs.inter;

import org.springframework.stereotype.Service;

import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsg;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsgSun;
import ucanuup.cc.blog.services.bbs.enums.LeavingMsgType;

@Service
public interface BlogLeavingMsgService {

	BlogLeavingMsg saveBlogLeavingMsg(BlogLeavingMsg entity);
	
	BlogLeavingMsgSun saveBlogLeavingMsgSun(BlogLeavingMsgSun entity);
	
	BlogLeavingMsg saveLeavingMsg(LeavingMsgType type,String content,String fatherId);
	
	void  deleteOneLeavingMsg(String id) throws Exception;
}
