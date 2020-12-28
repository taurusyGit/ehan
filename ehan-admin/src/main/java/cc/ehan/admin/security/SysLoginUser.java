package cc.ehan.admin.security;

import lombok.Data;

import java.util.Collections;
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

    private Set<String> permissions = Collections.emptySet();

    private Set<String> roles = Collections.emptySet();

    @Override
    public Set<String> getPermission() {
        return permissions;
    }

    @Override
    public Set<String> getRoles() {
        return roles;
    }

    @Override
    public Long getId() {
        return id;
    }
}
