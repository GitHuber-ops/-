
package com.hankcs.hanlp.dictionary.nt;


import com.hankcs.hanlp.corpus.dictionary.item.EnumItem;
import com.hankcs.hanlp.corpus.tag.NT;
import com.hankcs.hanlp.dictionary.common.EnumItemDictionary;

/**
 * 一个好用的地名词典
 *
 * @author hankcs
 */
public class NTDictionary extends EnumItemDictionary<NT>
{
    @Override
    protected NT valueOf(String name)
    {
        return NT.valueOf(name);
    }

    @Override
    protected NT[] values()
    {
        return NT.values();
    }

    @Override
    protected EnumItem<NT> newItem()
    {
        return new EnumItem<NT>();
    }
}
