package cc.ehan.common.base;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

/**
 * @author ehan
 */
@Data
public class BaseEntity {

    @TableId
    private Long id;

    private Long creator;

    private Date createdTime;

    private Long updater;

    private Date updatedTime;

    @TableLogic
    private Boolean deleted;

    @Version
    private Long version;
}
