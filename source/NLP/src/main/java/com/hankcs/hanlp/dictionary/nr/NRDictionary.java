
package com.hankcs.hanlp.dictionary.nr;


import com.hankcs.hanlp.corpus.dictionary.item.EnumItem;
import com.hankcs.hanlp.corpus.tag.NR;
import com.hankcs.hanlp.dictionary.common.EnumItemDictionary;

import java.util.TreeMap;

/**
 * 一个好用的人名词典
 *
 * @author hankcs
 */
public class NRDictionary extends EnumItemDictionary<NR>
{

    @Override
    protected NR valueOf(String name)
    {
        return NR.valueOf(name);
    }

    @Override
    protected NR[] values()
    {
        return NR.values();
    }

    @Override
    protected EnumItem<NR> newItem()
    {
        return new EnumItem<NR>();
    }

    @Override
    protected void onLoaded(TreeMap<String, EnumItem<NR>> map)
    {
        map.put(" ", new EnumItem<NR>(NR.K, NR.A)); // txt中不允许出现空格词条，这里补上
    }
}
