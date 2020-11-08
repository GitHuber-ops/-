
package com.hankcs.hanlp.dictionary.ns;


import com.hankcs.hanlp.corpus.dictionary.item.EnumItem;
import com.hankcs.hanlp.corpus.tag.NS;
import com.hankcs.hanlp.dictionary.common.EnumItemDictionary;

/**
 * 一个好用的地名词典
 *
 * @author hankcs
 */
public class NSDictionary extends EnumItemDictionary<NS>
{
    @Override
    protected NS valueOf(String name)
    {
        return NS.valueOf(name);
    }

    @Override
    protected NS[] values()
    {
        return NS.values();
    }

    @Override
    protected EnumItem<NS> newItem()
    {
        return new EnumItem<NS>();
    }
}
