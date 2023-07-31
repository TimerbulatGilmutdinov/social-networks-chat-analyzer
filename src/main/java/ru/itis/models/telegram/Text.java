package ru.itis.models.telegram;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Text {
    public Text(String text) {
        this.text = text;
    }
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type;
    private String href;
    @JsonProperty("document_id")
    private String documentId;
    private String text;
}
