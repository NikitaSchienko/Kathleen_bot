package main.java.birthdays;

import java.text.SimpleDateFormat;

public class Holiday
{
    private String text;
    private Long date;
    private int type;

    public void setType(int type)
    {
        this.type = type;
    }

    public int getType()
    {
        return type;
    }

    public Holiday(String text, Long date, int type)
    {
        this.type = type;
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
