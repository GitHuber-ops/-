
package com.hankcs.hanlp.dictionary;

import java.util.Arrays;

/**
 * 转移矩阵词典
 *
 * @param <E> 标签的枚举类型
 * @author hankcs
 */
public class TransformMatrixDictionary<E extends Enum<E>> extends TransformMatrix
{
    Class<E> enumType;

    public TransformMatrixDictionary(Class<E> enumType)
    {
        this.enumType = enumType;
    }

    public TransformMatrixDictionary()
    {

    }

    /**
     * 获取转移频次
     *
     * @param from
     * @param to
     * @return
     */
    public int getFrequency(String from, String to)
    {
        return getFrequency(convert(from), convert(to));
    }

    /**
     * 获取转移频次
     *
     * @param from
     * @param to
     * @return
     */
    public int getFrequency(E from, E to)
    {
        return matrix[from.ordinal()][to.ordinal()];
    }

    /**
     * 获取e的总频次
     *
     * @param e
     * @return
     */
    public int getTotalFrequency(E e)
    {
        return total[e.ordinal()];
    }

    /**
     * 获取所有标签的总频次
     *
     * @return
     */
    public int getTotalFrequency()
    {
        return totalFrequency;
    }

    protected E convert(String label)
    {
        return Enum.valueOf(enumType, label);
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("TransformMatrixDictionary{");
        sb.append("enumType=").append(enumType);
        sb.append(", ordinaryMax=").append(ordinaryMax);
        sb.append(", matrix=").append(Arrays.toString(matrix));
        sb.append(", total=").append(Arrays.toString(total));
        sb.append(", totalFrequency=").append(totalFrequency);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int ordinal(String tag)
    {
        return Enum.valueOf(enumType, tag).ordinal();
    }
}
