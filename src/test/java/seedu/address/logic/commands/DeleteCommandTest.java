//package seedu.address.logic.commands;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
//import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
//import static seedu.address.logic.commands.CommandTestUtil.showPersonOfId;
//import static seedu.address.testutil.TypicalIndexes.ID_FIRST_PERSON;
//import static seedu.address.testutil.TypicalIndexes.ID_SECOND_PERSON;
//import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
//import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
//
//import org.junit.jupiter.api.Test;
//
//import javafx.collections.ObservableList;
//import seedu.address.model.Model;
//import seedu.address.model.ModelManager;
//import seedu.address.model.UserPrefs;
//import seedu.address.model.person.Person;
//
///**
// * Contains integration tests (interaction with the Model) and unit tests for
// * {@code DeleteCommand}.
// */
//public class DeleteCommandTest {
//
//    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
//
//    @Test
//    public void execute_validIdUnfilteredList_success() {
//        Person personToDelete = model.getFilteredPersonList().get(INDEX_FIRST_PERSON);
//        System.out.println(personToDelete.getId());
//        DeleteCommand deletePatientCommand = new DeleteCommand(ID_FIRST_PERSON);
//
//        String expectedMessage = DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS;
//
//        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
//        expectedModel.deletePerson(personToDelete);
//
//        assertCommandSuccess(deletePatientCommand, model, expectedMessage, expectedModel);
//    }
//
//    @Test
//    public void execute_invalidIdUnfilteredList_throwsCommandException() {
//        int outOfBoundId = model.getFilteredPersonList().get(model.getFilteredPersonList().size() - 1).getId() + 2;
//        DeleteCommand deletePatientCommand = new DeleteCommand(outOfBoundId);
//
//        assertCommandFailure(deletePatientCommand, model, DeleteCommand.MESSAGE_DELETE_PERSON_FAILURE);
//    }
//
//    @Test
//    public void execute_validIndexFilteredList_success() {
//        showPersonOfId(model, ID_FIRST_PERSON);
//        Person personToDelete = model.getFilteredPersonById(model.getFilteredPersonList(), ID_FIRST_PERSON);
//        DeleteCommand deletePatientCommand = new DeleteCommand(ID_FIRST_PERSON);
//
//        String expectedMessage = DeleteCommand.MESSAGE_DELETE_PERSON_SUCCESS;
//
//        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
//        expectedModel.deletePerson(personToDelete);
//        showNoPerson(expectedModel);
//
//        assertCommandSuccess(deletePatientCommand, model, expectedMessage, expectedModel);
//    }
//
//    @Test
//    public void execute_invalidIndexFilteredList_throwsCommandException() {
//        showPersonOfId(model, ID_FIRST_PERSON);
//        int outOfBoundId = ID_SECOND_PERSON;
//        // ensures that outOfBoundIndex is still in bounds of address book list
//        ObservableList<Person> bookList = model.getAddressBook().getPersonList();
//        assertTrue(outOfBoundId <= bookList.get(bookList.size() - 1).getId());
//
//        DeleteCommand deletePatientCommand = new DeleteCommand(outOfBoundId);
//
//        assertCommandFailure(deletePatientCommand, model, DeleteCommand.MESSAGE_DELETE_PERSON_FAILURE);
//    }
//
//    @Test
//    public void equals() {
//        DeleteCommand deleteFirstCommand = new DeleteCommand(ID_FIRST_PERSON);
//        DeleteCommand deleteSecondCommand = new DeleteCommand(ID_SECOND_PERSON);
//
//        // same object -> returns true
//        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));
//
//        // same values -> returns true
//        DeleteCommand deleteFirstCommandCopy = new DeleteCommand(ID_FIRST_PERSON);
//        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));
//
//        // different types -> returns false
//        assertFalse(deleteFirstCommand.equals(1));
//
//        // null -> returns false
//        assertFalse(deleteFirstCommand.equals(null));
//
//        // different person -> returns false
//        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
//    }
//
//    @Test
//    public void toStringMethod() {
//        int targetId = 1;
//        DeleteCommand deletePatientCommand = new DeleteCommand(targetId);
//        String expected = DeleteCommand.class.getCanonicalName() + "{person Id=" + targetId + "}";
//        assertEquals(expected, deletePatientCommand.toString());
//    }
//
//    /**
//     * Updates {@code model}'s filtered list to show no one.
//     */
//    private void showNoPerson(Model model) {
//        model.updateFilteredPersonList(p -> false);
//
//        assertTrue(model.getFilteredPersonList().isEmpty());
//    }
//}
