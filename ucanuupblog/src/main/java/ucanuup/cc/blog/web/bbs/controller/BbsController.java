package ucanuup.cc.blog.web.bbs.controller;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ucanuup.cc.blog.services.bbs.dto.LeavingMsgDto;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsg;
import ucanuup.cc.blog.services.bbs.entity.BlogLeavingMsgSon;
import ucanuup.cc.blog.services.bbs.enums.LeavingMsgType;
import ucanuup.cc.blog.services.bbs.inter.BlogLeavingMsgService;
import ucanuup.cc.blog.web.bbs.model.DelLeavingMsgModel;
import ucanuup.cc.blog.web.bbs.model.LeavingMsgModel;
import ucanuup.cc.blog.web.bbs.model.LeavingMsgSonModel;
import ucanuup.cc.blog.web.bbs.model.PriaseModel;
import ucanuup.cc.common.utils.AppUtil;
import ucanuup.cc.common.utils.StringUtil;
import ucanuup.cc.common.utils.supportobj.UserInfo;
import ucanuup.cc.common.web.query.BaseQueryModel;
import ucanuup.cc.common.web.rt.RtMsg;
import ucanuup.cc.common.web.rt.RtPage;
import ucanuup.cc.common.web.rt.RtType;

@Controller
@RequestMapping("bbs")
@Api(value = "BbsController", description = "留言接口模块", produces = MediaType.APPLICATION_JSON_VALUE)
public class BbsController {
	
	@Autowired
	private BlogLeavingMsgService blogLeavingMsgService;

	@GetMapping({"","/","index"})
	public String index(){
		return "blog/bbs/index";
	}
	
	@GetMapping("list")
	@ApiOperation(value = "查询留言板分页信息", notes = "查询留言板分页信息")
	@ResponseBody
	public Object list(@ApiParam(name="分页查询条件",value="分页查询条件") BaseQueryModel page){
		RtPage<LeavingMsgDto> rs = blogLeavingMsgService.queryLeavingMsgDto(page);
		return rs;
	}
	
	@GetMapping("addLeavingMsg")
	@ApiOperation(value = "添加评论", notes = "添加留言评论,第一级别的评论 ,直接评论!")
	@ResponseBody
	public Object addLeavingMsg(@ApiParam(name="请求修改密码对象",value="传入json格式") LeavingMsgModel model){
		/*UserInfo user = AppUtil.getUser();
		if(user == null || StringUtil.isEmpty(user.getId()) ) {
			 ObjectMapper mapper = new ObjectMapper();
			 RtMsg fruit= new RtMsg<String>(RtType.LOGIN,"还没有登录哟,无法评论!");
		        String mapJakcson = null;
				try {
					mapJakcson = mapper.writeValueAsString(fruit);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
		        System.out.println(mapJakcson);
			return new RtMsg<Object>(RtType.LOGIN,"还没有登录哟,无法评论!");
		}*/
		if(LeavingMsgType.BBS.getType().equals(model.getCommentType())) {
			BlogLeavingMsg msg = blogLeavingMsgService.saveLeavingMsg(LeavingMsgType.BBS, model.getContent() , null);
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
	@ApiOperation(value = "添加子评论", notes = "添加留言子评论,在留言下添加评论信息!")
	@ResponseBody
	public Object addLeavingMsgSun(@RequestBody @ApiParam(name="请求修改密码对象",value="传入json格式",required=true) LeavingMsgSonModel model){
		UserInfo user = AppUtil.getUser();
		if(user == null || StringUtil.isEmpty(user.getId()) ) {
			return new RtMsg<String>(RtType.LOGIN,"还没有登录哟,无法评论!");
		}
		BlogLeavingMsgSon sun = blogLeavingMsgService.saveLeavingMsgSon(model.getContent(), model.getFatherId(), model.getCall());
		if(sun!=null) {
			return new RtMsg<String>(RtType.OK,"评论成功!");
		}
		return new RtMsg<String>(RtType.VALID,"评论失败!");
	}
	
	@PostMapping("addPraise")
	@ApiOperation(value = "赞一下", notes = "赞该条评论!")
	@ResponseBody
	public Object addPraise(@RequestBody @ApiParam(name="赞一下",value="传入json格式,主键ID",required=true) PriaseModel model){
		UserInfo user = AppUtil.getUser();
		if(user == null || StringUtil.isEmpty(user.getId()) ) {
			return new RtMsg<String>(RtType.LOGIN,"还没有登录哟,无法评论!");
		}
		
		return new RtMsg<String>(RtType.VALID,"赞该条评论失败!");
	}
	
	@PostMapping("delLeavingMsg")
	//@PreAuthorize("hasAuthority('bbs:delLeavingMsg')")
	@ApiOperation(value = "删除留言", notes = "删除留言信息,包含子评论!")
	@ResponseBody
	public Object delLeavingMsg(@RequestBody @ApiParam(name="请求修改密码对象",value="传入json格式",required=true) DelLeavingMsgModel model) throws Exception{
		blogLeavingMsgService.deleteOneLeavingMsg(model.getId());
		return new RtMsg<String>(RtType.OK,"删除成功!");
	}
}
