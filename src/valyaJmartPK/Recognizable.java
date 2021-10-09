package valyaJmartPK;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recognizable implements Comparable <Recognizable>
{
     public final int id;

     protected Recognizable(int id)
     {
        this.id = id;
     }


     public boolean equals(Object other)
     {
         if(other instanceof Recognizable)
         {
             return equals(other);
         }
         else
         {
             return false;
         }
     }

     public boolean equals(Recognizable other)
     {
         return this.id == other.id;
     }

     public <T> int getClosingId (Class <T> clazz)
     {
        return 0;
     }

    public <T> int setClosingId (Class <T> clazz, int id)
    {
        return 0;
    }

    @Override
    public int compareTo (Recognizable other)
    {
       return Integer.compare(this.id, other.id);
    }
}

