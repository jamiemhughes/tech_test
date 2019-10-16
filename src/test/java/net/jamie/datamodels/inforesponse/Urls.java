
package net.jamie.datamodels.inforesponse;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "website",
    "technical_doc",
    "twitter",
    "reddit",
    "message_board",
    "announcement",
    "chat",
    "explorer",
    "source_code"
})
public class Urls {

    @JsonProperty("website")
    private List<String> website = null;
    @JsonProperty("technical_doc")
    private List<String> technicalDoc = null;
    @JsonProperty("twitter")
    private List<String> twitter = null;
    @JsonProperty("reddit")
    private List<String> reddit = null;
    @JsonProperty("message_board")
    private List<String> messageBoard = null;
    @JsonProperty("announcement")
    private List<String> announcement = null;
    @JsonProperty("chat")
    private List<String> chat = null;
    @JsonProperty("explorer")
    private List<String> explorer = null;
    @JsonProperty("source_code")
    private List<String> sourceCode = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("website")
    public List<String> getWebsite() {
        return website;
    }

    @JsonProperty("website")
    public void setWebsite(List<String> website) {
        this.website = website;
    }

    @JsonProperty("technical_doc")
    public List<String> getTechnicalDoc() {
        return technicalDoc;
    }

    @JsonProperty("technical_doc")
    public void setTechnicalDoc(List<String> technicalDoc) {
        this.technicalDoc = technicalDoc;
    }

    @JsonProperty("twitter")
    public List<String> getTwitter() {
        return twitter;
    }

    @JsonProperty("twitter")
    public void setTwitter(List<String> twitter) {
        this.twitter = twitter;
    }

    @JsonProperty("reddit")
    public List<String> getReddit() {
        return reddit;
    }

    @JsonProperty("reddit")
    public void setReddit(List<String> reddit) {
        this.reddit = reddit;
    }

    @JsonProperty("message_board")
    public List<String> getMessageBoard() {
        return messageBoard;
    }

    @JsonProperty("message_board")
    public void setMessageBoard(List<String> messageBoard) {
        this.messageBoard = messageBoard;
    }

    @JsonProperty("announcement")
    public List<String> getAnnouncement() {
        return announcement;
    }

    @JsonProperty("announcement")
    public void setAnnouncement(List<String> announcement) {
        this.announcement = announcement;
    }

    @JsonProperty("chat")
    public List<String> getChat() {
        return chat;
    }

    @JsonProperty("chat")
    public void setChat(List<String> chat) {
        this.chat = chat;
    }

    @JsonProperty("explorer")
    public List<String> getExplorer() {
        return explorer;
    }

    @JsonProperty("explorer")
    public void setExplorer(List<String> explorer) {
        this.explorer = explorer;
    }

    @JsonProperty("source_code")
    public List<String> getSourceCode() {
        return sourceCode;
    }

    @JsonProperty("source_code")
    public void setSourceCode(List<String> sourceCode) {
        this.sourceCode = sourceCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
