package cc.ehan.system.domain.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author ehan
 * @date 2020/12/2 0002 1:43
 */
@Data
public class SystemUserAccountLoginBO {

    /**
     * 用户唯一标识
     */
    private Long id;

    /**
     * 登录的账号
     */
    private String accountName;


    /**
     * 登录的密码
     */
    private String accountPassword;

    /**
     * 账号状态：10-有效；11-禁用
     */
    private String state;

    /**
     * 密码更新时间
     */
    private Date accountPasswordUpdateTime;
}
