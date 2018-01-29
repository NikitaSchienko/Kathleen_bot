package main.java.birthdays;

import main.java.bots.Bot;
import main.java.configurations.Config;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotificationHoliday extends Thread
{
    private Bot bot;
    private HolidayList holidayList;

    public NotificationHoliday(Bot bot)
    {
        this.bot = bot;
        holidayList = new HolidayList(Config.URL_PATH_FILE);
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                Thread.sleep(10000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM");
            Date currentDate = new Date();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(Config.ID_CHAT);

            String textMessageBirthday = new String();
            String textMessageHoliday = new String();
            String textMessageWedding = new String();

            for (Holiday holiday : holidayList.getListBirthday())
            {
                if(dateFormat.format(holiday.getDate()).equals(dateFormat.format(currentDate)) && holiday.getType() == Config.ID_BIRTHDAY)
                {
                    textMessageBirthday += holiday.toString()+'\n';
                }
                if(dateFormat.format(holiday.getDate()).equals(dateFormat.format(currentDate)) && holiday.getType() == Config.ID_WEDDING_DAY)
                {
                    textMessageWedding += holiday.toString()+'\n';
                }
                if(dateFormat.format(holiday.getDate()).equals(dateFormat.format(currentDate)) && holiday.getType() == Config.ID_HOLIDAY)
                {
                    textMessageHoliday += holiday.toString()+'\n';
                }
            }


            if(textMessageBirthday.length()>0)
            {
                sendMessage.setText("Сегодня " + dateFormat.format(currentDate) + " День Рождение:\n" + textMessageBirthday);

                try
                {
                    bot.sendMessage(sendMessage);
                }
                catch (TelegramApiException e)
                {
                    e.printStackTrace();
                }
            }
            if(textMessageWedding.length()>0)
            {
                sendMessage.setText("Сегодня " + dateFormat.format(currentDate) + " День Свадьбы:\n" + textMessageWedding);

                try
                {
                    bot.sendMessage(sendMessage);
                }
                catch (TelegramApiException e)
                {
                    e.printStackTrace();
                }
            }
            if(textMessageHoliday.length()>0)
            {
                sendMessage.setText("Сегодня " + dateFormat.format(currentDate) + " праздники:\n" + textMessageHoliday);

                try
                {
                    bot.sendMessage(sendMessage);
                }
                catch (TelegramApiException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
