package com.edsgerlin.sparkle;

/**
 * Created by edsge on 4/11/2016.
 */
public class SparkleMessage {
    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    private final String sender;
    private final String message;
    @Override
    public int hashCode() {
        return sender.hashCode() ^ message.hashCode();
    }
    public SparkleMessage(final String sender, final String message) {
        this.sender = sender;
        this.message = message;
    }
    @Override
    public String toString() {
        return String.format("%s: %s", this.sender, this.message);
    }

}
