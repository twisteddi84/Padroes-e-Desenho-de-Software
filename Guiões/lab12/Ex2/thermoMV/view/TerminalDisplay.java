package thermoMV.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import thermoMV.model.*;

public class TerminalDisplay implements ThermometerListener{
    // The thermometer whose temperature is being displayed
    protected Thermometer thermometer;

    /**
     * Creates a digital thermometer
     * @param t the thermometer whose temperature is displayed
     */
    public TerminalDisplay(Thermometer t) {
        thermometer = t;
    }

    /**
     * Create the string to display in the thermometer
     * @return the string to display in the thermometer
     */
    private String getDisplayString() {
        return thermometer.getTemperature() + "\u00B0F";
    }

    /**
     * Change the temperature displayed
     */
    @Override
    public void temperatureChanged() {
        System.out.println(getDisplayString());
    }
}
