---
layout: page
title: User Guide
---

MedDict is a **desktop application designed for physiotherapists** who manage a large number of patients. It simplifies data entry and retrieval, allowing quick access to contact details, patient conditions, and the progress of recurring or long-term patients. The application supports a streamlined process for tracking medical history, patient appointments, and treatment progress.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `17` or above installed in your Computer.

1. Download the latest `.jar` file from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your MedDict.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar addressbook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `list` : Lists all contacts.

   * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * `delete 3` : Deletes the 3rd contact shown in the current list.

   * `clear` : Deletes all contacts.

   * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines as space characters surrounding line-breaks may be omitted when copied over to the application.
</div>


### Viewing Help : `help`

Displays a message with instructions on accessing the help page.

Format: `help`

Examples:
* `help` <br>
  **Output**: <br>
![help message](images/helpMessage.png)

### Creating and Adding a Doctor : `createD`

Create a doctor with given details and add the doctor to the MedDict database in the address book.

Format: `createD [n/Name] [p/Phone] [e/Email] [a/Address] `

* **Names**: Only alphanumeric characters and spaces; cannot be blank.
* **Phone numbers:** Numeric only; minimum of 3 digits.
* **Emails**: Must follow standard email format 'local-part@domain.com', where the local part contains only alphanumeric characters and certain special characters,
  but cannot start or end with these special characters (+_.-). The domain consists of labels separated by periods,
  ending with a label at least two characters long, with each label starting and ending with an alphanumeric character and allowing hyphens in between.
* **Doctors**: Duplicate doctors (same name, phone, or email) are not allowed.
* A _notification message_ will be output if there is failure in creating doctor.

Examples:
* `createD n/Dr Jane p/87654321 e/dr.jane.smith@hospital.com a/456 Elm Street r/physiotherapy` <br>
  **Output**: <br>
    Successfully created a new doctor Doctor#01 : Dr Jane Smith; Phone: 87654321; Email: dr.jane.smith@hospital.com; Address: 456 Elm Street; Tags: Specialist in physiotherapy

* `createD n/Dr Jane p/87654321 e/dr.jane.smith@hospital.com a/456 Elm Street r/physiotherapy` <br>
  **Output**: <br>
  This doctor already exists


### Creating and Adding a Patient : `createP`

Create a patient with given details and add the patient to the MedDict database in the address book.

Format: `createP [n/Name] [p/Phone] [e/Email] [a/Address] `

* **Names**: Only alphanumeric characters and spaces; cannot be blank.
* **Phone numbers:** Numeric only; minimum of 3 digits.
* **Emails**: Must follow standard email format 'local-part@domain.com', where the local part contains only alphanumeric characters and certain special characters,
  but cannot start or end with these special characters (+_.-). The domain consists of labels separated by periods,
  ending with a label at least two characters long, with each label starting and ending with an alphanumeric character and allowing hyphens in between.
* **Patients**: Duplicate patients (same name, phone, or email) are not allowed.
* A _notification message_ will be output if there is failure in creating patient.


Examples:
* `createP n/Dr Jane p/87654321 e/dr.jane.smith@hospital.com a/456 Elm Street r/physiotherapy` <br>
  **Output**: <br> 
    Successfully created a new patient Patient#00 : John Doe; Phone: 98765432; Email: johndoe@example.com; Address: 123 Baker Street; Tags: No known allergies

* `createP n/Dr Jane p/87654321 e/dr.jane.smith@hospital.com a/456 Elm Street r/physiotherapy` <br>
  **Output**: <br>
This patient already exists

### Deleting a Patient : `deleteP`

Deletes the patient with the specified `PatientId` from the MedDict database in the address book.

Format: `deleteP [z/PatientId]`

* **Patient Id**: Must be valid, present in the MedDict database, and an _even integer_ (0, 2, 4, …​).
* A _notification message_ will be output if there is failure in deleting patient.

Examples:
* `deleteP 00` <br>
  **Output**: <br>
  Successfully deleted a patient.
* `deleteP 02` <br>
  **Output**: <br>
  Unable to delete a patient, check the id entered!

### Add Remarks to a Patient : `addNotes`

Add remarks to an existing patient with the specified `PatientId` in the MedDict database in address book.

Format: `addNotes [z/PatientId] [r/Remarks]`

* **Patient Id**: Must be valid, present in the MedDict database, and an _even integer_ (0, 2, 4, …​).
* A _notification message_ will be output if there is failure in adding notes to the patient.

Examples:
*  `addR z/0 r/cancer` <br>
    **Output**: <br>
   Successfully added remarks: cancer to patient of ID: 00.
*  `addR z/0 r/cancer` <br>
   **Output**: <br>
   Unable to add remarks! Check the id entered!

### Listing All Persons : `list`

Displays a list of all persons in the address book.

Format: `list`

Examples:
*   `list` <br>
    **Output**: <br>
    ![list](images/list.png)

### Editing a Person : `edit`

Edits an existing person with the specified `Id` in the address book.

Format: `edit Id [n/Name] [p/Phone] [e/Email] [a/Address] [t/tag]…​`

* **Patient Id**: Must be valid, present in the MedDict database, and an _even integer_ (0, 2, 4, …​).
* **Doctor Id**: Must be valid, present in the MedDict database, and an _odd integer_ (1, 3, 5, …​).
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the person will be removed i.e adding of tags is not cumulative.
* You can remove all the person’s tags by typing `t/` without specifying any tags after it.
* Editing the person with the detail same as the existing detail is not allowed.
* A _notification message_ will be output if there is failure in editing person in MedDict database in address book.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` <br>
   **Output**: <br>
   Edited Person: John Doe; Phone: 98765432; Email: johndoe@example.com; Address: 123 Baker Street; Tags: No known allergies
*  `edit 2 n/Betsy Crower` <br>
   **Output**: <br>
   At least one field to edit must be provided.
* `edit 1 p/91234567 e/johndoe@example.com` <br>
  **Output**: <br>
  This person already exists in the address book.

### Getting Id of Doctor or Patient by Name: `getId`

Get id of a doctor or patient whose names contain any of the given keywords.

Format: `get [Keyword]`

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Persons matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`
* A _notification message_ will be output if there is failure in retrieving id from MedDict database in address book.

Examples:
* `get john` <br>
  **Output**: <br>
  The id of the person that you are finding is: 00
* `get johnny` <br>
  **Output**: <br>
  Invalid name entered! Check the name that you want to search id for! Key in 'list' to view all patients


### Adding an Appointment : `addA`

Add appointment to an existing patient with the specified `PatientId` and doctor with the specified `DoctorId` in the MedDict database in address book.

Format: `addA [x/DateTime] [z/PatientId] [z/DoctorId] …​`

* **Patient Id**: Must be valid, present in the MedDict database, and an _even integer_ (0, 2, 4, …​).
* **Doctor Id**: Must be valid, present in the MedDict database, and an _odd integer_ (1, 3, 5, …​).
* **Remark**: Optional, user can add remark details by adding `[r/Remark]` when calling the command.
  Empty remark will be added to the appointment if remark is not specified.
* When adding appointment, the appointment detail will be added to the appointments list in both patient and doctor class.
* Each appointment must be scheduled at a unique time to prevent overlap for both the patient and the doctor.
* A _notification message_ will be output if there is failure in adding the appointments.

Examples:
*  `addA x/2024-12-31 15:23 z/0 z/1 r/Third physiotherapy session` <br>
   **Output**: <br>
   Successfully added appointment to a patient.
*  `addA x/2024-12-31 15:23 z/0 z/1` <br>
   **Output**: <br>
   Successfully added appointment to a patient.
*  `addA x/2024-12-31 15:23 z/0 z/1` <br>
   **Output**: <br>
   The patient already has another appointment!
*  `addA x/2024-12-31 15:23 z/0 z/1` <br>
   **Output**: <br>
   The doctor already has another appointment!

### View History of a Patient : `view`

View history of an existing patient with the specified `PatientId` in the MedDict database in address book.

Format: `view [z/PatientId]  …​`

* **Patient Id**: Must be valid, present in the MedDict database, and an _even integer_ (0, 2, 4, …​).
* **DateTime**: Optional, user can view history of the patient on a specific date by adding `[x/DateTime]` when calling the command.
* A _notification message_ will be output if there are no histories found for the doctor.

Examples:
*  `view z/0 x/2024-12-31 15:23` <br>
   **Output**: <br>
   Appointment: `2024-12-31 15:23` for `00` (patient id) with `01` (doctor id). Remarks: `Third physiotherapy session`.
*  `view z/0` <br>
   **Output**: <br>
   Appointment: `2024-12-31 15:23` for `00` (patient id) with `01` (doctor id). Remarks: `Third physiotherapy session`. <br>
   Appointment: `2024-12-31 16:23` for `00` (patient id) with `01` (doctor id). Remarks: `Fourth physiotherapy session`.
*  `view z/1 x/2024-12-31` <br>
   **Output**: <br>
   No history found for Patient.

### Check Appointment of a Doctor : `checkA`

Check appointment of an existing doctor with the specified `DoctorId` in the MedDict database in address book.

Format: `checkA [z/DoctorId] [y/Date]`

* **Doctor Id**: Must be valid, present in the MedDict database, and an _odd integer_ (1, 3, 5, …​).
* A _notification message_ will be output if there are no appointments found for the doctor.

Examples:
*  `checkA z/1 x/2024-12-31` <br>
   **Output**: <br>
   Appointment: `2024-12-31 15:23` for `00` (patient id) with `01` (doctor id). Remarks: `Third physiotherapy session`. <br>
   Appointment: `2024-12-31 16:23` for `00` (patient id) with `01` (doctor id). Remarks: `Fourth physiotherapy session`.
*  `checkA z/1 x/2024-12-31` <br>
   **Output**: <br>
   No appointment found for Doctor: `Amy Bee`

### Mark Appointment of a Doctor : `mark`

Mark appointment of an existing doctor with the specified `DoctorId` in the MedDict database in address book.

Format: `mark [z/DateTime] [z/PatientId] [z/DoctorId] `

* **Doctor Id**: Must be valid, present in the MedDict database, and an _odd integer_ (1, 3, 5, …​).
* A _notification message_ will be output if there is failure in marking appointments.

Examples:
*  `mark x/2024-12-31 15.23 z/00 z/01` <br>
   **Output**: <br>
   Successfully marked appointment as complete
*  `mark x/2024-12-31 16.23 z/02 z/03` <br>
   **Output**: <br>
   The appointment doesn't exist!

### Delete Appointment of a Doctor : `deleteA`

Delete appointment of a existing patient for both patient and doctor with the specified `PatientId` and `DoctorId` in the MedDict database in address book.

Format: `deleteA [z/DateTime] [z/PatientId] [z/DoctorId] `

* **Patient Id**: Must be valid, present in the MedDict database, and an _even integer_ (0, 2, 4, …​).
* **Doctor Id**: Must be valid, present in the MedDict database, and an _odd integer_ (1, 3, 5, …​).
* A _notification message_ will be output if there is failure in deleting appointment.

Examples:
*  `deleteA x/2024-12-31 15.23 z/00 z/01` <br>
   **Output**: <br>
   Successfully deleted appointment to a patient
*  `deleteA x/2024-12-31 15.23 z/01 z/03` <br>
   **Output**: <br>
   The appointment doesn't exist!

### Clearing All Entries : `clear`

Clears all entries from the address book.

Format: `clear`

Examples:
* `clear` <br>
  **Output**: <br>
  ![clear message](images/clearMessage.png)

### Exiting the Program : `exit`

Exits the program.

Format: `exit`

### Saving the Data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the Data File

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, AddressBook will discard all data and start with an empty data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the AddressBook to behave in unexpected ways (e.g., if a value entered is outside of the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</div>

### Archiving Data Files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to manually restore the minimized Help Window.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Help** | `help` <br> Shows help page
**Create Doctor** | `createD [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS]` <br> e.g., `createDoctor n/Dr Jane p/87654321 e/dr.jane.smith@hospital.com a/456 Elm Street r/physiotherapy`
**Create Patient** | `createP [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS]` <br> e.g., `createPatient n/John Doe p/98765432 e/johndoe@example.com a/123 Baker Street`
**Delete Patient** | `deleteP [z/PatientId]` <br> e.g., `deletePatient 00`
**Add Notes** | `addR [z/PatientId] [r/Notes]` <br> e.g., `addNotes z/0 r/cancer`
**List** | `list` <br> Shows all persons in address book
**Edit** | `edit Id [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​` <br> e.g., `edit 1 p/91234567 e/johndoe@example.com`
**Get ID** | `get [Keyword]` <br> e.g., `getId john`
**Add Appointment** | `addAppointment [x/DateTime] [z/PatientId] [z/DoctorId] [r/Remark]` <br> e.g., `addAppointment x/2024-12-31 15:23 z/0 z/1 r/Third physiotherapy session`
**View History** | `view [z/PatientId] [x/DateTime]` <br> e.g., `viewhistory z/0 x/2024-12-31 15:23`
**Check Appointment** | `checkA [z/DoctorId] [y/Date]` <br> e.g., `checkAppointment z/1 x/2024-12-31`
**Mark Appointment** | `mark [z/DateTime] [z/PatientId] [z/DoctorId]` <br> e.g., `markAppointment x/2024-12-31 15.23 z/00 z/01`
**Delete Appointment** | `deleteA [z/DateTime] [z/PatientId] [z/DoctorId]` <br> e.g., `deleteAppointment x/2024-12-31 15.23 z/00 z/01`
**Clear** | `clear` <br> Clears all entries
**Exit** | `exit` <br> Exits the program
