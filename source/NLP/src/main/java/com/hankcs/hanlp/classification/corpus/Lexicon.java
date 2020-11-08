
package com.hankcs.hanlp.classification.corpus;


import com.hankcs.hanlp.collection.trie.bintrie.BinTrie;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 词表
 *
 * @author hankcs
 */
public class Lexicon
{
    public BinTrie<Integer> wordId;
    public List<String> idWord;

    public Lexicon()
    {
        wordId = new BinTrie<Integer>();
        idWord = new LinkedList<String>();
    }

    public Lexicon(BinTrie<Integer> wordIdTrie)
    {
        wordId = wordIdTrie;
    }

    public int addWord(String word)
    {
        assert word != null;
        char[] charArray = word.toCharArray();
        Integer id = wordId.get(charArray);
        if (id == null)
        {
            id = wordId.size();
            wordId.put(charArray, id);
            idWord.add(word);
            assert idWord.size() == wordId.size();
        }

        return id;
    }

    public Integer getId(String word)
    {
        return wordId.get(word);
    }

    public String getWord(int id)
    {
        assert 0 <= id;
        assert id <= idWord.size();
        return idWord.get(id);
    }

    public int size()
    {
        return idWord.size();
    }

    public String[] getWordIdArray()
    {
        String[] wordIdArray = new String[idWord.size()];
        if (idWord.isEmpty()) return wordIdArray;
        int p = -1;
        Iterator<String> iterator = idWord.iterator();
        while (iterator.hasNext())
        {
            wordIdArray[++p] = iterator.next();
        }

        return wordIdArray;
    }
}