package valyaJmartPK;

import java.util.Iterator;
import java.util.Arrays;

public class Algorithm {

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

    public <T> boolean exist (T[] array, T value)
    {
        return false;

    }

    public <T> boolean exist (Iterable <T> iterable, T value)
    {
        return false;
    }

    public <T> boolean exist (Iterator <T> iterator, T value)
    {
        return false;
    }

    public <T> boolean exist (T[] array, Predicate<T> pred)
    {
        return false;
    }

    public <T> boolean exist (Iterable <T> iterable, Predicate<T> pred)
    {
        return false;
    }

    public <T> boolean exist (Iterator <T> iterator, Predicate<T> pred)
    {
        return false;
    }

    public <T> T max (T first, T second)
    {
        return null;
    }

    public <T> T min (T first, T second)
    {
        return null;
    }
}
