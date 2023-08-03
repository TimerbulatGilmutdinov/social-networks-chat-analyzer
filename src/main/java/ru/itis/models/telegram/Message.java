package ru.itis.models.telegram;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private long id;
    private String type;
    private Date date;
    @JsonProperty("date_unixtime")
    private long unixTime;
    private String from;
    @JsonProperty("from_id")
    private String fromId;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private Text[] text;
    private String photo;
    private int width;
    private int height;
    @JsonProperty("reply_to_message_id")
    private int replyToMessageId;
    private String file;
    private String thumbnail;
    @JsonProperty("media_type")
    private String mediaType;
    @JsonProperty("mime_type")
    private String mimeType;
    @JsonProperty("sticker_emoji")
    private String stickerEmoji;
    @JsonProperty("duration_seconds")
    private int durationSeconds;
    private String performer;
    private String title;
    @JsonProperty("forwarded_from")
    private String forwardedFrom;
    @JsonProperty("self_destruct_period_seconds")
    private int selfDestructPeriodSeconds;
    private String actor;
    @JsonProperty("actor_id")
    private String actorId;
    private String action;
    @JsonProperty("discard_reason")
    private String discardReason;
    @JsonProperty("location_information")
    private LocationInformation locationInformation;
    @JsonProperty("live_location_period_seconds")
    private int liveLocationPeriodSeconds;
    @JsonProperty("via_bot")
    private String viaBot;
    @JsonProperty("game_title")
    private String gameTitle;
    @JsonProperty("game_description")
    private String gameDescription;
    @JsonProperty("game_link")
    private String gameLink;
    @JsonProperty("game_message_id")
    private long gameMessageId;
    private int score;
    private Date edited;
    @JsonProperty("edited_unixtime")
    private long editedUnixTime;
    private List<String> members;
    @JsonProperty("message_id")
    private long messageId;
    @JsonProperty("text_entities")
    private List<TextEntities> textEntities;
}
