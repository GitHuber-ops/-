
package com.hankcs.hanlp.classification.corpus;

import com.hankcs.hanlp.classification.collections.FrequencyMap;

/**
 * @author hankcs
 */
public class BagOfWordsDocument implements ITermFrequencyHolder
{
    //
    //    /**
    //     * 文档所属的词表
    //     */
    //    private Lexicon lexicon;
    //    /**
    //     * 文档所属的类表
    //     */
    //    private Catalog catalog;
    public FrequencyMap<Integer> tfMap;

    public BagOfWordsDocument()
    {
        tfMap = new FrequencyMap<Integer>();
    }

    public FrequencyMap<Integer> getTfMap()
    {
        return tfMap;
    }

    /**
     * 是否为空(文档中没有任何词)
     * @return
     */
    public boolean isEmpty()
    {
        return tfMap.isEmpty();
    }
}
