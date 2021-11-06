package valyaJmartPK;


import java.util.HashMap;
import java.util.Map;
import java.io.*;
import java.io.File;
import java.io.IOException;

/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Serializable implements Comparable <Serializable>
{
     public final int id;
     private HashMap<Integer, Class<?>> mapCounter = new HashMap<>();
     
     protected Serializable()
     {
         int count = 0;
         this.id = count++;
         mapCounter.put(0, getClass());

     }

    public int compareTo (Serializable other)
    {
        return other.id/this.id;

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

