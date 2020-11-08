
package com.hankcs.hanlp.dictionary.ts;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;

import java.util.TreeMap;

import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * 台湾繁体转简体
 * @author hankcs
 */
public class TaiwanToSimplifiedChineseDictionary extends BaseChineseDictionary
{
    static AhoCorasickDoubleArrayTrie<String> trie = new AhoCorasickDoubleArrayTrie<String>();
    static
    {
        long start = System.currentTimeMillis();
        String datPath = HanLP.Config.tcDictionaryRoot + "tw2s";
        if (!loadDat(datPath, trie))
        {
            TreeMap<String, String> t2s = new TreeMap<String, String>();
            TreeMap<String, String> tw2t = new TreeMap<String, String>();
            if (!load(t2s, false, HanLP.Config.tcDictionaryRoot + "t2s.txt") ||
                    !load(tw2t, true, HanLP.Config.tcDictionaryRoot + "t2tw.txt"))
            {
                throw new IllegalArgumentException("台湾繁体转简体词典加载失败");
            }
            combineReverseChain(t2s, tw2t, true);
            trie.build(t2s);
            saveDat(datPath, trie, t2s.entrySet());
        }
        logger.info("台湾繁体转简体词典加载成功，耗时" + (System.currentTimeMillis() - start) + "ms");
    }

    public static String convertToSimplifiedChinese(String traditionalTaiwanChinese)
    {
        return segLongest(traditionalTaiwanChinese.toCharArray(), trie);
    }

    public static String convertToSimplifiedChinese(char[] traditionalTaiwanChinese)
    {
        return segLongest(traditionalTaiwanChinese, trie);
    }
}
