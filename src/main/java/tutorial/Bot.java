package tutorial;

import tutorial.internal.MyConstants;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return MyConstants.BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return MyConstants.BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        var message = update.getMessage();
        var sender = message.getFrom();

        System.out.println(sender.getFirstName() + " wrote \"" + message.getText() + "\"!");
    }



}