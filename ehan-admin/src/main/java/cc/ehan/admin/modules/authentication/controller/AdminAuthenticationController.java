package cc.ehan.admin.modules.authentication.controller;

import cc.ehan.admin.modules.authentication.domain.ao.LoginAccountAO;
import cc.ehan.admin.modules.authentication.domain.vo.LoginUserVO;
import cc.ehan.admin.modules.authentication.service.AdminAuthenticationService;
import cc.ehan.admin.security.LoginUser;
import cc.ehan.common.base.Result;
import cc.ehan.common.utils.BeanCopyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@Api(tags = "认证相关接口")
public class AdminAuthenticationController {

    @Autowired
    private AdminAuthenticationService adminAuthenticationService;

    @ApiOperation("使用账号密码登录")
    @PostMapping("loginByAccount")
    public Result<String> loginByAccount(@RequestBody LoginAccountAO account) {
        String token = adminAuthenticationService.loginByAccount(account);
        return Result.success(token);
    }

    @ApiOperation("获取当前登录的用户信息")
    @GetMapping("user")
    public Result<LoginUserVO> getLoginUserInfo() {
        LoginUser loginUser = adminAuthenticationService.getOwnerLoginUser();
        LoginUserVO loginUserVO = BeanCopyUtils.copyPropertiesByClass(loginUser, LoginUserVO.class);
        return Result.success(loginUserVO);
    }
}
