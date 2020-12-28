package cc.ehan.system.domain.entity;

import cc.ehan.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@TableName("system_user")
@Accessors(chain = true)
public class SystemUserEntity extends BaseEntity {

    private String accountName;

    private String nickName;

    private String avatar;

    private String gender;

    private String email;

    private Long deptId;

    private String deptName;

    private Boolean superAdmin;

    private String state;

}
