package cn.dails.converter;

import cn.dails.utils.MarkUtils;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.pattern.ConverterKeys;
import org.apache.logging.log4j.core.pattern.LogEventPatternConverter;
import org.apache.logging.log4j.util.PerformanceSensitive;

@Plugin(
        name = "SensitiveLog4j2Converter", category = PatternLayout.KEY,printObject = true
)
@ConverterKeys("dms")
@PerformanceSensitive({"dms"})
public class SensitiveLog4j2Converter extends LogEventPatternConverter {
    private final String pattern;

    @PluginFactory
    public static SensitiveLog4j2Converter newInstance(@PluginAttribute("pattern") String pattern) {
        return new SensitiveLog4j2Converter("dms", "dms", new String[]{pattern});
    }

    /**
     * Constructs an instance of LoggingEventPatternConverter.
     *
     * @param name    name of converter.
     * @param style   CSS style for output.
     * @param options
     */
    protected SensitiveLog4j2Converter(String name, String style, String[] options) {
        super(name, style);
        this.pattern = options[0];
    }
    @Override
    public void format(LogEvent event, StringBuilder toAppendTo) {
        String className = event.getSource().getClassName();
        int lineNumber = event.getSource().getLineNumber();

        // 判断超长
        //DENY,NEUTRAL,ACCEPT
        String message = event.getMessage().getFormattedMessage();
        String desensitizedMessage = MarkUtils.desensitize(className+"（"+lineNumber+"）",message);
        toAppendTo.append(desensitizedMessage);
    }








}
