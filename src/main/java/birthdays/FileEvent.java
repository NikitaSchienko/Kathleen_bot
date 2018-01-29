package main.java.birthdays;


import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;



public class FileEvent
{
    private String path;

    public FileEvent(String path)
    {
        this.path = path;
    }

    public ArrayList<Holiday> loadingListEvent()
    {
        ArrayList<Holiday> holidays = new ArrayList<Holiday>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path)))
        {
            String line = null;
            while ((line = bufferedReader.readLine())!= null)
            {
                JSONObject jsonObject =new JSONObject(line);

                Holiday holiday = new Holiday(jsonObject.getString("text"),jsonObject.getLong("date"),jsonObject.getInt("type"));
                holidays.add(holiday);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return holidays;
    }

    public void saveListEvent(ArrayList<Holiday> holidays)
    {

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path)))
        {
            for (Holiday holiday : holidays)
            {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("date", holiday.getDate());
                jsonObject.put("text", holiday.getText());
                jsonObject.put("type",holiday.getType());

                bufferedWriter.write(jsonObject.toString()+'\n');
            }
            bufferedWriter.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
