package ucanuup.cc.blog.services.bbs.inter;

import org.springframework.stereotype.Service;

import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsg;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsgSon;
import ucanuup.cc.blog.services.bbs.enums.LeavingMsgType;
import ucanuup.cc.common.exceptions.ValidateException;

@Service
public interface BlogLeavingMsgService {

	BlogLeavingMsg saveBlogLeavingMsg(BlogLeavingMsg entity);
	
	BlogLeavingMsgSon saveBlogLeavingMsgSon(BlogLeavingMsgSon entity);
	
	BlogLeavingMsg saveLeavingMsg(LeavingMsgType type,String content,String fatherId);
	
	BlogLeavingMsgSon saveLeavingMsgSon(String content,String fatherId,String call);
	
	void  deleteOneLeavingMsg(String id) throws Exception;
	
	void  addPraise(String id) throws ValidateException ;
}
