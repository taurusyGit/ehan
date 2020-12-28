package cc.ehan.common.exception;

/**
 * 可返回给接口输出信息的抽象异常类
 */
public abstract class ExportableException extends AbstractException {

    public ExportableException(String messageCode) {
        super(messageCode);
    }
}
