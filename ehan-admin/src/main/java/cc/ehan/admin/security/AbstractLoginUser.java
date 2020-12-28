package cc.ehan.admin.security;

import lombok.Data;

/**
 * @author ehan
 * @date 2020/12/2 0002 0:34
 */
@Data
public abstract class AbstractLoginUser implements LoginUser {

    /**
     * 用户登录的标识
     */
    private String token;

    /**
     * 登陆时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;
}
