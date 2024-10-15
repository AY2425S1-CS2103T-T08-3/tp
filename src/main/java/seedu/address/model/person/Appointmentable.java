package seedu.address.model.person;

import java.time.LocalDateTime;

/**
 * Implemented by classes who have appointment-related functionality.
 */
public interface Appointmentable {

    /**
     * Adds a new appointment at the specified time, for the respective patient and doctor.
     *
     * @param dateTime Time of appointment.
     * @param patientId Id of patient in the appointment.
     * @param doctorId Id of doctor in the appointment.
     * @return True if command was successful, false if otherwise.
     */
    public abstract boolean addAppointment(LocalDateTime dateTime, Id patientId, Id doctorId, String remarks);

    /**
     * Edit an appointment at the specified time, with the respective patient and doctor.
     *
     * @param dateTime Time of appointment.
     * @param patientId Id of patient in the appointment.
     * @param doctorId Id of doctor in the appointment.
     * @return True if command was successful, false if otherwise.
     */
    public abstract boolean editAppointment(LocalDateTime dateTime, Id patientId, Id doctorId);

    /**
     * Delete an appointment at the specified time, with the respective patient and doctor.
     *
     * @param dateTime Time of appointment.
     * @param patientId Id of patient in the appointment.
     * @param doctorId Id of doctor in the appointment.
     * @return True if command was successful, false if otherwise.
     */
    public abstract boolean deleteAppointment(LocalDateTime dateTime, Id patientId, Id doctorId);

    /**
     * Gets an appointment at the specified time, with the respective patient and doctor.
     *
     * @param dateTime Time of appointment.
     * @param patientId Id of patient in the appointment.
     * @param doctorId Id of doctor in the appointment.
     * @return True if command was successful, false if otherwise.
     */
    public abstract Appointment getAppointment(LocalDateTime dateTime, Id patientId, Id doctorId);

    /**
     * Returns all appointments for the specified person.
     *
     * @return String representing all the appointments of the person, may not be a String.
     */
    public abstract String getAllAppointments();
}
