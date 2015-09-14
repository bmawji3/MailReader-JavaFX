import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 * Represents a Message
 * @author Bilal Mawji
 * @version 1.0
 */
public class Message implements Comparable<Message> {

    private Person sender;
    private ArrayList<Person> recipients;
    private String subject;
    private LocalDateTime dt;
    private String body;

    /**
     * Constructor for Message
     * @param sender of the message
     * @param recipients of the message
     * @param subject of the message
     * @param dt of the message
     * @param body of the message
     */
    public Message(Person sender, ArrayList<Person> recipients, String subject,
        LocalDateTime dt, String body) {
        this.sender = sender;
        this.recipients = recipients;
        this.subject = subject;
        this.dt = dt;
        this.body = body;
    }

    /**
     * @return Sender who is a Person
     */
    public Person getSender() {
        return sender;
    }

    /**
     * @return Recipients of message in ArrayList of Person
     */
    public ArrayList<Person> getRecipients() {
        return recipients;
    }

    /**
     * @return Subject of message
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @return LocalDateTime of message
     */
    public LocalDateTime getLocalDateTime() {
        return dt;
    }

    /**
     * @return Body text of email message
     */
    public String getBody() {
        return body;
    }


    /**
     * Overrides compareTo; compares two Messages by Date
     * @param other Message being compared
     * @return difference between how differnet messages are
     */
    @Override
    public int compareTo(Message other) {
        return this.dt.compareTo(other.dt);
    }

    /**
     * Overrides equals; compares two message by every attribute
     * @param other Object being compared
     * @return if messages are same or not
     */
    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof Message)) {
            return false;
        }

        Message that = (Message) other;
        return this.dt.equals(that.dt)
            && this.sender.equals(that.sender)
            && this.subject.equals(that.subject)
            && this.body.equals(that.body)
            && this.recipients.equals(that.recipients);
    }

    /**
     * Overrides hashCode
     * @return hashCode of Message
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + sender.hashCode() + subject.hashCode()
            + body.hashCode() + recipients.hashCode() + dt.hashCode();
        return result;
    }

    /**
     * Overrides toString
     * @return toString of Message
     */
    @Override
    public String toString() {
        return sender + ":\n\t" + subject;
    }

}
