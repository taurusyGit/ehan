package cc.ehan.admin.security;

import cc.ehan.admin.security.userdetails.LoginUserDetail;
import cc.ehan.common.utils.BeanCopyUtils;
import cc.ehan.common.utils.ServletUtils;
import cc.ehan.system.domain.entity.SystemUserEntity;
import cc.ehan.system.service.SystemUserService;
import cn.hutool.core.lang.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: ehan
 * @Date: 2020/11/30 12:27
 **/
@Component
public class SecurityManager {

    /**
     * 请求头名称。
     */
    public static String AUTHENTICATION_HEADER_NAME = "Authentication";

    /**
     * 令牌秘钥
     */
    private String secret = "U2FsdGVkX1+NSbLRiGxMIAagwROxWeSPKYAbfT2/iWI=";

    /**
     * token过期时间，单位分钟
     */
    private int expireTime = 60;

    /**
     * 当token的有效期小于该单位时间时，将重置token的过期时间。单位分钟
     */
    private int refreshMinValidityTime = 40;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SystemUserService sysUserService;

    private RedisTemplate<String, LoginUser> redisTemplate;

    private ValueOperations<String, LoginUser> valueOperations;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, LoginUser> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.valueOperations = redisTemplate.opsForValue();
    }

    private String keyPrefix = "authentication:";

    private String createKey(String token) {
        return keyPrefix + token;
    }

    public String getToken(HttpServletRequest request) {
        String token = request.getHeader(AUTHENTICATION_HEADER_NAME);
        return token;
    }

    /**
     * 获取当前请求的用户信息
     * 如果当前请求的用户会话已过期时，将返回null
     *
     * @return
     */
    public LoginUser getLoginUser() {
        HttpServletRequest request = ServletUtils.getRequest();
        String token = getToken(request);
        return getLoginUser(token);
    }

    /**
     * 刷新token有效期
     *
     * @param loginUser
     */
    public void refreshToken(LoginUser loginUser) {
        String token = loginUser.getToken();
        String key = createKey(token);
        Long expire = redisTemplate.getExpire(key, TimeUnit.MINUTES);
        if (expire < refreshMinValidityTime) {
            redisTemplate.expire(key, expireTime, TimeUnit.MINUTES);
        }
    }

    /**
     * 根据token获取对应的用户信息
     * 当token为空、token无对应的用户信息、token对应的用户会话已过期时，返回null。
     *
     * @param token
     * @return
     */
    public LoginUser getLoginUser(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        LoginUser loginUser = valueOperations.get(createKey(token));
        return loginUser;
    }

    public String loginVerify(Authentication authentication) throws AuthenticationException {
        Authentication authenticate = authenticationManager.authenticate(authentication);
        LoginUserDetail loginUserDetail = (LoginUserDetail) authenticate.getPrincipal();
        LoginUser loginUser = selectLoginUser(loginUserDetail);
        String token = createToken(loginUser);
        valueOperations.set(createKey(token), loginUser, expireTime, TimeUnit.MINUTES);
        return token;
    }

    private String createToken(LoginUser loginUser) {
        String token = UUID.fastUUID().toString();
        loginUser.setToken(token);
        return token;
    }

    private LoginUser selectLoginUser(LoginUserDetail loginUserDetail) {
        Long userId = loginUserDetail.getUserId();
        SystemUserEntity sysUserEntity = sysUserService.selectById(userId);
        SysLoginUser loginUser = BeanCopyUtils.copyPropertiesByClass(sysUserEntity, SysLoginUser.class);
        return loginUser;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(int expireTime) {
        this.expireTime = expireTime;
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public SystemUserService getSysUserService() {
        return sysUserService;
    }

    public void setSysUserService(SystemUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    public RedisTemplate<String, LoginUser> getRedisTemplate() {
        return redisTemplate;
    }

    public String getKeyPrefix() {
        return keyPrefix;
    }

    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

}
