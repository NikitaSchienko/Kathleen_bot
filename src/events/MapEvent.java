package events;

import events.Event;
import events.FileEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapEvent
{
    private Map<Integer,Event> mapEvents = new HashMap<Integer, Event>();

    public MapEvent()
    {
        mapEvents = FileEvent.loadingListEvent();
    }

    public Map<Integer,Event> getMapBirthday()
    {
        return mapEvents;
    }

    private void addEvent(Integer id, Event event)
    {
        mapEvents.put(id,event);
        FileEvent.saveListEvent(mapEvents);
    }

    private void updateEvent(Integer id, Event event)
    {
        mapEvents.put(id,event);
        FileEvent.saveListEvent(mapEvents);
    }

    private void deleteEvent(Integer id)
    {
        mapEvents.remove(id);
        FileEvent.saveListEvent(mapEvents);
    }

}
