package ucanuup.cc.blog.web.core.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ucanuup.cc.blog.web.core.model.RegisterModel;
import ucanuup.cc.common.web.rt.RtMsg;
import ucanuup.cc.common.web.rt.RtType;

@Controller
@Api(value = "BaseController", description = "登录，登出，注册，基础服务接口", produces = MediaType.APPLICATION_JSON_VALUE)
public class BaseController {
	
	@PostMapping("application")
	@ApiOperation(value = "请求修改，推送改密信息", notes = "用于修改验证")
	public RtMsg<String> application(@RequestBody @ApiParam(name="请求修改密码对象",value="传入json格式",required=true) RegisterModel model){
		
		return new RtMsg<String>(RtType.VALID,"sdfjslkdfj");
	}
	
	@PostMapping("update")
	@ApiOperation(value = "修改密码", notes = "用于修改用户的账户及密码")
	public RtMsg<String> update(@RequestBody @ApiParam(name="修改密码对象",value="传入json格式",required=true) RegisterModel model){
		
		return new RtMsg<String>(RtType.VALID,"sdfjslkdfj");
	}
}
