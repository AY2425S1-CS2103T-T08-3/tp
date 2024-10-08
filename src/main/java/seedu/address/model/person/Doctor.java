package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.TreeMap;

import seedu.address.model.tag.Tag;

/**
 * Encapsulates the code required to represent a target user of the application.
 */
public class Doctor extends Person {
    /**
     * Placeholder Appointment class while waiting for
     * Appointment implementation PR.
     */
    public class History {
        private TreeMap<LocalDateTime, Pair<Id, String>> db;
        private final Id id;

        public History(Id id) {
            this.id = id;
        }

        /**
         * Adds an "Appointment" into the Doctor's schedule.
         *
         * @param time Time of appointment.
         * @param description Any relevant details related to the appointment.
         */
        public void add(LocalDateTime time, Pair<Id, String> description) {
            // TODO: relevant extra code like conditional checks, dupe checking
            db.put(time, description);
            // TODO: need to do something with doctor schedule also
        }

        /**
         * Updates the details oif a certain appointment.
         *
         * @param time Time of appointment
         * @param description
         */
        public void update(LocalDateTime time, Pair<Id, String> description) {
            // TODO, separate functionality by Patient or Doctor (probably need extra param)
        }

        /**
         * Returns all the appointments of a specified Doctor or Patient.
         *
         * @param id Id of Patient or Doctor to retrieve schedule of.
         * @return String representing all appointments.
         */
        public String getAll(Id id) {
            // TODO, separate functionality by Patient or Doctor
            return "";
        }

        /**
         * Gets appointment that falls on a certain date.
         *
         * @param dateTime Date to filter appointments for.
         */
        public void get(LocalDateTime dateTime) {
        }
    }

    private History history;
    private Id id;
    /**
     * Every field must be present and not null.
     *
     * @param name
     * @param phone
     * @param email
     * @param address
     * @param remark
     * @param tags
     */
    public Doctor(Name name, Phone phone, Email email, Address address, Remark remark, Set<Tag> tags) {
        super(name, phone, email, address, remark, tags);
        id = new Id(this.getClass());
        history = new Doctor.History(id);
    }

    /**
     * Adds an entry to the doctor's schedule.
     *
     * @param dateTime Date and time of the appointment or event. TODO.
     */
    public void addAppointment(LocalDateTime dateTime, Pair<Id, String> description) {
        requireNonNull(dateTime);
        requireNonNull(description);
        history.add(dateTime, description);
    }

    /**
     * Updates the details of a specified appointment.
     *
     * @param time Time of appointment.
     * @param description Updated description to be used.
     */
    public void updateAppointment(LocalDateTime time, Pair<Id, String> description) {
        requireNonNull(time);
        requireNonNull(description);
        history.update(time, description);
    }

    /**
     * Retrieves the full schedule of the doctor.
     *
     * @return A representing the TreeMap containing the doctor's schedule, TODO.
     */
    public String getAllAppointments(Id id) {
        return history.getAll(id);
    }
    /**
     * Retrieves a specific schedule entry based on the date and time. TODO.
     *
     * @param dateTime The date and time of the desired schedule entry.
     */
    public void getScheduleEntry(LocalDateTime dateTime) {
        // return history.get(dateTime);
    }
}
