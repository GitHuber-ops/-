
package com.hankcs.hanlp.corpus.occurrence;

import com.hankcs.hanlp.collection.trie.bintrie.BinTrie;

import java.util.List;

/**
 * 词频统计
 * @author hankcs
 */
public class TermOccurrence
{
    /**
     * 词频统计用的储存结构
     */
    BinTrie<TermFrequency> trieSingle;
    int totalTerm;

    public TermOccurrence()
    {
        trieSingle = new BinTrie<TermFrequency>();
    }

    public void add(String term)
    {
        TermFrequency value = trieSingle.get(term);
        if (value == null)
        {
            value = new TermFrequency(term);
            trieSingle.put(term, value);
        }
        else
        {
            value.increase();
        }
        ++totalTerm;
    }

    public void addAll(List<String> termList)
    {
        for (String s : termList)
        {
            add(s);
        }
    }

    public java.util.Set<java.util.Map.Entry<String, TermFrequency>> getEntrySet()
    {
        return trieSingle.entrySet();
    }
}
