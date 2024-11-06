package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ID;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Deletes a person identified using it's displayed index from the address book.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": deletes a person (patient/doctor). "
            + "based on id provided "
            + COMMAND_WORD + " "
            + PREFIX_ID + "[PATIENT_ID]"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_ID + "1234";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Successfully "
            + "deleted a person";
    public static final String MESSAGE_DELETE_PERSON_FAILURE = "Unable to "
            + "delete a person, check the id entered!";
    private final int personId;

    public DeleteCommand(int personId) {
        this.personId = personId;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        ObservableList<Person> allPersons = model.getFilteredPersonList();

        Person patientToDelete = model.getFilteredPatientById(allPersons, personId);
        if (patientToDelete == null) {
            throw new CommandException(MESSAGE_DELETE_PERSON_FAILURE);
        }
        model.deletePerson(patientToDelete);

        return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, Messages.format(patientToDelete)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteCommand)) {
            return false;
        }

        DeleteCommand otherDeleteCommand = (DeleteCommand) other;
        return personId == otherDeleteCommand.personId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("person Id", personId)
                .toString();
    }
}

