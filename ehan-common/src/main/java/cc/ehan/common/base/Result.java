package cc.ehan.common.base;

import cc.ehan.common.utils.message.MessageCode;
import cc.ehan.common.utils.message.MessageUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Result<T> {

    @ApiModelProperty("请求状态码，200表示请求成功，其他表示请求失败")
    private String code;

    @ApiModelProperty("请求返回的描述信息")
    private String message;

    @ApiModelProperty("请求返回的数据")
    private T data;

    public Result(String code) {
        this.code = code;
        this.message = MessageUtils.getMessage(code);
    }

    public Result(String code, T data) {
        this.code = code;
        this.message = MessageUtils.getMessage(code);
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(MessageCode.SUCCESS, data);
    }

    public static <T> Result<T> success() {
        String message = MessageUtils.getMessage(MessageCode.SUCCESS);
        return new Result<T>(MessageCode.SUCCESS);
    }

    public static <T> Result<T> fail(String code, T data) {
        return new Result<T>(code, data);
    }

    public static <T> Result<T> fail(String code) {
        return new Result<T>(code);
    }


}
