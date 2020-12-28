package cc.ehan.admin.modules.authentication.domain.ao;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginAccountAO {

    @ApiModelProperty("账号")
    private String accountName;

    @ApiModelProperty("密码")
    private String accountPassword;
}
