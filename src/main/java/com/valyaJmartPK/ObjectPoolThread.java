package com.valyaJmartPK;

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
       exitSignal = true;
    }

    public void run()
    {
        exitSignal = false;
        while(objectPool != null)
        {
            boolean temp;
            for (T each : objectPool){
                if(each == null){
                    Thread.onSpinWait();
                }

                temp = routine.apply(each);

                if(!temp){
                    objectPool.add(each);
                }

                if(exitSignal){
                    break;
                }
            }
        }
    }

    public int size()
    {
        return objectPool.size();
    }
}
