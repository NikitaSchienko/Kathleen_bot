package birthdays;


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

    public ArrayList<Birthday> loadingListEvent()
    {
        ArrayList<Birthday> birthdays = new ArrayList<Birthday>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path)))
        {
            String line = null;
            while ((line = bufferedReader.readLine())!= null)
            {
                JSONObject jsonObject =new JSONObject(line);

                Birthday birthday = new Birthday(jsonObject.getString("text"),jsonObject.getLong("date"));
                birthdays.add(birthday);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return birthdays;
    }

    public void saveListEvent(ArrayList<Birthday> birthdays)
    {

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path)))
        {
            for (Birthday birthday : birthdays)
            {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("date",birthday.getDate());
                jsonObject.put("text",birthday.getText());

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
