package be.kdg.messenproject.model;

/**
 * Vincent Verboven
 * 18/09/2023
 */
public enum Lemmet {
    ONBEKEND, NORMAAL, SCHAAPSVOET, DROPPOINT, KLIP;

    @Override
    public String toString() {
        return String.format("%s", super.toString().charAt(0) + super.toString().substring(1).toLowerCase());
    }
}
