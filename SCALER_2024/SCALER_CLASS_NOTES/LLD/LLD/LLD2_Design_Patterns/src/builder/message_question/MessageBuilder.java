package builder.message_question;



public class MessageBuilder {
    private MessageType messageType;
    private String content;
    private String sender;
    private String recipient;
    private boolean isDelivered;
    private long timestamp;

    private MessageBuilder(Builder builder){
        this.messageType = builder.getMessageType();
        this.content = builder.getContent();
        this.sender = builder.getSender();
        this.recipient = builder.getRecipient();
        this.isDelivered = builder.isDelivered();
        this.timestamp = builder.getTimestamp();

    }
    public static class Builder {
        private MessageType messageType;
        private String content;
        private String sender;
        private String recipient;
        private boolean isDelivered;
        private long timestamp;

        public MessageType getMessageType() {
            return messageType;
        }

        public Builder setMessageType(MessageType messageType) {
            this.messageType = messageType;
            return this;
        }

        public String getContent() {
            return content;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public String getSender() {
            return sender;
        }

        public Builder setSender(String sender) {
            this.sender = sender;
            return this;
        }

        public String getRecipient() {
            return recipient;
        }

        public Builder setRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public boolean isDelivered() {
            return isDelivered;
        }

        public Builder setDelivered(boolean delivered) {
            isDelivered = delivered;
            return this;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public Builder setTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public MessageBuilder build() {
            return new MessageBuilder(this);
        }
    }
    public static Builder getBuilder() {
        return new Builder();
    }

}