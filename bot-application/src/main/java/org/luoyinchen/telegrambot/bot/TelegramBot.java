package org.luoyinchen.telegrambot.bot;

import org.luoyinchen.telegrambot.constant.CommonConstant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${telegram-bots.botName}")
    private String botUserName;
    @Value("${telegram-bots.botToken}")
    private String botToken;

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() && update.getMessage().hasText()) return;
        String content = update.getMessage().getText();
        //消息包含指令
        if (content.contains(CommonConstant.SLASH_SYMBOL)) {

        }
    }
}
