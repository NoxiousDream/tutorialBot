package tutorial;


import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import tutorial.internal.MyConstants;

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
        sendText(sender.getId(), message.getText());
    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }



}