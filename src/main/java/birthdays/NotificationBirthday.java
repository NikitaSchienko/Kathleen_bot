package main.java.birthdays;

import main.java.bots.Bot;
import main.java.configurations.Config;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NotificationBirthday extends Thread
{
    private Bot bot;
    private BirthdayList birthdayList;

    public NotificationBirthday(Bot bot)
    {
        this.bot = bot;
        birthdayList = new BirthdayList(Config.URL_PATH_FILE);
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

            String textMessage = new String();
            for (Birthday birthday : birthdayList.getListBirthday())
            {
                if(dateFormat.format(birthday.getDate()).equals(dateFormat.format(currentDate)))
                {
                    textMessage += birthday.toString()+'\n';
                }
            }


            if(textMessage.length()>0)
            {
                sendMessage.setText("Сегодня " + dateFormat.format(currentDate) + " День Рождение:\n" + textMessage);

                try
                {
                    bot.sendMessage(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }




}
