package ucanuup.cc.blog.web.core.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ucanuup.cc.blog.services.core.entity.User;
import ucanuup.cc.blog.services.core.inter.UserService;
import ucanuup.cc.blog.web.core.model.LoginInfoModel;
import ucanuup.cc.blog.web.core.model.RegisterModel;
import ucanuup.cc.common.utils.PasswordUtil;
import ucanuup.cc.common.web.rt.RtMsg;
import ucanuup.cc.common.web.rt.RtType;

@RestController
@Api(value = "UserLoginController", description = "用户登录以及注册接口", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserLoginController {
	
	@Resource
	private UserService userService;

	@PostMapping("login")
	@ApiOperation(value = "登录认证接口", notes = "传入用户信息及密码提交认证")
	public RtMsg<String> login(@RequestBody @ApiParam(name="登录认证",value="传入json格式",required=true) LoginInfoModel model){
		User user = new User();
		user.setEmail(model.getUsername());
		user.setUserAccount(model.getUsername());
		user.setPhone(model.getUsername());
		user.setUserPassword(PasswordUtil.desLock(model.getPassword()));
		User u = userService.findLogin(user);
		if(u == null) {
			return new RtMsg<String>(RtType.VALID,"这里传递错误信息！");
		}else {
			return new RtMsg<String>(RtType.OK,"这里传递认证通过的token！");
		}
	}
	
	@PostMapping("logout")
	@ApiOperation(value = "用户登出接口", notes = "用于用户登出")
	public RtMsg<String> logout(@RequestBody @ApiParam(name="登出登录",value="传入json格式",required=true) LoginInfoModel model){
		
		return new RtMsg<String>(RtType.VALID,"sdfjslkdfj");
	}
	
	@PostMapping("check")
	@ApiOperation(value = "检验认证用户信息", notes = "检验用户token 是否合法")
	public RtMsg<String> check(@RequestParam(name="token",required=true) @ApiParam(name="token信息",value="jwtToken",required=true) String token){
		
		return new RtMsg<String>(RtType.VALID,"sdfjslkdfj");
	}
	
	@PostMapping("register")
	@ApiOperation(value = "注册用户信息", notes = "提交注册用户信息")
	public RtMsg<String> register(@RequestBody @ApiParam(name="用户信息",value="传入json格式",required=true) RegisterModel model){
		
		return new RtMsg<String>(RtType.VALID,"sdfjslkdfj");
	}
	
}
