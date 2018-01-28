package birthdays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BirthdayList
{
    private ArrayList<Birthday> birthdays;
    private FileEvent fileEvent;

    public BirthdayList(String path)
    {
        fileEvent = new FileEvent(path);
        birthdays = fileEvent.loadingListEvent();
    }

    public ArrayList<Birthday> getListBirthday()
    {
        return birthdays;
    }

    public void addBirthday(Birthday birthday)
    {
        birthdays.add(birthday);
        fileEvent.saveListEvent(birthdays);
    }

    public void updateBirthday(Birthday oldBirthday, Birthday newBirthday)
    {
        birthdays.remove(oldBirthday);
        birthdays.add(newBirthday);
        fileEvent.saveListEvent(birthdays);
    }

    public void deleteBirthday(Birthday birthday)
    {
        birthdays.remove(birthday);
        fileEvent.saveListEvent(birthdays);
    }

}
