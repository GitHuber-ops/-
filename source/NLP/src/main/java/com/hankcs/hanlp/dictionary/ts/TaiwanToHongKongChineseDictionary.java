
package com.hankcs.hanlp.dictionary.ts;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;

import java.util.TreeMap;

import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * 台湾繁体转香港繁体
 *
 * @author hankcs
 */
public class TaiwanToHongKongChineseDictionary extends BaseChineseDictionary
{
    static AhoCorasickDoubleArrayTrie<String> trie = new AhoCorasickDoubleArrayTrie<String>();

    static
    {
        long start = System.currentTimeMillis();
        String datPath = HanLP.Config.tcDictionaryRoot + "tw2hk";
        if (!loadDat(datPath, trie))
        {
            TreeMap<String, String> t2hk = new TreeMap<String, String>();
            TreeMap<String, String> tw2t = new TreeMap<String, String>();
            if (!load(t2hk, false, HanLP.Config.tcDictionaryRoot + "t2hk.txt") ||
                    !load(tw2t, true, HanLP.Config.tcDictionaryRoot + "t2tw.txt"))
            {
                throw new IllegalArgumentException("台湾繁体转香港繁体词典加载失败");
            }
            combineReverseChain(t2hk, tw2t, false);
            trie.build(t2hk);
            saveDat(datPath, trie, t2hk.entrySet());
        }
        logger.info("台湾繁体转香港繁体词典加载成功，耗时" + (System.currentTimeMillis() - start) + "ms");
    }

    public static String convertToTraditionalHongKongChinese(String traditionalTaiwanChinese)
    {
        return segLongest(traditionalTaiwanChinese.toCharArray(), trie);
    }

    public static String convertToTraditionalHongKongChinese(char[] traditionalTaiwanChinese)
    {
        return segLongest(traditionalTaiwanChinese, trie);
    }
}
