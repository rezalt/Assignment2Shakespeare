/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searching;

import java.io.IOException;
import wordsorter.LoadTextFile;
import datastructures.LinkedSymbolTable;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author jaw40
 */
public class RunLinkedSymbolTable
{

    public static void main(String[] args) throws IOException
    {

        LoadTextFile TF = new LoadTextFile();

        long start;
        long end;
        long elapsedTime;

        String[] words = TF.loadText();

        LinkedSymbolTable lst = new LinkedSymbolTable();
        System.out.println("Beginning to create symbol table.");
        // Let's time this 
        start = System.nanoTime();

        for (int i = 0; i < words.length; i++)
        {
            lst.put(words[i], 1);
        }

        for (String string : lst.keys())
        {
            System.out.println(string + " : " + lst.get(string));
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
