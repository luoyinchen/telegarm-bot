package org.luoyinchen.telegrambot.exception;

public class BotException extends RuntimeException {

    private final String message;
    private final int code;

    public BotException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BotException(int code) {
        this.code = code;
        this.message = "BOT EXCEPTION";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
