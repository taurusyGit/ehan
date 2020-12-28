package cc.ehan.common.exception;

import cc.ehan.common.utils.message.MessageUtils;

/**
 * 异常父类
 *
 * @author ehan
 * @date 2020/12/1 0001 22:02
 */
public abstract class AbstractException extends RuntimeException {

    /**
     * 错误信息编码
     */
    private String messageCode;

    public AbstractException( String messageCode) {
        this.messageCode = messageCode;
    }

    public AbstractException(String messageCode, Throwable e) {
        super(e);
        this.messageCode = messageCode;
    }

    @Override
    public String getMessage() {
        return MessageUtils.getMessage(messageCode);
    }

    public String getMessageCode() {
        return messageCode;
    }
}
