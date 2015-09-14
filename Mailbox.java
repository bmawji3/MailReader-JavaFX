import java.util.TreeSet;
/**
 * Represents a Mailbox
 * @author Bilal Mawji
 * @version 1.0
 */
public class Mailbox {

    private String name;
    private TreeSet<Message> messages;

    /**
     * Constructor for Mailbox
     * @param name of Mailbox
     */
    public Mailbox(String name) {
        this.name = name;
        messages = new TreeSet<Message>();
    }

    /**
     * @return Name of Mailbox
     */
    public String getName() {
        return name;
    }

    /**
     * @return set of Messages
     */
    public TreeSet<Message> getMessages() {
        return messages;
    }

    /**
     * @return toString of name of Mailbox
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * @param m Message to be added
     */
    public void add(Message m) {
        messages.add(m);
    }

    /**
     * @param m Message to be removed
     */
    public void remove(Message m) {
        messages.remove(m);
    }

}