package cn.dails.converter;

import ch.qos.logback.classic.pattern.MessageConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import cn.dails.utils.MarkUtils;


public class SensitiveLogbackConverter extends MessageConverter {
    @Override
    public String convert(ILoggingEvent event) {
        String message = event.getFormattedMessage();
        StackTraceElement[] stackTraceElements = event.getCallerData();
        String className = null;
        if (stackTraceElements != null && stackTraceElements.length > 0) {
            StackTraceElement callerElement = stackTraceElements[0];
            className = callerElement.getClassName();
            String methodName = callerElement.getMethodName();
            int lineNumber = callerElement.getLineNumber();
            className = className+"("+lineNumber+")";
        }

        // 在这里对 message 进行脱敏操作
        String desensitizedMessage = MarkUtils.desensitize(className,message);

        return desensitizedMessage;
    }
}
