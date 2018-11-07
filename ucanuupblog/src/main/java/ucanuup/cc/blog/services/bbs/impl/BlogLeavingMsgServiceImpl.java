package ucanuup.cc.blog.services.bbs.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ucanuup.cc.blog.services.bbs.dao.BlogLeavingMsgDao;
import ucanuup.cc.blog.services.bbs.dao.BlogLeavingMsgSonDao;
import ucanuup.cc.blog.services.bbs.dto.LeavingMsgDto;
import ucanuup.cc.blog.services.bbs.dto.LeavingMsgSonDto;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsg;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsgSon;
import ucanuup.cc.blog.services.bbs.enums.LeavingMsgType;
import ucanuup.cc.blog.services.bbs.inter.BlogLeavingMsgService;
import ucanuup.cc.common.consts.AppConsts;
import ucanuup.cc.common.exceptions.ValidateException;
import ucanuup.cc.common.utils.StringUtil;
import ucanuup.cc.common.web.query.BaseQueryModel;
import ucanuup.cc.common.web.rt.RtPage;

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

	@Override
	public void addPraise(String id) throws ValidateException {
		BlogLeavingMsg msg = blogLeavingMsgDao.findById(id).get();
		if(msg == null) {
			BlogLeavingMsgSon msgSon = blogLeavingMsgSonDao.findById(id).get();
			if(msgSon == null) {
				throw new ValidateException("BlogLeavingMsgServiceImpl.addPraise:请传入正确的主键ID!");
			}else {
				msgSon.setPraise(msgSon.getPraise()+1);
				blogLeavingMsgSonDao.save(msgSon);
			}
		}else {
			msg.setPraise(msg.getPraise()+1);
			blogLeavingMsgDao.save(msg);
		}
	}

	@Override
	public RtPage<LeavingMsgDto> queryLeavingMsgDto(BaseQueryModel page) {
		return null;
	}

	@Override
	public List<LeavingMsgSonDto> findLeavingMsgSonDtoByfid(String fid) {
		List<LeavingMsgSonDto> list =  new ArrayList<LeavingMsgSonDto>();
		LeavingMsgSonDto dto = null ;
		if(StringUtil.isNotEmpty(fid)){
			return list;
		}
		
		Specification<BlogLeavingMsgSon> spec = new Specification<BlogLeavingMsgSon>() {

			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<BlogLeavingMsgSon> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				// 查询未删除的信息
				Predicate deleted = criteriaBuilder.equal(root.get("deleted").as(Integer.class),AppConsts.DELETED_EXIST);
				list.add(deleted);
				Predicate et = criteriaBuilder.equal(root.<String>get("fatherId"), fid);
				list.add(et);
				Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		};
		@SuppressWarnings("deprecation")
		Sort sort  = new Sort(Order.desc("createdAt"));
		List<BlogLeavingMsgSon> rs = blogLeavingMsgSonDao.findAll(spec, sort);
		if(rs!=null && rs.size()>0) {
			for(BlogLeavingMsgSon son : rs) {
				dto = new LeavingMsgSonDto();
				dto.setContent(son.getContent());
				dto.setHeadpic("");
				dto.setPriase(son.getPraise());
				dto.setCall(son.getCall());
				list.add(dto);
			}
		}
		return list;
	}

}
