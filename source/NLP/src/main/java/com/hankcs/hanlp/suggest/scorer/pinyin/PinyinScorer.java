
package com.hankcs.hanlp.suggest.scorer.pinyin;

import com.hankcs.hanlp.suggest.scorer.BaseScorer;

/**
 * 拼音打分器
 * @author hankcs
 */
public class PinyinScorer extends BaseScorer<PinyinKey>
{
    @Override
    protected PinyinKey generateKey(String sentence)
    {
        PinyinKey pinyinKey = new PinyinKey(sentence);
        if (pinyinKey.size() == 0) return null;
        return pinyinKey;
    }
}
