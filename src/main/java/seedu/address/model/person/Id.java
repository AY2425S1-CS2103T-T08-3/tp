package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Id class that auto-increments and generates an automated unique Id number for Doctors and Patients separately.
 */
public class Id {
    public static final String DOCTOR = "DOCTOR";
    private static final String PATIENT = "PATIENT";
    private static int patientIdCounter = 0;
    private static int doctorIdCounter = 1;
    private final int idValue;

    /**
     * Creates appropriate ID for Person depending on their role.
     *
     * @param role Role of the Person: Either Doctor or Patient.
     */
    public Id(String role) {
        requireNonNull(role);
        role = role.toUpperCase();

        if (role.equals(DOCTOR)) {
            idValue = doctorIdCounter;
            doctorIdCounter += 2;
        } else if (role.equals(PATIENT)) {
            idValue = patientIdCounter;
            patientIdCounter += 2;
        } else {
            throw new IllegalArgumentException("Invalid class type. Expected Patient or Doctor.");
        }
    }

    public int getIdValue() {
        return idValue;
    }

    /**
     * Informs if the id is that of a Patient or for that of a Doctor.
     *
     * @return "DOCTOR" if for Doctor, "PATIENT" if for Patient.
     */
    public String getRole() {
        if (idValue < 0) {
            throw new RuntimeException("idValue is somehow less than 0.");
        }

        return (idValue % 2 == 1) ? "DOCTOR" : "PATIENT";
    }

    @Override
    public String toString() {
        return String.valueOf(idValue);
    }
}
