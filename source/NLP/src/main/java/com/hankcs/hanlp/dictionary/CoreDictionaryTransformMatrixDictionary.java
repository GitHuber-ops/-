
package com.hankcs.hanlp.dictionary;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.tag.Nature;
import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * 核心词典词性转移矩阵
 * @author hankcs
 */
public class CoreDictionaryTransformMatrixDictionary
{
    public static TransformMatrix transformMatrixDictionary;
    static
    {
        transformMatrixDictionary = new TransformMatrix(){

            @Override
            public int ordinal(String tag)
            {
                return Nature.create(tag).ordinal();
            }
        };
        long start = System.currentTimeMillis();
        if (!transformMatrixDictionary.load(HanLP.Config.CoreDictionaryTransformMatrixDictionaryPath))
        {
            throw new IllegalArgumentException("加载核心词典词性转移矩阵" + HanLP.Config.CoreDictionaryTransformMatrixDictionaryPath + "失败");
        }
        else
        {
            logger.info("加载核心词典词性转移矩阵" + HanLP.Config.CoreDictionaryTransformMatrixDictionaryPath + "成功，耗时：" + (System.currentTimeMillis() - start) + " ms");
        }
    }
}
