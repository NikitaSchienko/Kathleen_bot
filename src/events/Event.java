package events;

public class Event
{
    private int id;
    private String text;
    private Long date;

    public Event(String text, Long date)
    {
        this.text = text;
        this.date = date;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }


    public String getText()
    {
        return text;
    }

    public Long getDate()
    {
        return date;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public void setDate(Long date)
    {
        this.date = date;
    }
}
