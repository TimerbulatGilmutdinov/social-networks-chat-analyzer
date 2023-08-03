package ru.itis.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.telegram.Chat;
import ru.itis.models.telegram.Message;
import ru.itis.models.telegram.Text;
import ru.itis.models.telegram.TextEntities;
import ru.itis.services.TelegramChatAnalyzerService;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
    public long getSentMessagesCountByAuthor(String author) {
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

    @Override
    public long getAllSentMessagesCount() {
        return chat.getMessages().size();
    }

    @Override
    public long getSentStickerEmojisCount() {
        List<Message> messages = chat.getMessages();
        long count = 0;
        for (Message message : messages) {
            if (message.getStickerEmoji() != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String getMostPopularStickerEmoji() {
        List<Message> messages = chat.getMessages();
        Map<String, Integer> stickersMap = new HashMap<>();
        for (Message message : messages) {
            if (message.getStickerEmoji() != null) {
                if (!stickersMap.containsKey(message.getStickerEmoji())) {
                    stickersMap.put(message.getStickerEmoji(), 1);
                } else {
                    int currentCount = stickersMap.get(message.getStickerEmoji());
                    stickersMap.put(message.getStickerEmoji(), currentCount + 1);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (String date : stickersMap.keySet()) {
            list.add(stickersMap.get(date));
        }
        list.sort(Comparator.naturalOrder());
        int max = list.get(list.size() - 1);
        String maxSticker = "";
        for (String date : stickersMap.keySet()) {
            if (stickersMap.get(date) == max) {
                maxSticker = date;
            }
        }
        return maxSticker;
    }

    public List<String> getContainsStringMessages(String str, boolean ignoringCase) {
        List<Message> messages = chat.getMessages();
        List<String> containsList = new ArrayList<>();
        if (ignoringCase) {
            return getContainsListIgnoringCase(messages, str);
        }
        for (Message message : messages) {
            for (TextEntities text : message.getTextEntities()) {
                if (text.getText().contains(str)) {
                    containsList.add(text.getText());
                }
            }
        }
        return containsList;
    }

    private List<String> getContainsListIgnoringCase(List<Message> messages, String str) {
        List<String> containsList = new ArrayList<>();
        for (Message message : messages) {
            for (TextEntities text : message.getTextEntities()) {
                if (text.getText().toLowerCase().contains(str.toLowerCase())) {
                    containsList.add(text.getText());
                }
            }
        }
        return containsList;
    }

    public List<Message> getContainsStringMessagesList(String str, boolean ignoringCase) {
        List<Message> messages = chat.getMessages();
        List<Message> containsList = new ArrayList<>();
        if (ignoringCase) {
            return getContainsStringMessagesListIgnoringCase(messages, str);
        }
        for (Message message : messages) {
            for (TextEntities text : message.getTextEntities()) {
                if (text.getText().contains(str)) {
                    containsList.add(message);
                }
            }
        }
        return containsList;
    }

    private List<Message> getContainsStringMessagesListIgnoringCase(List<Message> messages, String str) {
        List<Message> containsList = new ArrayList<>();
        for (Message message : messages) {
            for (TextEntities text : message.getTextEntities()) {
                if (text.getText().toLowerCase().contains(str.toLowerCase())) {
                    containsList.add(message);
                }
            }
        }
        return containsList;
    }

}
