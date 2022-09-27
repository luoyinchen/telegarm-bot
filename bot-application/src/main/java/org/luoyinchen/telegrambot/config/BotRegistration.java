package org.luoyinchen.telegrambot.config;

import lombok.extern.slf4j.Slf4j;
import org.luoyinchen.telegrambot.bot.TelegramBot;
import org.luoyinchen.telegrambot.enums.ExceptionEnum;
import org.luoyinchen.telegrambot.exception.BotException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Date;

@Slf4j
@Order(0)
@Component
public class BotRegistration implements ApplicationRunner {
    @Value("${telegram-bots.enable-robot-registration}")
    private boolean startRegistrar;

    @Autowired
    private TelegramBot bot;

    @Override
    public void run(ApplicationArguments args) {
        if (!startRegistrar) {
            log.warn("系统本次启动未开启BOT注册器，BOT将不会运行");
            return;
        }

        try {
            BotSession botSession = new TelegramBotsApi(DefaultBotSession.class).registerBot(bot);
            boolean running = botSession.isRunning();
            if (!running) {
                throw new BotException(ExceptionEnum.BOT_REGISTER_FINISH_BUT_NOT_RUNNING.getCode(), ExceptionEnum.BOT_REGISTER_FINISH_BUT_NOT_RUNNING.getInfo());
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
            log.error("\n 注册机器人失败！\n" + "错误信息：{}\n" + "时间戳:{}\n", e.getMessage(), new Date().getTime());
        }
    }
}
