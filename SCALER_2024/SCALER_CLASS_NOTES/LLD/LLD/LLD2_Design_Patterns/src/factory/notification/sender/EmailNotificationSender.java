package factory.notification.sender;

import factory.notification.NotificationType;
import factory.notification.notification.Notification;

public class EmailNotificationSender extends NotificationSender {
    public EmailNotificationSender(Notification notification) {
        super(notification);
    }

    @Override
    public void send() {
        System.out.println("Sending Email notification to " + getNotification().getRecipient());
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.EMAIL;
    }
}
