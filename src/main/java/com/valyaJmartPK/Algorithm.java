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
        List<T> list = new ArrayList<>();
        final Iterator<T> it = Arrays.stream(array).iterator();
        for (T m:array) {
            list.add(m);
        }
        return collect(it, value);

    }

    public static <T> List<T> collect(Iterable<T> iterable, T value)
    {
        final Iterable<T> e = (Iterable<T>) iterable.iterator();
        return collect(e, value);
    }

    public static <T> List<T> collect(Iterator<T> iterator, T value)
    {
        final Predicate <T> pred = value::equals;
        return collect(iterator, value);
    }

    public <T> List<T> collect(T[] array, Predicate<T> pred)
    {
        final Iterator<T> it = Arrays.stream(array).iterator();
        return collect(it, pred);
    }

    public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred)
    {
        return null;
    }

    public <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred)
    {
        int count = 0;
        while(iterator.hasNext()){
            count++;
        }
        final Predicate<T> predicate = pred::equals;
        return collect(iterator, pred);
    }

    //method count
    public static <T> int count(T[] array, T value)
    {
        return array.length;
    }

    public static <T> int count(Iterable<T> iterable, T value)
    {
        int count = 0;
        for(Object obj : iterable){
            count++;
        }
        return count;
    }

    public static <T> int count(Iterator<T> iterator, T value)
    {
        int count = 0;
        while (iterator.hasNext()){
            count++;
        }
        return count;
    }

    public <T> int count(T[] array, Predicate<T> pred)
    {
        int count = 0;
        if (pred.equals(false)) {
            return 0;
        }else{
            for (T x:array){
                count++;
            }
        }
        return count;
    }

    public <T> int count(Iterable<T> iterable, Predicate<T> pred)
    {
        int count = 0;
        if (pred.equals(false)) {
            return 0;
        }else{
            for (T x:iterable){
                count++;
            }
        }
        return count;
    }

    public <T> int count(Iterator<T> iterator, Predicate<T> pred)
    {
        int count = 0;
        if (pred.equals(false)) {
            return 0;
        }else{
            while (iterator.hasNext()){
                count++;
            }
        }
        return count;
    }

    //method find
    public <T> T find (T[] array, T value)
    {
        for (T x:array){
            if(x.equals(value)){
                return x;
            }
        }
        return null;
    }

    public <T> T find (Iterable <T> iterable, T value)
    {
        for (T x:iterable){
            if(x.equals(value)){
                return x;
            }
        }
        return null;
    }

    public <T> T find (Iterator <T> iterator, T value)
    {
        while (iterator.hasNext()){
            if(iterator.next().equals(value)){
                return iterator.next();
            }
        }
        return null;
    }

    public <T> T find (T[] array, Predicate<T> pred)
    {
        for (T x:array){
            if(x.equals(pred)){
                return x;
            }
        }
        return null;
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred)
    {
        for (T x : iterable){
            if(x.equals(pred)){
                return x;
            }
        }
        return null;
    }

    public <T> T find (Iterator <T> iterator, Predicate<T> pred)
    {
        while (iterator.hasNext()){
            if(iterator.next().equals(pred)){
                return iterator.next();
            }
        }
        return null;
    }

    //method exist
    public <T> boolean exist (T[] array, T value)
    {
        for (T x: array){
            if(x.equals(value)){
                return true;
            }
        }
        return false;
    }

    public <T> boolean exist (Iterable <T> iterable, T value)
    {
        for (T x:iterable){
            if(x.equals(value)){
                return true;
            }
        }
        return false;
    }

    public <T> boolean exist (Iterator <T> iterator, T value)
    {
        while (iterator.hasNext()){
            if (iterator.next().equals(value)){
                return true;
            }
        }
        return false;
    }

    public <T> boolean exist (T[] array, Predicate<T> pred)
    {
        for (T x:array){
            if(x.equals(pred)){
                return true;
            }
        }
        return false;
    }

    public <T> boolean exist (Iterable <T> iterable, Predicate<T> pred)
    {
        for (T x:iterable){
            if(x.equals(pred)){
                return true;
            }
        }
        return false;
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
        int max = 0;
        T maxT = null;
        for(T m:array) {
            if (m.hashCode() > max) {
                max = m.hashCode();
                maxT = m;
            }
        }
        return maxT;
    }

    public <T> T max (Iterable <T> iterable)
    {
        int max = 0;
        T maxT = null;
        for (T m:iterable) {
            if (m.hashCode() > max) {
                max = m.hashCode();
                maxT = m;
            }
        }
        return maxT;
    }

    public <T> T max (Iterator <T> iterator)
    {
        int max = 0;
        T maxT = null;
        while (iterator.hasNext()) {
            if (iterator.next().hashCode() > max) {
                max = iterator.next().hashCode();
                maxT = iterator.next();
            }
        }
        return maxT;
    }

    public <T> T max (T first, T second, Comparator<? super T> comparator)
    {
        int result = ((Comparable<T>) first).compareTo(second);
        return result < -1? second : first;
    }

    public <T> T max (T[] array, Comparator<? super T> comparator)
    {
        return null;
    }

    public <T> T max (Iterable<T> iterable, Comparator<? super T> comparator)
    {
        T maxT = null;
        for(T m:iterable) {
            if (((Comparable<T>) maxT).compareTo(m) < 0) {
                maxT = m;
            }
        }
        return maxT;
    }

    public <T> T max (Iterator<T> iterator, Comparator<? super T> comparator)
    {
        T maxT = null;
        for (Iterator<T> it = iterator; it.hasNext(); ) {
            T m = it.next();
            if (((Comparable<T>) maxT).compareTo(m) < 0) {
                maxT = m;
            }
        }
        return maxT;
    }

    //method min
    public <T> T min (T first, T second)
    {
        if(first.hashCode()>second.hashCode())
        {
            return second;
        }
        else
        {
            return first;
        }
    }

    public <T> T min (T[] array)
    {
        int min = array[0].hashCode();
        T minT = null;
        for (T m:array) {
            if (m.hashCode() > min) {
                min = m.hashCode();
                minT = m;
            }
        }
        return minT;
    }

    public <T> T min (Iterable <T> iterable)
    {
        int min = iterable.hashCode();
        T minT = null;
        for (T m:iterable) {
            if (m.hashCode() > min) {
                min = m.hashCode();
                minT = m;
            }
        }
        return minT;
    }

    public <T> T min (Iterator <T> iterator)
    {
        int min = iterator.next().hashCode();
        T minT = null;
        while (iterator.hasNext()) {
            if (iterator.next().hashCode() > min) {
                min = iterator.next().hashCode();
                minT = iterator.next();
            }
        }
        return minT;
    }

    public <T> T min (T first, T second, Comparator<? super T> comparator)
    {
        int result = ((Comparable<T>) first).compareTo(second);
        return result > -1? second : first;
    }

    public <T> T min (T[] array, Comparator<? super T> comparator)
    {
        return null;
    }

    public <T> T min (Iterable<T> iterable, Comparator<? super T> comparator)
    {
        return null;
    }

    public <T> T min (Iterator<T> iterator, Comparator<? super T> comparator)
    {
        return null;
    }

    public static <T> List<T> paginate (T[] array, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> iterator = Arrays.stream(array).iterator();
        return paginate(iterator,page,pageSize,pred);
    }

    public static <T> List<T> paginate (Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
        final Iterator<T> iterator = iterable.iterator();
        return paginate(iterator, page, pageSize, pred);
    }

    public static <T> List<T> paginate (Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
        int occurences = 0;
        int startIdx = page * pageSize;
        List<T> pageList = new ArrayList<>(pageSize);

        while(iterator.hasNext() && occurences < startIdx)
        {
            if (pred.predicate(iterator.next()))
            {
                occurences++;
            }

        }
        while (iterator.hasNext() && pageList.size() < pageSize){
            T current = iterator.next();
            if (pred.predicate(current))
            {
                pageList.add(current);
            }

        }
        return pageList;
    }
}
