
package com.hankcs.hanlp.dictionary.stopword;

import com.hankcs.hanlp.collection.MDAG.MDAGSet;
import com.hankcs.hanlp.dictionary.common.CommonDictionary;
import com.hankcs.hanlp.seg.common.Term;

import java.io.*;
import java.util.Collection;

import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * @author hankcs
 */
public class StopWordDictionary extends MDAGSet implements Filter
{
    public StopWordDictionary(File file) throws IOException
    {
        super(file);
    }

    public StopWordDictionary(Collection<String> strCollection)
    {
        super(strCollection);
    }

    public StopWordDictionary()
    {
    }

    public StopWordDictionary(String stopWordDictionaryPath) throws IOException
    {
        super(stopWordDictionaryPath);
    }

    @Override
    public boolean shouldInclude(Term term)
    {
        return contains(term.word);
    }
}
