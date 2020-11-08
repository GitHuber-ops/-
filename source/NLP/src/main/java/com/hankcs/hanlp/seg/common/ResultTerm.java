
package com.hankcs.hanlp.seg.common;

/**
 * 一个通用的Term
* @author hankcs
*/
public class ResultTerm<V>
{
    public String word;
    public V label;
    public int offset;

    public ResultTerm(String word, V label, int offset)
    {
        this.word = word;
        this.label = label;
        this.offset = offset;
    }

    @Override
    public String toString()
    {
        return word + '/' + label;
    }
}
