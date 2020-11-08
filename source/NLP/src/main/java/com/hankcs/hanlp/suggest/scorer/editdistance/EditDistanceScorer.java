
package com.hankcs.hanlp.suggest.scorer.editdistance;

import com.hankcs.hanlp.suggest.scorer.BaseScorer;

/**
 * 编辑距离打分器
 * @author hankcs
 */
public class EditDistanceScorer extends BaseScorer<CharArray>
{
    @Override
    protected CharArray generateKey(String sentence)
    {
        char[] charArray = sentence.toCharArray();
        if (charArray.length == 0) return null;
        return new CharArray(charArray);
    }
}
