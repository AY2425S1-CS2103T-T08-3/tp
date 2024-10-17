package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.time.LocalDateTime;

import javafx.collections.ObservableList;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Doctor;
import seedu.address.model.person.Id;
import seedu.address.model.person.Patient;
import seedu.address.model.person.Person;

/**
 * Adds an appointment to both a patient and a doctor.
 */

public class AddAppointmentCommand extends Command {

    public static final String COMMAND_WORD = "addAppointment";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an appointment with "
            + "the relevant doctor and patient. "
            + COMMAND_WORD + " "
            + PREFIX_DATE + "[APPOINTMENT_TIME] "
            + PREFIX_ID + "[PATIENT_ID] "
            + PREFIX_ID + "[DOCTOR_ID] "
            + PREFIX_REMARK + "[ADDITIONAL REMARK]\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DATE + "2024-12-31 15:23"
            + PREFIX_ID + "1234 "
            + PREFIX_ID + "5678"
            + PREFIX_REMARK + "third physiotherapy session";

    public static final String MESSAGE_ADD_APPOINTMENT_SUCCESS = "Successfully added appointment to a patient";
    public static final String MESSAGE_PATIENT_BUSY = "The patient already has another appointment!";
    public static final String MESSAGE_DOCTOR_BUSY = "The doctor already has another appointment!";
    public static final String MESSAGE_DUPLICATE_APPOINTMENT = "The appointment already exists!";
    private final Id patientId;
    private final Id doctorId;
    private final LocalDateTime appointmentTime;
    private final String remarks;

    /**
     * Creates an AddAppointmentCommand to add the specified patient and doctor ids
     */
    public AddAppointmentCommand(LocalDateTime appointmentTime, Id patientId, Id doctorId, String remarks) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentTime = appointmentTime;
        this.remarks = remarks;
    }
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        ObservableList<Person> allPersons = model.getFilteredPersonList();
        Patient patientToAddAppointment = model.getFilteredPatientById(allPersons, patientId);
        Doctor doctorToAddAppointment = model.getFilteredDoctorById(allPersons, doctorId);
        boolean isPatientFree = patientToAddAppointment.addAppointment(appointmentTime, patientToAddAppointment.getId(),
                doctorToAddAppointment.getId(), remarks);
        boolean isDoctorFree = doctorToAddAppointment.addAppointment(appointmentTime, patientToAddAppointment.getId(),
                doctorToAddAppointment.getId(), remarks);
        if (!isPatientFree && !isDoctorFree) {
            throw new CommandException(MESSAGE_DUPLICATE_APPOINTMENT);
        } else if (!isPatientFree) {
            throw new CommandException(MESSAGE_PATIENT_BUSY);
        } else if (!isDoctorFree) {
            throw new CommandException(MESSAGE_DOCTOR_BUSY);
        }
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(MESSAGE_ADD_APPOINTMENT_SUCCESS);
    }
}
