package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.Remark;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {

    public static final Remark EMPTY_REMARK = new Remark("");
    private static Person person1 = new Person(
            new Name("Alex Yeoh"),
            "patient",
            new Phone("87438807"),
            new Email("alexyeoh@example.com"),
            new Address("Blk 30 Geylang Street 29, #06-40"),
            EMPTY_REMARK,
            getTagSet("friends")
    );

    private static Person person2 = new Person(
            new Name("Bernice Yu"),
            "patient",
            new Phone("99272758"),
            new Email("berniceyu@example.com"),
            new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
            EMPTY_REMARK,
            getTagSet("colleagues", "friends")
    );

    private static Person person3 = new Person(
            new Name("Charlotte Oliveiro"),
            "patient",
            new Phone("93210283"),
            new Email("charlotte@example.com"),
            new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
            EMPTY_REMARK,
            getTagSet("neighbours")
    );

    private static Person person4 = new Person(
            new Name("David Li"),
            "patient",
            new Phone("91031282"),
            new Email("lidavid@example.com"),
            new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
            EMPTY_REMARK,
            getTagSet("family")
    );

    private static Person person5 = new Person(
            new Name("Irfan Ibrahim"),
            "patient",
            new Phone("92492021"),
            new Email("irfan@example.com"),
            new Address("Blk 47 Tampines Street 20, #17-35"),
            EMPTY_REMARK,
            getTagSet("classmates")
    );

    private static Person person6 = new Person(
            new Name("Roy Balakrishnan"),
            "patient",
            new Phone("92624417"),
            new Email("royb@example.com"),
            new Address("Blk 45 Aljunied Street 85, #11-31"),
            EMPTY_REMARK,
            getTagSet("colleagues")
    );



    public static Person[] getSamplePersons() {
        Person[] persons = new Person[] {person1, person2, person3, person4, person5, person6};
        return persons;
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
