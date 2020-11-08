
package com.hankcs.book.ch03;

import com.hankcs.hanlp.corpus.document.CorpusLoader;
import com.hankcs.hanlp.corpus.document.sentence.word.IWord;
import com.hankcs.hanlp.corpus.io.IOUtil;

import java.util.List;

/**
 * 《自然语言处理入门》3.3 训练
 * 配套书籍：http://nlp.hankcs.com/book.php
 * 讨论答疑：https://bbs.hankcs.com/
 * @author hankcs
 * @see <a href="http://nlp.hankcs.com/book.php">《自然语言处理入门》</a>
 * @see <a href="https://bbs.hankcs.com/">讨论答疑</a>
 */
public class DemoCorpusLoader
{
    public static String MY_CWS_CORPUS_PATH = "data/test/my_cws_corpus.txt";
    public static void main(String[] args)
    {
        List<List<IWord>> sentenceList = CorpusLoader.convert2SentenceList(MY_CWS_CORPUS_PATH);
        for (List<IWord> sentence : sentenceList)
        {
            System.out.println(sentence);
//            for (IWord word : sentence)
//            {
//                System.out.println(word);
//            }
//            System.out.println();
        }
    }

    static
    {
        if (!IOUtil.isFileExisted(MY_CWS_CORPUS_PATH))
        {
            IOUtil.saveTxt(MY_CWS_CORPUS_PATH, "商品 和 服务\n" +
                "商品 和服 物美价廉\n" +
                "服务 和 货币");
        }
    }
}
