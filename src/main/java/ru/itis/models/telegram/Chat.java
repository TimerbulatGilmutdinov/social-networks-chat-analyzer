package ru.itis.models.telegram;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private String name;
    private String type;
    private long id;
    private List<Message> messages;
}
