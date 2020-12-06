package cc.ehan.security;

import cc.ehan.common.utils.BeanCopyUtils;
import cc.ehan.security.userdetails.LoginUserDetail;
import cc.ehan.system.domain.entity.SysUserEntity;
import cc.ehan.system.service.SysUserService;
import cn.hutool.core.lang.UUID;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: ehan
 * @Date: 2020/11/30 12:27
 **/
@Data
@Component
public class SecurityManager {

    /**
     * 请求头名称。
     */
    private String headerName = "Authorization";

    /**
     * 令牌秘钥
     */
    private String secret = "U2FsdGVkX1+NSbLRiGxMIAagwROxWeSPKYAbfT2/iWI=";

    /**
     * token过期时间，单位分钟
     */
    private int expireTime = 60;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SysUserService sysUserService;

    public String loginVerify(Authentication authentication) {
        Authentication authenticate = authenticationManager.authenticate(authentication);
        LoginUserDetail loginUserDetail = (LoginUserDetail) authenticate.getPrincipal();
        LoginUser loginUser = selectLoginUser(loginUserDetail);
        return null;
    }

    private String createToken(LoginUser loginUser) {
        String token = UUID.fastUUID().toString();
        return token;
    }

    private LoginUser selectLoginUser(LoginUserDetail loginUserDetail) {
        Long userId = loginUserDetail.getUserId();
        SysUserEntity sysUserEntity = sysUserService.selectById(userId);
        return BeanCopyUtils.copyPropertiesByClass(sysUserEntity, SysLoginUser.class);
    }


}
