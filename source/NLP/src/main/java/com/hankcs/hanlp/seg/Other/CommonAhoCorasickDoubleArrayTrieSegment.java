
package com.hankcs.hanlp.seg.Other;

import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.seg.common.ResultTerm;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 对CommonAhoCorasickSegmentUtil中最长分词器的包装
 *
 * @author hankcs
 * @since 1.5.3
 */
public class CommonAhoCorasickDoubleArrayTrieSegment<V>
{
    AhoCorasickDoubleArrayTrie<V> trie;

    public CommonAhoCorasickDoubleArrayTrieSegment(AhoCorasickDoubleArrayTrie<V> trie)
    {
        this.trie = trie;
    }

    public CommonAhoCorasickDoubleArrayTrieSegment(TreeMap<String, V> dictionary)
    {
        trie = new AhoCorasickDoubleArrayTrie<V>(dictionary);
    }

    public LinkedList<ResultTerm<V>> segment(String text)
    {
        return CommonAhoCorasickSegmentUtil.segment(text, trie);
    }

    public LinkedList<ResultTerm<V>> segment(char[] text)
    {
        return CommonAhoCorasickSegmentUtil.segment(text, trie);
    }
}
