package ru.itis.models.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TextEntities {
    private String type;
    private String href;
    @JsonProperty("document_id")
    private String documentId;
    private String text;
    @JsonProperty("user_id")
    private long userId;
}
