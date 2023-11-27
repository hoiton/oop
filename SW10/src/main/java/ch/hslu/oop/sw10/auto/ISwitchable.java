package ch.hslu.oop.sw10.auto;

public interface ISwitchable {
    /**
     * Switches the Current Object on
     */
    void switchOn();

    /**
     * Switches the current Object off
     */
    void switchOff();

    /**
     * Gets if the current Object is turned ON
     * @return TRUE if the current Object is switched ON
     */
    boolean isSwitchedOn();

    /**
     * Gets if the current Object is turned OFF
     * @return TRUE if the current Object is switched OFF
     */
    boolean isSwitchedOff();
}