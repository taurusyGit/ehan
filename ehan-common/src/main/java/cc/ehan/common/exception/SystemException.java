package cc.ehan.common.exception;

import cc.ehan.common.utils.message.MessageCode;

/**
 * 系统内部异常
 *
 * @author ehan
 * @date 2020/12/1 0001 22:50
 */
public class SystemException extends AbstractException {

    public SystemException(Throwable e) {
        super(MessageCode.SYSTEM_ERROR, e);
    }
}
