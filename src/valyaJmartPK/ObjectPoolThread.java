package valyaJmartPK;

import java.util.ArrayList;
import java.util.Vector;
import java.util.function.Function;

public class ObjectPoolThread<T> extends Thread{
    private boolean exitSignal;
    private Vector<T> objectPool;
    private Function<T, Boolean> routine;

    public ObjectPoolThread (String name, Function<T, Boolean> routine)
    {
        super(name);
        this.routine = routine;
        ObjectPoolThread thread = new ObjectPoolThread(name, routine);
        thread.start();

    }

    public ObjectPoolThread (Function<T, Boolean> routine)
    {
        this.routine = routine;
    }

    public synchronized void add(T object)
    {
        objectPool.add(object);
    }

    public synchronized void exit()
    {
       this.exitSignal = true;
    }

    public void run()
    {

        while(true)
        {
            for(int i = 0; i < objectPool.size(); i++){
                objectPool.elementAt(i);
            }

            if(objectPool == null)
            {

            }
        }

    }

    public int size()
    {
        return objectPool.size();
    }
}
