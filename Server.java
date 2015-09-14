import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
/**
 * Represents a Server
 * @author Bilal Mawji
 * @version 1.0
 */
public class Server {

    private ArrayList<Person> senders = new ArrayList<Person>(5);
    private ArrayList<String> subjects = new ArrayList<String>(5);
    private ArrayList<String> bodies = new ArrayList<String>(5);
    private ArrayList<Person> persons = new ArrayList<Person>(5);

    /**
     * Constructor for Server
     */
    public Server() {
        senders.add(new Person("Rick Astley", "rolld@gmail.com"));
        senders.add(new Person("Backstreet Boys", "myonedesire@gmail.com"));
        senders.add(new Person("The Beach Boys", "iheartBeaches@gmail.com"));
        senders.add(new Person("Akon", "akon@gmail.com"));
        senders.add(new Person("Don Omar", "fastfive@gmail.com"));

        subjects.add("Never Gonna Give You Up");
        subjects.add("I Want It That Way");
        subjects.add("Kokomo");
        subjects.add("Don't Matter");
        subjects.add("Danza Kuduro");

        bodies.add("https://youtu.be/dQw4w9WgXcQ\nHa! Rick Roll'd 4");
        bodies.add("https://youtu.be/4fndeDfaWCg\nHa! Rick Roll'd 5");
        bodies.add("https://youtu.be/9ChADh1zt5I\nHa! Rick Roll'd 2");
        bodies.add("https://youtu.be/JWA5hJl4Dv0\nHa! Rick Roll'd 1");
        bodies.add("https://youtu.be/7zp1TbLFPp8\nHa! Rick Roll'd 3");

        persons.add(new Person("Jim", "halpert@dunder-mifflin.com"));
        persons.add(new Person("Pam", "beesely-halpert@dunder-mifflin.com"));
        persons.add(new Person("Dwight", "shrute@dunder-mifflin.com"));
        persons.add(new Person("Michael", "scott@dunder-mifflin.com"));
        persons.add(new Person("Stanley", "hudson@dunder-mifflin.com"));
    }

    /**
     * @return Random Message
     */
    public Message generateRandom() {
        Random r = new Random();
        int temp = r.nextInt(5);
        Person sender = senders.get(temp);
        String subject = subjects.get(temp);
        String body = bodies.get(temp);
        return new Message(sender, persons, subject, LocalDateTime.now(),
            body);
    }

}