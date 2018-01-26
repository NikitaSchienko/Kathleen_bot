package events;

import configurations.Config;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;


public class FileEvent
{
    public static Map<Integer,Event> loadingListEvent()
    {
        Map<Integer,Event> eventMap = null;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Config.URL_PATH_FILE)))
        {
            eventMap = (Map<Integer, Event>) ois.readObject();
            ois.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return eventMap;
    }

    public static void saveListEvent(Map<Integer,Event> eventMap)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Config.URL_PATH_FILE)))
        {
            oos.writeObject(eventMap);
            oos.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
