package ucanuup.cc.blog.services.bbs.inter;

import java.util.List;

import org.springframework.stereotype.Service;

import ucanuup.cc.blog.services.bbs.dto.LeavingMsgDto;
import ucanuup.cc.blog.services.bbs.dto.LeavingMsgSonDto;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsg;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsgSon;
import ucanuup.cc.blog.services.bbs.enums.LeavingMsgType;
import ucanuup.cc.common.exceptions.ValidateException;
import ucanuup.cc.common.web.query.BaseQueryModel;
import ucanuup.cc.common.web.rt.RtPage;

@Service
public interface BlogLeavingMsgService {

	BlogLeavingMsg saveBlogLeavingMsg(BlogLeavingMsg entity);
	
	BlogLeavingMsgSon saveBlogLeavingMsgSon(BlogLeavingMsgSon entity);
	
	BlogLeavingMsg saveLeavingMsg(LeavingMsgType type,String content,String fatherId);
	
	BlogLeavingMsgSon saveLeavingMsgSon(String content,String fatherId,String call);
	
	void  deleteOneLeavingMsg(String id) throws Exception;
	
	void  addPraise(String id) throws ValidateException ;

	RtPage<LeavingMsgDto> queryLeavingMsgDto(BaseQueryModel page);
	
	List<LeavingMsgSonDto> findLeavingMsgSonDtoByfid(String fid);
}
