//package builder.message_question;
//
//
//
//public class Message {
//
//    private MessageType messageType;
//    private String content;
//    private String sender;
//    private String recipient;
//    private boolean isDelivered;
//    private long timestamp;
//
//
//
//    public Message(MessageBuilder messageBuilder){
//        this.messageType=messageBuilder.getMessageType();
//        this.content=messageBuilder.getContent();
//        this.sender=messageBuilder.getSender();
//        this.recipient=messageBuilder.getRecipient();
//        this.isDelivered=messageBuilder.isDelivered();
//        this.timestamp=messageBuilder.getTimestamp();
//    }
//
//    public MessageType getMessageType() {
//        return messageType;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public String getSender() {
//        return sender;
//    }
//
//    public String getRecipient() {
//        return recipient;
//    }
//
//    public boolean isDelivered() {
//        return isDelivered;
//    }
//
//    public long getTimestamp() {
//        return timestamp;
//    }
//    public static MessageBuilder getMessageBuilder(){
//        return new MessageBuilder();
//    }
//}