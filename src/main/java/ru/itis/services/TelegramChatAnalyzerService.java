package ru.itis.services;

import ru.itis.models.telegram.Chat;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface TelegramChatAnalyzerService {
    long getSentMessagesCountByAuthor(String author);
    long getAllSentMessagesCount();
    long getSentStickerEmojisCount();
    List<String> getContainsStringMessages(String str, boolean ignoringCase);
    String  getMostPopularStickerEmoji();
    Map<String, Integer> getEachSenderMessagesCount();
    void setChat(Chat chat);
    void setChat(File jsonChat);
}
