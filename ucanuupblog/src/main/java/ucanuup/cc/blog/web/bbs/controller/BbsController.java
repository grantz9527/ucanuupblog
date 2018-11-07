package ucanuup.cc.blog.web.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ucanuup.cc.blog.web.bbs.model.LeavingMsgModel;
import ucanuup.cc.blog.web.core.model.RegisterModel;
import ucanuup.cc.common.web.query.BaseQueryModel;
import ucanuup.cc.common.web.rt.RtMsg;
import ucanuup.cc.common.web.rt.RtType;

@Controller
@RequestMapping("bbs")
public class BbsController {

	@GetMapping({"","/","index"})
	public String index(){
		return "blog/bbs/index";
	}
	
	@GetMapping("list")
	@ApiOperation(value = "查询留言板分页信息", notes = "查询留言板分页信息")
	public RtMsg<String> list(@RequestBody @ApiParam(name="分页查询条件",value="传入json格式") BaseQueryModel model){
		
		return new RtMsg<String>(RtType.VALID,"sdfjslkdfj");
	}
	
	@PostMapping("addLeavingMsg")
	@ApiOperation(value = "添加留言", notes = "添加留言评论,第一级别的评论 ,直接评论!")
	public RtMsg<String> addLeavingMsg(@RequestBody @ApiParam(name="请求修改密码对象",value="传入json格式",required=true) LeavingMsgModel model){
		
		return new RtMsg<String>(RtType.VALID,"sdfjslkdfj");
	}
	
	@PostMapping("addLeavingMsgSun")
	@ApiOperation(value = "添加留言子评论", notes = "添加留言子评论,在留言下添加评论信息")
	public RtMsg<String> addLeavingMsgSun(@RequestBody @ApiParam(name="请求修改密码对象",value="传入json格式",required=true) LeavingMsgModel model){
		
		return new RtMsg<String>(RtType.VALID,"sdfjslkdfj");
	}
	
	@PostMapping("delLeavingMsg")
	@ApiOperation(value = "删除留言", notes = "删除留言信息,包含子评论")
	public RtMsg<String> delLeavingMsg(@RequestBody @ApiParam(name="请求修改密码对象",value="传入json格式",required=true) RegisterModel model){
		
		return new RtMsg<String>(RtType.VALID,"sdfjslkdfj");
	}
}
