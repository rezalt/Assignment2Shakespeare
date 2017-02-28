/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsorter;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Rezalt
 */
public class WordSorter
{


    public WordSorter()
    {
      
    }

    public String[] mergeSort(String[] words)
    {

        if (words.length != 1)
        {
            String[] left = new String[words.length / 2];
            String[] right = new String[words.length - words.length / 2];

            for (int i = 0; i < left.length; i++)
            {
                left[i] = words[i];
            }
            for (int i = 0; i < right.length; i++)
            {
                right[i] = words[i + words.length / 2];
            }

            mergeSort(left);
            mergeSort(right);

            merge(words, left, right);

        }

        return words;
    }

    public void merge(String[] result, String[] left, String[] right)
    {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++)
        {
            if (i2 >= right.length || (i1 < left.length
                    && left[i1].compareToIgnoreCase(right[i2]) < 0))
            {
                result[i] = left[i1];
                i1++;
            }
            else
            {
                result[i] = right[i2];
                i2++;
            }
        }

    }

}
