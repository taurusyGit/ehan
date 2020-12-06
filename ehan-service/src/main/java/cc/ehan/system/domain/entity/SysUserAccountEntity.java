package cc.ehan.system.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author ehan
 * @date 2020/12/1 0001 21:38
 */
@Data
@TableName("sys_user_account")
public class SysUserAccountEntity {

    @TableId
    private Long id;

    private String accountName;

    private String accountPassword;
}
