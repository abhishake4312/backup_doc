package factory.notification;

import factory.notification.notification.Notification;
import factory.notification.notification.PushNotification;
import factory.notification.sender.NotificationSender;
import factory.notification.sender.PushNotificationSender;
import factory.notification.template.NotificationTemplate;
import factory.notification.template.PushNotificationTemplate;

public class PushNotificationFactory extends NotificationFactory {
    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }

    @Override
    public Notification createNotification(String recipient, String sender, NotificationTemplate template) {
        return new PushNotification(recipient, template);
    }

    @Override
    public NotificationSender createNotificationSender(Notification notification) {
        return new PushNotificationSender(notification);
    }

    @Override
    public NotificationTemplate createNotificationTemplate(String message) {
        return new PushNotificationTemplate(message);
    }
}
