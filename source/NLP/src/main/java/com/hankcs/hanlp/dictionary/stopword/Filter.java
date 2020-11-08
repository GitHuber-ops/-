
package com.hankcs.hanlp.dictionary.stopword;

import com.hankcs.hanlp.seg.common.Term;

/**
 * 停用词词典过滤器
 * @author hankcs
 */
public interface Filter
{
    /**
     * 是否应当将这个term纳入计算
     *
     * @param term
     * @return 是否应当
     */
    boolean shouldInclude(Term term);
}
