package cc.ehan.admin.modules.authentication.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.Set;

/**
 * 当前登录用户VO对象
 */
@Data
@ApiModel
public class LoginUserVO {

    @ApiModelProperty("唯一标识")
    private Long id;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像预览地址")
    private String avatar;

    @ApiModelProperty("性别")
    private String gender;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("所属机构标识")
    private Long deptId;

    @ApiModelProperty("所属机构名称")
    private String deptName;

    @ApiModelProperty("权限集合")
    private Set<String> permissions = Collections.emptySet();

    @ApiModelProperty("角色集合")
    private Set<String> roles = Collections.emptySet();
}
