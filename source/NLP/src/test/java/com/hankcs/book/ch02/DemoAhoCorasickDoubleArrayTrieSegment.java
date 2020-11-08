
package com.hankcs.book.ch02;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Other.AhoCorasickDoubleArrayTrieSegment;

import java.io.IOException;

/**
 * 《自然语言处理入门》2.8 HanLP的词典分词实现
 * 配套书籍：http://nlp.hankcs.com/book.php
 * 讨论答疑：https://bbs.hankcs.com/
 *
 * @author hankcs
 * @see <a href="http://nlp.hankcs.com/book.php">《自然语言处理入门》</a>
 * @see <a href="https://bbs.hankcs.com/">讨论答疑</a>
 */
public class DemoAhoCorasickDoubleArrayTrieSegment
{
    public static void main(String[] args) throws IOException
    {
        HanLP.Config.ShowTermNature = false;
        AhoCorasickDoubleArrayTrieSegment segment = new AhoCorasickDoubleArrayTrieSegment();
        System.out.println(segment.seg("江西鄱阳湖干枯，中国最大淡水湖变成大草原"));
    }
}
