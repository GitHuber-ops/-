
package com.hankcs.hanlp.dependency.nnparser.action;

/**
 * @author hankcs
 */
public class AbstractInexactAction implements Comparable<AbstractInexactAction>
{
    int seed;

    public AbstractInexactAction()
    {
    }

    /**
     * Constructor for inexact action. Empirically, the number of name
     * is less than 32. So such inexact action type compile the action
     * name and action type into a single integer.
     *
     * @param name The name for the action.
     * @param rel  The dependency relation.
     */
    AbstractInexactAction(int name, int rel)
    {
        seed = rel << 6 | name;
    }

    public int compareTo(AbstractInexactAction o)
    {
        return new Integer(seed).compareTo(o.seed);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof AbstractInexactAction)) return false;
        AbstractInexactAction o = (AbstractInexactAction) obj;
        return seed == o.seed;
    }

    public int name()
    {
        return (seed & 0x3f);
    }

    public int rel()
    {
        return (seed >> 6);
    }
}
