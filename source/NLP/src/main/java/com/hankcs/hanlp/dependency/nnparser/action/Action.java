
package com.hankcs.hanlp.dependency.nnparser.action;

/**
 * @author hankcs
 */
public class Action extends AbstractInexactAction implements ActionType
{
    public Action()
    {
    }

    /**
     * 创建动作
     * @param name 动作名称
     * @param rel 依存关系
     */
    public Action(int name, int rel)
    {
        super(name, rel);
    }
}
