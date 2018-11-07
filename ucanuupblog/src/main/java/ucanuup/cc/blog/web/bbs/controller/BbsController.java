package ucanuup.cc.blog.web.bbs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsg;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsgSun;
import ucanuup.cc.blog.services.bbs.enums.LeavingMsgType;
import ucanuup.cc.blog.services.bbs.inter.BlogLeavingMsgService;
import ucanuup.cc.blog.web.bbs.model.DelLeavingMsgModel;
import ucanuup.cc.blog.web.bbs.model.LeavingMsgModel;
import ucanuup.cc.blog.web.bbs.model.LeavingMsgSunModel;
import ucanuup.cc.common.web.query.BaseQueryModel;
import ucanuup.cc.common.web.rt.RtMsg;
import ucanuup.cc.common.web.rt.RtType;

@Controller
@RequestMapping("bbs")
public class BbsController {
	
	@Autowired
	private BlogLeavingMsgService blogLeavingMsgService;

	@GetMapping({"","/","index"})
	public String index(){
		return "blog/bbs/index";
	}
	
	@GetMapping("list")
	@ApiOperation(value = "查询留言板分页信息", notes = "查询留言板分页信息")
	public RtMsg<String> list(@RequestBody @ApiParam(name="分页查询条件",value="分页查询条件") BaseQueryModel model){
		
		return new RtMsg<String>(RtType.VALID,"sdfjslkdfj");
	}
	
	@PostMapping("addLeavingMsg")
	@ApiOperation(value = "添加留言", notes = "添加留言评论,第一级别的评论 ,直接评论!")
	public RtMsg<String> addLeavingMsg(@RequestBody @ApiParam(name="请求修改密码对象",value="传入json格式",required=true) LeavingMsgModel model){
		if(LeavingMsgType.BBS.getType().equals(model.getCommentType())) {
			BlogLeavingMsg msg = blogLeavingMsgService.saveLeavingMsg(LeavingMsgType.BBS, model.getContent(), null);
			if(msg == null) {
				return new RtMsg<String>(RtType.VALID,"评论失败!");
			}
		}else if(LeavingMsgType.ARTICLE.getType().equals(model.getCommentType())) {
			BlogLeavingMsg msg = blogLeavingMsgService.saveLeavingMsg(LeavingMsgType.ARTICLE, model.getContent(), model.getFatherId());
			if(msg == null) {
				return new RtMsg<String>(RtType.VALID,"评论失败!");
			}
		}else {
			return new RtMsg<String>(RtType.VALID,"没有正确的评论类型!");
		}
		return new RtMsg<String>(RtType.OK,"评论成功!");
	}
	
	@PostMapping("addLeavingMsgSun")
	@ApiOperation(value = "添加留言子评论", notes = "添加留言子评论,在留言下添加评论信息!")
	public RtMsg<String> addLeavingMsgSun(@RequestBody @ApiParam(name="请求修改密码对象",value="传入json格式",required=true) LeavingMsgSunModel model){
		BlogLeavingMsgSun sun = blogLeavingMsgService.saveLeavingMsgSun(model.getContent(), model.getFatherId(), model.getCall());
		if(sun!=null) {
			return new RtMsg<String>(RtType.OK,"评论成功!");
		}
		return new RtMsg<String>(RtType.VALID,"评论失败!");
	}
	
	@PostMapping("delLeavingMsg")
	@ApiOperation(value = "删除留言", notes = "删除留言信息,包含子评论")
	public RtMsg<String> delLeavingMsg(@RequestBody @ApiParam(name="请求修改密码对象",value="传入json格式",required=true) DelLeavingMsgModel model) throws Exception{
		blogLeavingMsgService.deleteOneLeavingMsg(model.getId());
		return new RtMsg<String>(RtType.OK,"删除成功!");
	}
}
