package ucanuup.cc.blog.services.bbs.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucanuup.cc.blog.services.bbs.dao.BlogLeavingMsgDao;
import ucanuup.cc.blog.services.bbs.dao.BlogLeavingMsgSonDao;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsg;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsgSon;
import ucanuup.cc.blog.services.bbs.enums.LeavingMsgType;
import ucanuup.cc.blog.services.bbs.inter.BlogLeavingMsgService;
import ucanuup.cc.common.utils.StringUtil;

@Service
public class BlogLeavingMsgServiceImpl implements BlogLeavingMsgService{

	@Autowired
	private BlogLeavingMsgDao blogLeavingMsgDao;
	
	@Autowired
	private BlogLeavingMsgSonDao blogLeavingMsgSonDao;
	
	// 保存一条评价
	@Override
	public BlogLeavingMsg saveBlogLeavingMsg(BlogLeavingMsg entity) {
		return blogLeavingMsgDao.save(entity);
	}

	// 保存一条子评论
	@Override
	public BlogLeavingMsgSon saveBlogLeavingMsgSon(BlogLeavingMsgSon entity) {
		return blogLeavingMsgSonDao.save(entity);
	}

	// 创建一条新的评论
	@Override
	public BlogLeavingMsg saveLeavingMsg(LeavingMsgType type, String content,String fatherId) {
		BlogLeavingMsg entity = new BlogLeavingMsg();
		entity.setMsgType(type.getType());
		entity.setContent(content);
		entity.setPraise(0); //默认为0个赞
		if(!LeavingMsgType.BBS.getType().equals(type.getType())) {
			entity.setFatherId(fatherId);
		}
		return saveBlogLeavingMsg(entity);
	}
	
	// 创建一条子评论
	@Override
	public BlogLeavingMsgSon saveLeavingMsgSon(String content, String fatherId, String call) {
		BlogLeavingMsgSon entity = new BlogLeavingMsgSon();
		entity.setCall(call);
		entity.setContent(content);
		entity.setFatherId(fatherId);
		entity.setPraise(0); //默认为0个赞
		return saveBlogLeavingMsgSon(entity);
	}
	
	@Override
	public void deleteOneLeavingMsg(String id) throws Exception {
		if(StringUtil.isEmpty(id)) {
			throw new Exception("BlogLeavingMsgServiceImpl.deleteOneLeavingMsg:请传入正确的主键ID,传入值为空串或为null");
		}else {
			Optional<BlogLeavingMsg> msg = blogLeavingMsgDao.findById(id);
			BlogLeavingMsg obj = msg.get();
			if(obj!=null) {
				// 如果留言信息存在
				
				// 优先删除自评论信息
				
				// 删除评论信息
			}else {
				// 删除子评论信息
				Optional<BlogLeavingMsgSon> sun = blogLeavingMsgSonDao.findById(id);
				BlogLeavingMsgSon sunMsg = sun.get();
				if(sunMsg==null) {
					throw new Exception("BlogLeavingMsgServiceImpl.deleteOneLeavingMsg:请传入正确的主键ID,为查询到正确的结果!");
				}
			}
		}
	}

}
