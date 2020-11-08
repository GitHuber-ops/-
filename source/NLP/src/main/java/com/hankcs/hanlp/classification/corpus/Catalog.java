
package com.hankcs.hanlp.classification.corpus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 类目名称和id的对应关系
 * @author hankcs
 */
public class Catalog implements Serializable
{
    Map<String, Integer> categoryId;
    List<String> idCategory;

    public Catalog()
    {
        categoryId = new TreeMap<String, Integer>();
        idCategory = new ArrayList<String>();
    }

    public Catalog(String[] catalog)
    {
        this();
        for (int i = 0; i < catalog.length; i++)
        {
            categoryId.put(catalog[i], i);
            idCategory.add(catalog[i]);
        }
    }

    public int addCategory(String category)
    {
        Integer id = categoryId.get(category);
        if (id == null)
        {
            id = categoryId.size();
            categoryId.put(category, id);
            assert idCategory.size() == id;
            idCategory.add(category);
        }

        return id;
    }

    public Integer getId(String category)
    {
        return categoryId.get(category);
    }

    public String getCategory(int id)
    {
        assert 0 <= id;
        assert id < idCategory.size();

        return idCategory.get(id);
    }

    public List<String> getCategories()
    {
        return idCategory;
    }

    public int size()
    {
        return idCategory.size();
    }

    public String[] toArray()
    {
        String[] catalog = new String[idCategory.size()];
        idCategory.toArray(catalog);

        return catalog;
    }

    @Override
    public String toString()
    {
        return idCategory.toString();
    }
}
