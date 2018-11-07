package ucanuup.cc.blog.services.bbs.inter;

import org.springframework.stereotype.Service;

import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsg;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsgSun;

@Service
public interface BlogLeavingMsgService {

	BlogLeavingMsg saveBlogLeavingMsg(BlogLeavingMsg entity);
	
	BlogLeavingMsgSun saveBlogLeavingMsgSun(BlogLeavingMsgSun entity);
}
