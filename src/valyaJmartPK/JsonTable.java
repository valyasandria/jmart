package valyaJmartPK;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;


public class JsonTable<T> extends Vector <Object>{
    public final String filepath;
    private static final Gson gson = new Gson();

    public static <T> T readJson (Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader readJson = new JsonReader(new FileReader(filepath));
        return gson.fromJson(readJson, clazz);
    }

    public void writeJson() throws IOException
    {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException
    {
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }

    //constructor
    public JsonTable(Class<T> clazz, String filepath) throws IOException
    {
        this.filepath = filepath;

        try
        {
            Class<T[]> arrType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] loaded = readJson(arrType, filepath);
            if (loaded != null)
            {
                Collections.addAll(this, loaded);
            }
        }
        catch (FileNotFoundException e){
            File f0 = new File(filepath);
            if(f0.createNewFile())
            {
                System.out.println("File " + f0.getName() + "is created");
            }
            else
            {
                System.out.println("File is already exist");
            }
            e.printStackTrace();
        }
    }
}
