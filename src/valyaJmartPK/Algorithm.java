package valyaJmartPK;

import java.lang.reflect.Array;
import java.util.*;

public class Algorithm {

    //method collect

    public static <T> List<T> collect(T[] array, T value)
    {
        List<T> list = new ArrayList<>();
        final Iterator<T> it = Arrays.stream(array).iterator();
        for (int i = 0; i < array.length ; i++){
            list.add(array[i]);
        }
        return collect(it, value);

    }

    public static <T> List<T> collect(Iterable<T> iterable, T value)
    {
        return null;
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value)
    {
        final Predicate <T> pred = value::equals;
        return collect(iterator, (T) pred);
    }

    public <T> List<T> collect(T[] array, Predicate<T> pred)
    {
        return null;
    }

    public <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
    {
        return null;
    }

    public <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred)
    {
        return null;
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
        return count(it, value);
    }

    public static <T> int count(Iterator<T> iterator, T value)
    {
        final Predicate <T> pred = value::equals;
        return count(iterator, (T) pred);
    }

    public <T> int count(T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    public <T> int count(Iterable<T> iterable, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public <T> int count(Iterator<T> iterator, Predicate<T> pred)
    {
        int count = 0;
        for (Iterator<T> it = iterator; it.hasNext(); ) {
            Object i = it.next();
            count++;
        }
            return count;
    }


    //method find
    public <T> int find (T[] array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, value);
    }
    public <T> int find (Iterable <T> iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return count(it, value);
    }

    public <T> int find (Iterator <T> iterator, T value)
    {
        final Predicate <T> pred = value::equals;
        return count(iterator, (T) pred);
    }

    public <T> int find (T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return count(it, pred);
    }

    public <T> int find (Iterable <T> iterable, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return count(it, pred);
    }

    public <T> int find (Iterator <T> iterator, Predicate<T> pred)
    {
        int count = 0;
        for (Iterator<T> it = iterator; it.hasNext(); ) {
            Object i = it.next();
            count++;
        }
        return count;
    }

    //method exist
    public <T> boolean exist (T[] array, T value)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exist(it, value);
    }

    public <T> boolean exist (Iterable <T> iterable, T value)
    {
        final Iterator<T> it = iterable.iterator();
        return exist(it, value);
    }

    public <T> boolean exist (Iterator <T> iterator, T value)
    {
        final Predicate <T> pred = value::equals;
        return exist(iterator, value);
    }

    public <T> boolean exist (T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return exist(it, pred);
    }

    public <T> boolean exist (Iterable <T> iterable, Predicate<T> pred)
    {
        final Iterator<T> it = iterable.iterator();
        return exist(it, pred);
    }

    public <T> boolean exist (Iterator <T> iterator, Predicate<T> pred)
    {
        while(iterator.hasNext())
        {
            if (iterator.next().equals(pred)){
                return true;
            }
        }
        return false;
    }

    //method max
    public <T> T max (T first, T second)
    {

        return null;
    }

    public <T> T max (T[] array)
    {
        T max = null;
        for(T item: array) {
            if (max == null) {
                max = item;
            }
        }
        return max;
    }

    public <T> T max (Iterable <T> iterable)
    {
        return null;
    }

    public <T> T max (Iterator <T> iterator)
    {
        return null;
    }

    public <T, comparator> T max (T first, T second, Comparator<? super T> comparator)
    {
        return null;
    }
    public <T, comparator> T max (T[] array, Comparator<? super T> comparator)
    {
        return null;
    }

    public <T, comparator> T max (Iterable<T> iterable, Comparator<? super T> comparator)
    {
        return null;
    }

    public <T, comparator> T max (Iterator<T> iterator, Comparator<? super T> comparator)
    {
        return null;
    }

    //method min
    public <T> T min (T first, T second)
    {
        return null;
    }

    public <T> T min (T[] array)
    {
        T min = null;
        for(T item: array) {
            if (min == null) {
                min = item;
            }
        }
        return min;
    }


    public <T> T min (Iterable <T> iterable)
    {
        return null;
    }

    public <T> T min (Iterator <T> iterator)
    {
        return null;
    }

    public <T, comparator> T min (T first, T second, Comparator<? super T> comparator)
    {
        return null;
    }
    public <T, comparator> T min (T[] array, Comparator<? super T> comparator)
    {

        return null;
    }

    public <T, comparator> T min (Iterable<T> iterable, Comparator<? super T> comparator)
    {
        return null;
    }

    public <T, comparator> T min (Iterator<T> iterator, Comparator<? super T> comparator)
    {
        return null;
    }


}
