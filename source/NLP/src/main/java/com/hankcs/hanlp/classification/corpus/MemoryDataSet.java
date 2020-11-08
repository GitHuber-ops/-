
package com.hankcs.hanlp.classification.corpus;


import com.hankcs.hanlp.classification.collections.FrequencyMap;
import com.hankcs.hanlp.classification.models.AbstractModel;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author hankcs
 */
public class MemoryDataSet extends AbstractDataSet
{
    List<Document> documentList;
    boolean editMode;

    public MemoryDataSet()
    {
        super();
        documentList = new LinkedList<Document>();
    }

    public MemoryDataSet(AbstractModel model)
    {
        super(model);
        documentList = new LinkedList<Document>();
    }

    @Override
    public Document add(String category, String text)
    {
        if (editMode) return null;
        Document document = convert(category, text);
        documentList.add(document);
        return document;
    }
    @Override
    public int size()
    {
        return documentList.size();
    }

    @Override
    public void clear()
    {
        documentList.clear();
    }

    @Override
    public IDataSet shrink(int[] idMap)
    {
        Iterator<Document> iterator = iterator();
        while (iterator.hasNext())
        {
            Document document = iterator.next();
            FrequencyMap<Integer> tfMap = new FrequencyMap<Integer>();
            for (Map.Entry<Integer, int[]> entry : document.tfMap.entrySet())
            {
                Integer feature = entry.getKey();
                if (idMap[feature] == -1) continue;
                tfMap.put(idMap[feature], entry.getValue());
            }
            // 检查是否是空白文档
            if (tfMap.size() == 0) iterator.remove();
            else document.tfMap = tfMap;
        }
        return this;
    }

    @Override
    public Iterator<Document> iterator()
    {
        return documentList.iterator();
    }
}