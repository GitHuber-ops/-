
package com.hankcs.hanlp.classification.utilities.io;

/**
 * 一个简单的日志接口
 * @author hankcs
 */
public interface ILogger
{
    void out(String format, Object ... args);
    void err(String format, Object ... args);
    void start(String format, Object ... args);
    void finish(String format, Object ... args);
}
