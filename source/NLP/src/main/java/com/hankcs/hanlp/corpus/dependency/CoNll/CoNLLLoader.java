
package com.hankcs.hanlp.corpus.dependency.CoNll;

import com.hankcs.hanlp.corpus.io.IOUtil;

import java.util.LinkedList;

/**
 * CoNLL格式依存语料加载
 * @author hankcs
 */
public class CoNLLLoader
{
    public static LinkedList<CoNLLSentence> loadSentenceList(String path)
    {
        LinkedList<CoNLLSentence> result = new LinkedList<CoNLLSentence>();
        LinkedList<CoNllLine> lineList = new LinkedList<CoNllLine>();
        for (String line : IOUtil.readLineListWithLessMemory(path))
        {
            if (line.trim().length() == 0)
            {
                result.add(new CoNLLSentence(lineList));
                lineList = new LinkedList<CoNllLine>();
                continue;
            }
            lineList.add(new CoNllLine(line.split("\t")));
        }

        return result;
    }
}
