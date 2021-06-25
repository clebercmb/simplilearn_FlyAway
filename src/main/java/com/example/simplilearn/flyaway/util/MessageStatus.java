package com.example.simplilearn.flyaway.util;

public enum MessageStatus {

    EMAIL_ALREADY_USED (401, Series.CLIENT_ERROR  ,  "Email already used"),
    PASSWORD_DOES_NOT_MATCH (402, Series.CLIENT_ERROR  ,  "Password does not match"),
    PASSWORD_MUST_BE_TYPED (403, Series.CLIENT_ERROR  ,  "Password must be typed"),
    RESOURCE_NOT_FOUND (100, Series.INFORMATIONAL  ,  "Resource not Found"),
    SUCCESS_CREATED (200, Series.SUCCESSFUL  ,  "Added Resource successfully"),
    SUCCESS_READ (201, Series.SUCCESSFUL  ,  "Resource Found"),
    SUCCESS_UPDATED (202, Series.SUCCESSFUL  ,  "Resource Updated successfully"),
    SUCCESS_DELETED (203, Series.SUCCESSFUL  ,  "resource Deleted successfully");


    private final int value;
    private final MessageStatus.Series series;
    private  final String reasonPhrase;


    private MessageStatus(int value, MessageStatus.Series series, String reasonPhrase) {
        this.value = value;
        this.series = series;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }

    public MessageStatus.Series series() {
        return this.series;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public static enum Series {
        INFORMATIONAL (1),
        SUCCESSFUL (2),
        REDIRECTION (3),
        CLIENT_ERROR(4),
        SERVER_ERROR(5);

        private final int value;

        private Series(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
}
