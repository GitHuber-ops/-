

package com.hankcs.book.ch01;

import com.hankcs.hanlp.HanLP;

/**
 * 《自然语言处理入门》1.6 开源工具
 * 配套书籍：http://nlp.hankcs.com/book.php
 * 讨论答疑：https://bbs.hankcs.com/
 *
 * @author hankcs
 * @see <a href="http://nlp.hankcs.com/book.php">《自然语言处理入门》</a>
 * @see <a href="https://bbs.hankcs.com/">讨论答疑</a>
 */
public class HelloWord
{
    public static void main(String[] args)
    {
        HanLP.Config.enableDebug();         // 首次运行会自动建立模型缓存，为了避免你等得无聊，开启调试模式说点什么:-)
        System.out.println(HanLP.segment("王国维和服务员"));
    }
}