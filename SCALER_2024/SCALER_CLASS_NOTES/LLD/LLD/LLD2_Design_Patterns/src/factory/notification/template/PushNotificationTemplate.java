package factory.notification.template;

import factory.notification.NotificationType;

public class PushNotificationTemplate extends NotificationTemplate {
    public PushNotificationTemplate(String message) {
        super(message);
    }

    @Override
    public String applyTemplate() {
        System.out.println("Applying Push notification template");
        return getMessage();
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}
