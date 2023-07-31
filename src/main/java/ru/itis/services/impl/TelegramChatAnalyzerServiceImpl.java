package ru.itis.services.impl;

import ru.itis.services.TelegramChatAnalyzerService;

import java.io.File;

public class TelegramChatAnalyzerServiceImpl implements TelegramChatAnalyzerService {
    public TelegramChatAnalyzerServiceImpl(File chatJson){

    }
    @Override
    public int getSentMessagesCount(String author) {
        return 0;
    }
}
