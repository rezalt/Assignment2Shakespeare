/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author jaw40
 */
public class FlexibleArray<T>
{

    private T[] less;
    private T[] more;
    private int split;
    private int length;

    public FlexibleArray(T type)
    {
        less = (T[]) new Object[1];
        more = (T[]) new Object[2];
        length = 0;
    }

    public void add(T element)
    {
        if (length < less.length)
        {
            less[length] = element;
            length += 1;
        }
        else
        {
            more[split] = less[split];
            more[length] = element;
            split++;
            length++;
            if (length >= more.length)
            {
                makeNew();
            }
        }
    }

    public T get(int index)
    {
        if (index >= split && index < less.length)
        {
            return less[index];
        }
        else
        {
            return more[index];
        }
    }

    public void set(int index, T element)
    {
        if (split < length && length < less.length)
        {
            less[index] = element;
        }
        else
        {
            more[index] = element;
        }
    }

    public int size()
    {
        return length;
    }

    public int indexOf(T element)
    {
        for (int i = 0; i < length; i++)
        {
            if (element.equals(get(i)))
            {
                return i;
            }
        }
        return -1;
    }

    private void makeNew()
    {
        less = more;
        more = (T[]) new Object[length * 2];
        split = 0;
    }

    private void printArray(T[] toPrint)
    {
        for (T t : toPrint)
        {
            System.out.println(t.toString());
        }
    }

    @Override
    public String toString()
    {
        String res = "";
        for (int i = 0; i < length; i++)
        {
            res += get(i);
        }
        return res;
    }
}
