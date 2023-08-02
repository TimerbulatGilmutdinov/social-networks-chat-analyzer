package ru.itis.services;

import ru.itis.models.telegram.Chat;

import java.io.File;
import java.util.List;

public interface TelegramChatAnalyzerService {
    long getSentMessagesCountByAuthor(String author);
    long getAllSentMessagesCount();
    long getSentStickerEmojisCount();
    List<String> getContainsStringMessages(String str, boolean ignoringCase);
    String  getMostPopularStickerEmoji();
    void setChat(Chat chat);
    void setChat(File jsonChat);
}
