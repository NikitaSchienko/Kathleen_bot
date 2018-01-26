import configurations.Config;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot
{

    public static void main(String[] args)
    {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try
        {
            telegramBotsApi.registerBot(new Bot());
        }
        catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("deprecation")
    private void sendMessange(Message message, String text)
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

        String text = message.getText();

        for (String command: Config.COMMANDS_LIST)
        {
            /*if(text.equals(command))
            {
                sendMessange(message,"");
            }*/
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
