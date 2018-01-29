package main.java.bots;

import main.java.birthdays.NotificationBirthday;
import main.java.configurations.Config;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot
{
    public Bot()
    {
        Thread thread = new Thread(new NotificationBirthday(this));
        thread.start();

    }

    @SuppressWarnings("deprecation")
    public void send(Message message, String text)
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId());
        sendMessage.setText(text);


        try
        {
            sendMessage(sendMessage);
        }
        catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }



    @Override
    public void onUpdateReceived(Update update)
    {
        Message message = update.getMessage();
        if(message != null && message.hasText())
        {
            String text = message.getText();


            switch (text)
            {
                case "Привет":
                {
                    send(message, "Привет, " + message.getFrom().getFirstName());
                }
                break;
                case "Как дела":
                {
                    send(message, "Хорошо, а как у тебя?");
                }
                break;
                default:
                {
                    send(message, "Я вас не понимаю");
                }
            }
        }
    }

    @Override
    public String getBotUsername()
    {
        return Config.NAME_BOT;
    }

    @Override
    public String getBotToken()
    {
        return Config.TOKEN_BOT;
    }
}
