
package com.hankcs.hanlp.classification.models;

import com.hankcs.hanlp.collection.trie.bintrie.BinTrie;
import com.hankcs.hanlp.classification.tokenizers.ITokenizer;

import java.io.*;

/**
 * 所有文本分类模型的基类,包含基本的需要序列化的数据
 * @author hankcs
 */
public class AbstractModel implements Serializable
{
    /**
     * 类目表
     */
    public String[] catalog;
    /**
     * 分词器
     */
    public ITokenizer tokenizer;
    /**
     * 词语到的映射
     */
    public BinTrie<Integer> wordIdTrie;
}