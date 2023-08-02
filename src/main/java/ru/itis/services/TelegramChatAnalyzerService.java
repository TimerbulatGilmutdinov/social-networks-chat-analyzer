package ru.itis.services;

import ru.itis.models.telegram.Chat;

import java.io.File;

public interface TelegramChatAnalyzerService {
    long getSentMessagesCountByAuthor(String author);
    long getAllSentMessagesCount();
    long getSentStickerEmojisCount();
    String  getMostPopularStickerEmoji();
    void setChat(Chat chat);
    void setChat(File jsonChat);
}
