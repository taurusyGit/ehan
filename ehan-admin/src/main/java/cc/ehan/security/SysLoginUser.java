package cc.ehan.security;

import lombok.Data;

import java.util.Set;

/**
 * @author ehan
 * @date 2020/12/2 0002 0:31
 */
@Data
public class SysLoginUser extends AbstractLoginUser {

    private Long id;

    private String accountName;

    private String nickName;

    private String avatar;

    private String gender;

    private String email;

    private Long deptId;

    private String deptName;

    private Boolean superAdmin;

    private String state;


    @Override
    public Set<String> getPermission() {
        return null;
    }

    @Override
    public Set<String> getRoles() {
        return null;
    }

    @Override
    public Long getId() {
        return null;
    }
}
