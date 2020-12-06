package cc.ehan.security;

import cc.ehan.security.userdetails.LoginUserDetail;
import cn.hutool.core.lang.UUID;
import lombok.Data;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

/**
 * @Description:
 * @Author: ehan
 * @Date: 2020/11/30 12:27
 **/
@Data
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

    private AuthenticationManager authenticationManager;

    public String loginVerify(Authentication authentication) {
        Authentication authenticate = authenticationManager.authenticate(authentication);
        LoginUserDetail loginUser = (LoginUserDetail) authenticate.getPrincipal();
        return null;
    }

    private String createToken(LoginUserDetail loginUserDetail) {
        String token = UUID.fastUUID().toString();
        return null;
    }


}
