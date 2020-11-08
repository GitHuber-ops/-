
package com.hankcs.hanlp.dictionary.nr;

import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.utility.Predefine;

/**
 * 人名识别中常用的一些常量
 * @author hankcs
 */
public class NRConstant
{
    /**
     * 本词典专注的词的ID
     */
    public static final int WORD_ID = CoreDictionary.getWordID(Predefine.TAG_PEOPLE);
    /**
     * 本词典专注的词的属性
     */
    public static final CoreDictionary.Attribute ATTRIBUTE = CoreDictionary.get(WORD_ID);
}
