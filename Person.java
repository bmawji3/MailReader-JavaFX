/**
 * Represents a Person
 * @author Bilal Mawji
 * @version 1.0
 */
public class Person implements Comparable<Person> {

    private String name;
    private String email;
    /**
     * Instance method of Person
     * @param name name of person
     * @param email email of person
     */
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * @return name of person
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return email of person
     */
    public String getEmail() {
        return this.email;

    }

    /**
     * Overrides compareTo; compares two people by lowercase name
     * @param other Person being compared
     * @return difference between how differnet people are
     */
    @Override
    public int compareTo(Person other) {
        return this.name.toLowerCase()
            .compareTo(other.name.toLowerCase());
    }

    /**
     * Overrides equals; compares two people by name and email
     * @param other Object being compared
     * @return if people are same or not
     */
    @Override
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }

        if (this == other) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person that = (Person) other;
        return this.name.equals(that.name) && this.email.equals(that.email);
    }

    /**
     * Overrides hashCode
     * @return hashCode of Person
     */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode() + email.hashCode();
        return result;
    }

    /**
     * Overrides toString
     * @return toString representation of name
     */
    @Override
    public String toString() {
        return this.name;
    }
}
