
package com.hankcs.hanlp.classification.collections;

import java.util.TreeMap;

/**
 * 统计词频的Map
 * @author hankcs
 */
public class FrequencyMap<K> extends TreeMap<K, int[]>
{
    /**
     * 增加一个词的词频
     * @param key
     * @return
     */
    public int add(K key)
    {
        int[] f = get(key);
        if (f == null)
        {
            f = new int[]{1};
            put(key, f);
        }
        else ++f[0];

        return f[0];
    }
}