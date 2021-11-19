package com.valyaJmartPK;


import java.util.HashMap;
import java.util.Map;

/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Serializable implements Comparable <Serializable>
{
    public final int id;
    private HashMap<Class<?>, Integer> mapCounter = new HashMap<>();


     protected Serializable()
     {
         id = 0;
         Integer count = mapCounter.get(getClass());
         if(count == null)
         {
             count = 0;
         }
         else
         {
             mapCounter.put(getClass(), count + 1);
         }

     }

    public int compareTo (Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }

     public boolean equals(Object other)
     {
         if(!(other instanceof Serializable)){
             Serializable check = (Serializable) other;
             if(check.id == this.id)
             {
                 return true;
             }
         }
         return false;
     }

     public boolean equals(Serializable other)
     {
         if(this.id == other.id)
         {
             return true;
         }
         return false;
     }

     public <T> int getClosingId (Class <T> clazz)
     {
         if(clazz.isAssignableFrom(Serializable.class))
         {
             return 0;
         }
         else
         {
             return 1;
         }
     }

    public <T> int setClosingId (Class <T> clazz, int id)
    {
        if(clazz.isAssignableFrom(Serializable.class))
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
}

