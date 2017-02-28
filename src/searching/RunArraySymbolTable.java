/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searching;

import java.io.IOException;
import datastructures.ArraySymbolTable;
import java.util.concurrent.TimeUnit;
import wordsorter.*;

/**
 *
 * @author jaw40
 */
public class RunArraySymbolTable
{

    public static void main(String[] args) throws IOException
    {
        LoadTextFile TF = new LoadTextFile();

        String[] words = TF.loadText();

        long start;
        long end;
        long elapsedTime;

        
                // --- Takes longer if Sorted. --- 

                //        // Let's time this
                //        start = System.nanoTime();
                //        // System.out.println("Start time: " + start);
                //
                //        // Merge sort
                //        System.out.println("Beginning to sort text...");
                //        WordSorter ws = new WordSorter();
                //        
                //        words = ws.mergeSort(words);
                //
                //        end = System.nanoTime();
                //        elapsedTime = end - start;
                //        System.out.println("This sorting method took approximately: "
                //                + TimeUnit.NANOSECONDS.toSeconds(elapsedTime) + " seconds"
                //                + " / "
                //                + TimeUnit.NANOSECONDS.toMillis(elapsedTime) / 1000000.0 + " milliseconds"
                //                + " / "
                //                + elapsedTime + " nanoseconds");

      
    ArraySymbolTable ast = new ArraySymbolTable();
        System.out.println("Beginning to create symbol table.");
        // Let's time this - On our pc it is about 30-40 seconds unsorted
        // 140 seconds when sorted. 
        start = System.nanoTime();
        
        for (int i = 0; i < words.length; i++)
        {
            ast.put(words[i], 1);
        }

        for (String string : ast.keys())
        {
            System.out.println(string + " : " + ast.get(string));
        }

        end = System.nanoTime();
        elapsedTime = end - start;
        System.out.println("This symbol table took approximately: "
                + TimeUnit.NANOSECONDS.toSeconds(elapsedTime) + " seconds"
                + " / "
                + TimeUnit.NANOSECONDS.toMillis(elapsedTime) / 1000000.0 + " milliseconds"
                + " / "
                + elapsedTime + " nanoseconds, to create");
    }
}
