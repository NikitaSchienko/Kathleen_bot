package main.java.birthdays;

import java.text.SimpleDateFormat;

public class Birthday
{
    private String text;
    private Long date;

    public Birthday(String text, Long date)
    {
        this.text = text;
        this.date = date;
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

    @Override
    public String toString()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return text + " " + dateFormat.format(date);
    }
}
