
package com.hankcs.hanlp.classification.corpus;

import com.hankcs.hanlp.classification.collections.FrequencyMap;

/**
 * @author hankcs
 */
public interface ITermFrequencyHolder
{
    FrequencyMap<Integer> getTfMap();
}
