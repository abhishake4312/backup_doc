package factory.notification;

import factory.notification.notification.Notification;
import factory.notification.sender.NotificationSender;
import factory.notification.template.NotificationTemplate;

public abstract class NotificationFactory {
    public abstract NotificationType notificationType();
    public abstract Notification createNotification(String recipient, String sender,NotificationTemplate template);
    public abstract NotificationSender createNotificationSender(Notification notification);
    public abstract NotificationTemplate createNotificationTemplate(String message);

}
