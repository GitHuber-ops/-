
package com.hankcs.hanlp.tokenizer;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.common.Term;

import java.util.List;

/**
 * 索引分词器
 * @author hankcs
 */
public class IndexTokenizer
{
    /**
     * 预置分词器
     */
    public static final Segment SEGMENT = HanLP.newSegment().enableIndexMode(true);
    public static List<Term> segment(String text)
    {
        return SEGMENT.seg(text);
    }

    /**
     * 分词
     * @param text 文本
     * @return 分词结果
     */
    public static List<Term> segment(char[] text)
    {
        return SEGMENT.seg(text);
    }

    /**
     * 切分为句子形式
     * @param text 文本
     * @return 句子列表
     */
    public static List<List<Term>> seg2sentence(String text)
    {
        return SEGMENT.seg2sentence(text);
    }

    /**
     * 分词断句 输出句子形式
     *
     * @param text     待分词句子
     * @param shortest 是否断句为最细的子句（将逗号也视作分隔符）
     * @return 句子列表，每个句子由一个单词列表组成
     */
    public static List<List<Term>> seg2sentence(String text, boolean shortest)
    {
        return SEGMENT.seg2sentence(text, shortest);
    }
}
