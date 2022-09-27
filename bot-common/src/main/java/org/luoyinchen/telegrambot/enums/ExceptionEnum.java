package org.luoyinchen.telegrambot.enums;

public enum ExceptionEnum {
    //region telegram bot exception
    BOT_REGISTER_FINISH_BUT_NOT_RUNNING(7000, " BOT 注册完成，但未处于运行状态");
    //endregion
    private final int code;
    private final String info;

    ExceptionEnum(int code, String message) {
        this.code = code;
        this.info = message;
    }

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
