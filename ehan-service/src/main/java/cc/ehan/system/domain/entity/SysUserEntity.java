package cc.ehan.system.domain.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@TableName("sys_user")
@Accessors(chain = true)
public class SysUserEntity {

    /**
     * `id` bigint(20) unsigned NOT NULL,
     *   `account_name` varchar(32) NOT NULL COMMENT '登录账号名称',
     *   `nick_name` varchar(10) NOT NULL COMMENT '姓名',
     *   `avatar` varchar(200) DEFAULT NULL COMMENT '头像预览地址',
     *   `gender` varchar(2) NOT NULL COMMENT '性别：男，女，保密',
     *   `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
     *   `dept_id` bigint(20) unsigned DEFAULT NULL COMMENT '所属部门标识',
     *   `dept_name` varchar(32) DEFAULT NULL COMMENT '所属部门名称',
     *   `super_admin` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否为超级管理员账号',
     *   `state` char(2) DEFAULT '10' COMMENT '账号状态：10-有效；11-禁用',
     *   `creator` bigint(20) unsigned DEFAULT NULL COMMENT '创建人标识',
     *   `created_time` datetime DEFAULT NULL COMMENT '创建时间',
     *   `updater` bigint(20) unsigned DEFAULT NULL COMMENT '更新人标识',
     *   `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
     *   `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
     *   `version` bigint(20) unsigned DEFAULT '0' COMMENT '版本号',
     *   PRIMARY KEY (`id`)
     * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4
     */

    @TableId
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

    private Long creator;

    private Date createdTime;

    private Long updater;


    private Date updatedTime;

    private Boolean deleted;

    private Long version;
}
