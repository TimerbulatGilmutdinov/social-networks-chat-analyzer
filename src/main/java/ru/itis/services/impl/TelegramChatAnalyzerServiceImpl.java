package ru.itis.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.telegram.Chat;
import ru.itis.models.telegram.Message;
import ru.itis.services.TelegramChatAnalyzerService;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TelegramChatAnalyzerServiceImpl implements TelegramChatAnalyzerService {
    private Chat chat;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setChat(File jsonChat) {
        try {
            this.chat = objectMapper.readValue(jsonChat, Chat.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getSentMessagesCountByAuthor(String author) {
        List<Message> messages = chat.getMessages();
        int count = 0;
        for (Message message : messages) {
            if (message.getFrom() != null) {
                if (message.getFrom().equals(author)) {
                    count++;
                }
            }
        }
        return count;
    }
}
