package factory.notification;

import factory.notification.notification.EmailNotification;
import factory.notification.notification.Notification;
import factory.notification.sender.EmailNotificationSender;
import factory.notification.sender.NotificationSender;
import factory.notification.template.EmailNotificationTemplate;
import factory.notification.template.NotificationTemplate;

public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public NotificationType notificationType() {
        return NotificationType.EMAIL;
    }

    @Override
    public Notification createNotification(String recipient,String sender, NotificationTemplate template) {
        return new EmailNotification(recipient, sender,template);
    }

    @Override
    public NotificationSender createNotificationSender(Notification notification) {
        return new EmailNotificationSender(notification);
    }

    @Override
    public NotificationTemplate createNotificationTemplate(String message) {
        return new EmailNotificationTemplate(message);
    }
}
