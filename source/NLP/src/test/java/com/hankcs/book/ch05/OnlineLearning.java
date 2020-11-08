
package com.hankcs.book.ch05;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.MSR;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.model.perceptron.PerceptronLexicalAnalyzer;
import com.hankcs.hanlp.seg.Segment;

import java.io.IOException;

/**
 * 《自然语言处理入门》5.6 基于结构化感知机的中文分词
 * 配套书籍：http://nlp.hankcs.com/book.php
 * 讨论答疑：https://bbs.hankcs.com/
 *
 * @author hankcs
 * @see <a href="http://nlp.hankcs.com/book.php">《自然语言处理入门》</a>
 * @see <a href="https://bbs.hankcs.com/">讨论答疑</a>
 */
public class OnlineLearning
{
    public static void main(String[] args) throws IOException
    {
        HanLP.Config.ShowTermNature = false;
        PerceptronLexicalAnalyzer segment = new PerceptronLexicalAnalyzer(MSR.MODEL_PATH);
        segment.enableCustomDictionary(false);
        String text = "与川普通电话";
        System.out.println(segment.seg(text));

        CustomDictionary.insert("川普", "nrf 1");
        segment.enableCustomDictionaryForcing(true);
        System.out.println(segment.seg(text));

        System.out.println(segment.seg("银川普通人与川普通电话讲四川普通话"));

        segment.enableCustomDictionary(false);
        for (int i = 0; i < 3; ++i)
            segment.learn("人 与 川普 通电话");
        System.out.println(segment.seg("银川普通人与川普通电话讲四川普通话"));
    }

}
