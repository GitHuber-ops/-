
package com.hankcs.hanlp.suggest;

import java.util.List;

/**
 * @author hankcs
 */
public interface ISuggester
{
    void addSentence(String sentence);

    /**
     * 清空该推荐器中的所有句子
     */
    void removeAllSentences();

    /**
     * 根据一个输入的句子推荐相似的句子
     *
     * @param key
     * @param size
     * @return
     */
    List<String> suggest(String key, int size);
}
