
package com.hankcs.hanlp.classification.utilities.io;

/**
 * 输出到stdout和stderr的日志系统
 *
 * @author hankcs
 */
public class ConsoleLogger implements ILogger
{
    /**
     * 默认日志
     */
    public static ILogger logger = new ConsoleLogger();
    long start;

    public void out(String format, Object... args)
    {
        System.out.printf(format, args);
    }

    public void err(String format, Object... args)
    {
        System.err.printf(format, args);
    }

    public void start(String format, Object... args)
    {
        out(format, args);
        start = System.currentTimeMillis();
    }

    public void finish(String format, Object... args)
    {
        out(String.format("耗时 %d ms", System.currentTimeMillis() - start) + format, args);
    }
}