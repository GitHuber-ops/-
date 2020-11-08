
package com.hankcs.hanlp.dictionary.py;

/**
 * 将整型转为拼音
 * @author hankcs
 */
public class Integer2PinyinConverter
{
    public static final Pinyin[] pinyins = Pinyin.values();

    public static Pinyin getPinyin(int ordinal)
    {
        return pinyins[ordinal];
    }
}
