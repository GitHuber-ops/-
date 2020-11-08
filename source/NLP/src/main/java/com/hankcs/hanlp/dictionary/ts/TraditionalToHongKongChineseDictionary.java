
package com.hankcs.hanlp.dictionary.ts;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;

import java.util.TreeMap;

import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * 繁体转香港繁体
 * @author hankcs
 */
public class TraditionalToHongKongChineseDictionary extends BaseChineseDictionary
{
    static AhoCorasickDoubleArrayTrie<String> trie = new AhoCorasickDoubleArrayTrie<String>();
    static
    {
        long start = System.currentTimeMillis();
        String datPath = HanLP.Config.tcDictionaryRoot + "t2hk";
        if (!loadDat(datPath, trie))
        {
            TreeMap<String, String> t2hk = new TreeMap<String, String>();
            if (!load(t2hk, false, HanLP.Config.tcDictionaryRoot + "t2hk.txt"))
            {
                throw new IllegalArgumentException("繁体转香港繁体加载失败");
            }
            trie.build(t2hk);
            saveDat(datPath, trie, t2hk.entrySet());
        }
        logger.info("繁体转香港繁体加载成功，耗时" + (System.currentTimeMillis() - start) + "ms");
    }

    public static String convertToHongKongTraditionalChinese(String traditionalChineseString)
    {
        return segLongest(traditionalChineseString.toCharArray(), trie);
    }

    public static String convertToHongKongTraditionalChinese(char[] traditionalHongKongChineseString)
    {
        return segLongest(traditionalHongKongChineseString, trie);
    }
}
