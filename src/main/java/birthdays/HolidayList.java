package main.java.birthdays;

import java.util.ArrayList;

public class HolidayList
{
    private ArrayList<Holiday> holidays;
    private FileEvent fileEvent;

    public HolidayList(String path)
    {
        fileEvent = new FileEvent(path);
        holidays = fileEvent.loadingListEvent();
    }

    public ArrayList<Holiday> getListBirthday()
    {
        return holidays;
    }

    public void addHoliday(Holiday holiday)
    {
        holidays.add(holiday);
        fileEvent.saveListEvent(holidays);
    }

    public void updateHoliday(Holiday oldHoliday, Holiday newHoliday)
    {
        holidays.remove(oldHoliday);
        holidays.add(newHoliday);
        fileEvent.saveListEvent(holidays);
    }

    public void deleteHoliday(Holiday holiday)
    {
        holidays.remove(holiday);
        fileEvent.saveListEvent(holidays);
    }

}
