package com.valyaJmartPK;

import java.util.*;
import java.util.Iterator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Algorithm {

    private Algorithm(){

    }

    //method collect
    public static <T> List<T> collect(T[] array, T value)
    {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return collect(iterator,value);
    }

    public static <T> List<T> collect(Iterable<T> iterable, T value)
    {
        Iterator<T> iterator = iterable.iterator();
        return collect(iterator,value);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value)
    {
        final Predicate<T> pred = value::equals;
        return collect(iterator,pred);
    }

    public static <T> List<T> collect(T[] array, Predicate<T> pred)
    {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return collect(iterator,pred);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
    {
        final Iterator<T> iterator = iterable.iterator();
        return collect(iterator,pred);
    }

    public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred)
    {
        List<T> list = new ArrayList<T>();
        while (iterator.hasNext())
        {
            T current = iterator.next();
            if(pred.predicate(current))
            {
                list.add(current);
            }
        }
        return list;
    }

    //method count
    public static <T> int count(T[] array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }

    public static <T> int count(Iterable<T> iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return count(it,value);
    }

    public static <T> int count(Iterator<T> iterator, T value)
    {
        final Predicate<T> pred = value::equals;
        return count(iterator,pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it,pred);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred)
    {
        int count = 0;
        while (iterator.hasNext())
        {
            if(pred.predicate(iterator.next())){
                count++;
            }
        }
        return count;
    }

    //method find
    public static <T> T find (T[] array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it,value);
    }

    public static <T> T find (Iterable <T> iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return find(it,value);
    }

    public static <T> T find (Iterator <T> iterator, T value)
    {
        final Predicate<T> pred = value :: equals;
        return find(iterator,pred);
    }

    public static <T> T find (T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return find(it, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return find(it,pred);
    }

    public static <T> T find (Iterator <T> iterator, Predicate<T> pred)
    {
        while (iterator.hasNext())
        {
            T current = iterator.next();
            if(pred.predicate(current))
            {
                return current;
            }
        }
        return null;
    }

    //method findIndex
    public static <T> int findIndex(T[] array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return findIndex(it, value);
    }

    public static <T> int findIndex(Iterable<T> iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return findIndex(it, value);
    }

    public static <T> int findIndex(Iterator<T> iterator, T value)
    {
        final Predicate<T> pred = value::equals;
        return findIndex(iterator, pred);
    }

    public static <T> int findIndex(T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return findIndex(it, pred);
    }

    public static <T> int findIndex(Iterable<T> iterable, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return findIndex(it, pred);
    }

    public static <T> int findIndex(Iterator<T> iterator, Predicate<T> pred)
    {
        for (int i = 0; iterator.hasNext(); ++i)
            if (pred.predicate(iterator.next()))
                return i;
        return -1;
    }

    //method exist
    public static <T> boolean exist (T[] array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exist(it, value);
    }

    public static <T> boolean exist (Iterable <T> iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return exist(it, value);
    }

    public static <T> boolean exist (Iterator <T> iterator, T value)
    {
        final Predicate<T> pred = value::equals;
        return exist(iterator, pred);
    }

    public static <T> boolean exist (T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exist(it, pred);
    }

    public static <T> boolean exist (Iterable <T> iterable, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return exist(it, pred);
    }

    public static <T> boolean exist (Iterator <T> iterator, Predicate<T> pred)
    {
        while (iterator.hasNext())
        {
            T current = iterator.next();
            if(pred.predicate(current))
            {
                return true;
            }
        }
        return false;
    }

    //method max
    public static <T extends Comparable<? super T>> T max (T first, T second)
    {
        if(first.compareTo(second) > 0)
        {
            return first;
        }
        else
        {
            return second;
        }
    }

    public static <T extends Comparable<? super T>> T max(T[] array)
    {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return max(iterator);
    }

    public static <T extends Comparable<? super T>> T max(Iterable<T> iterable)
    {
        final Iterator<T> iterator = iterable.iterator();
        return max(iterator);
    }

    public static <T extends Comparable<? super T>> T max(Iterator<T> iterator)
    {
        T biggest = null;
        while (iterator.hasNext() && biggest == null)
        {
            biggest = iterator.next();
        }
        while (iterator.hasNext())
        {
            T next = iterator.next();
            if (next == null) continue;
            biggest = max(biggest, next);
        }
        return biggest;
    }

    public static <T extends Comparator<? super T>> T max(T first, T second, Comparator<? super T> comparator)
    {
        if(comparator.compare(first, second) >= 0)
        {
            return first;
        }
        else
        {
            return second;
        }
    }

    public static <T extends Comparator<? super T>> T max(T[] array, Comparator<? super T> comparator)
    {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return max(iterator,comparator);
    }

    public static <T extends Comparator<? super T>> T max(Iterable<T> iterable, Comparator<? super T> comparator)
    {
        final Iterator<T> iterator = iterable.iterator();
        return max(iterator, comparator);
    }

    public static <T extends Comparator<? super T>> T max(Iterator<T> iterator, Comparator<? super T> comparator)
    {
        T biggest = null;
        while (iterator.hasNext() && biggest == null)
        {
            biggest = iterator.next();
        }

        while (iterator.hasNext())
        {
            T next = iterator.next();
            if (next == null) continue;
            biggest = max(biggest, next, comparator);
        }

        return biggest;
    }

    //method min
    public static <T extends Comparable<? super T>> T min(T first, T second)
    {
        if(first.compareTo(second)<0)
        {
            return first;
        }
        else
        {
            return second;
        }
    }

    public static <T extends Comparable<? super T>> T min(T[] array)
    {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return min(iterator);
    }

    public static <T extends Comparable<? super T>> T min(Iterable<T> iterable)
    {
        final Iterator<T> iterator = iterable.iterator();
        return min(iterator);
    }

    public static <T extends Comparable<? super T>> T min(Iterator<T> iterator)
    {
        T smallest = null;
        while (iterator.hasNext() && smallest == null)
        {
            smallest = iterator.next();
        }

        while (iterator.hasNext())
        {
            T next = iterator.next();
            if (next == null) continue;
            smallest = min(smallest, next);
        }
        return smallest;
    }

    public static <T extends Comparator<? super T>> T min(T first, T second, Comparator<? super T> comparator)
    {
        if(comparator.compare(first,second)<=0){
            return first;
        }
        else {
            return second;
        }
    }

    public static <T extends Comparator<? super T>> T min(T[] array, Comparator<? super T> comparator)
    {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return min(iterator, comparator);
    }

    public static <T extends Comparator<? super T>> T min(Iterable<T> iterable, Comparator<? super T> comparator)
    {
        final Iterator<T> iterator = iterable.iterator();
        return min(iterator, comparator);
    }

    public static <T extends Comparator<? super T>> T min(Iterator<T> iterator, Comparator<? super T> comparator)
    {
        T smallest = null;
        while (iterator.hasNext() && smallest == null)
        {
            smallest = iterator.next();
        }

        while (iterator.hasNext())
        {
            T next = iterator.next();
            if (next == null) continue;
            smallest = min(smallest, next, comparator);
        }
        return smallest;
    }


//method paginate
    public static <T> List<T> paginate(T[] array, int page, int pageSize, Predicate<T> pred)
    {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return paginate(iterator,page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterable<T> iterable, int page, int pageSize, Predicate<T> pred)
    {
        final Iterator<T> iterator = iterable.iterator();
        return paginate(iterator, page, pageSize, pred);
    }

    public static <T> List<T> paginate(Iterator<T> iterator, int page, int pageSize, Predicate<T> pred)
    {
        int occurrences = 0;
        int startingIndex = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);

        //skip first occurrences of element
        while(iterator.hasNext() && occurrences < startingIndex)
        {
            T object = iterator.next();
            if (pred.predicate(object))
                occurrences++;
        }

        //get the next occurrences of element
        while (iterator.hasNext() && pageList.size() < pageSize)
        {
            T object = iterator.next();
            if (pred.predicate(object))
                pageList.add(object);
        }
        return pageList;
    }

}
