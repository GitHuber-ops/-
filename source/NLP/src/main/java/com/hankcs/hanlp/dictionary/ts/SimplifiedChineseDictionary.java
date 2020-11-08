
package com.hankcs.hanlp.dictionary.ts;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.utility.Predefine;

import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * 简体=繁体词典
 * @author hankcs
 */
public class SimplifiedChineseDictionary extends BaseChineseDictionary
{
    /**
     * 简体=繁体
     */
    static AhoCorasickDoubleArrayTrie<String> trie = new AhoCorasickDoubleArrayTrie<String>();
    
    static
    {
        long start = System.currentTimeMillis();
        if (!load(HanLP.Config.tcDictionaryRoot + "s2t.txt", trie, false))
        {
            throw new IllegalArgumentException("简繁词典" + HanLP.Config.tcDictionaryRoot + "s2t.txt" + Predefine.BIN_EXT + "加载失败");
        }

        logger.info("简繁词典" + HanLP.Config.tcDictionaryRoot + "s2t.txt" + Predefine.BIN_EXT + "加载成功，耗时" + (System.currentTimeMillis() - start) + "ms");
    }

    public static String convertToTraditionalChinese(String simplifiedChineseString)
    {
        return segLongest(simplifiedChineseString.toCharArray(), trie);
    }

    public static String convertToTraditionalChinese(char[] simplifiedChinese)
    {
        return segLongest(simplifiedChinese, trie);
    }

    public static String getTraditionalChinese(String simplifiedChinese)
    {
        return trie.get(simplifiedChinese);
    }
}
