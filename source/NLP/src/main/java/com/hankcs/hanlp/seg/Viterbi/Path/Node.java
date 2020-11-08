
package com.hankcs.hanlp.seg.Viterbi.Path;

import com.hankcs.hanlp.utility.MathUtility;
import com.hankcs.hanlp.seg.common.Vertex;

/**
 * @author hankcs
 */
public class Node
{
    /**
     * 到该节点的最短路径的前驱节点
     */
    Node from;
    /**
     * 最短路径对应的权重
     */
    double weight;
    /**
     * 节点代表的顶点
     */
    Vertex vertex;

    public Node(Vertex vertex)
    {
        this.vertex = vertex;
    }

    public void updateFrom(Node from)
    {
        double weight = from.weight + MathUtility.calculateWeight(from.vertex, this.vertex);
        if (this.from == null || this.weight > weight)
        {
            this.from = from;
            this.weight = weight;
        }
    }

    @Override
    public String toString()
    {
        return vertex.toString();
    }
}
