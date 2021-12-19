package com.valyaJmartPK;

/**
 * Represents two objects in pairs
 *
 * @author Valya Sandria Akiela
 * @version 1.0
 */
public class Pair <T,U>{
    T first;
    U second;

    public Pair() {}

     public Pair (T first, U second)
     {
         this.first = first;
         this.second = second;
     }
}
