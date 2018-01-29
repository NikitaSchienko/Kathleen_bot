package main.java.bots;

import main.java.configurations.Config;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;


public class Bot extends TelegramLongPollingBot
{
    private ArrayList<String> dialog;

    public Bot()
    {
        dialog = new ArrayList<String>();
        //Thread thread = new Thread(new NotificationHoliday(this));
        //thread.start();
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
        dialog.add(update.getMessage().getText());

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
                case "Как дела?":
                {
                    send(message, "Хорошо, а как у тебя?");
                }
                break;
                case "Какая погода?":
                {

                }
                break;
                case "Что идет в кино?":
                {

                }
                break;
                case "Куда сходить?":
                {

                }
                break;
                case "Что посмотреть?":
                {

                }
                break;
                default:
                {
                    String answer = "Я вас не понимаю, вы можете спросить у меня:"
                            +"\nКакая погода?"
                            +"\nЧто идет в кино?"
                            +"\nКуда сходить?"
                            +"\nЧто посмотреть?";
                    send(message, answer);
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
