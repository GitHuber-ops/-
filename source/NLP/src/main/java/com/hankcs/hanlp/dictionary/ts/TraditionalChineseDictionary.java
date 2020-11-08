
package com.hankcs.hanlp.dictionary.ts;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;

import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * 繁简词典，提供简繁转换
 * @author hankcs
 */
public class TraditionalChineseDictionary extends BaseChineseDictionary
{
    /**
     * 繁体=简体
     */
    public static AhoCorasickDoubleArrayTrie<String> trie = new AhoCorasickDoubleArrayTrie<String>();

    static
    {
        long start = System.currentTimeMillis();
        if (!load(HanLP.Config.tcDictionaryRoot + "t2s.txt", trie, false))
        {
            throw new IllegalArgumentException("繁简词典" + HanLP.Config.tcDictionaryRoot + "t2s.txt" + "加载失败");
        }

        logger.info("繁简词典" + HanLP.Config.tcDictionaryRoot + "t2s.txt" + "加载成功，耗时" + (System.currentTimeMillis() - start) + "ms");
    }

    public static String convertToSimplifiedChinese(String traditionalChineseString)
    {
        return segLongest(traditionalChineseString.toCharArray(), trie);
    }

    public static String convertToSimplifiedChinese(char[] traditionalChinese)
    {
        return segLongest(traditionalChinese, trie);
    }

}
