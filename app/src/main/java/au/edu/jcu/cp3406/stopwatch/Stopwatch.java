package au.edu.jcu.cp3406.stopwatch;

import java.util.Locale;

public class Stopwatch {
    private int hours;
    private int minutes;
    private int seconds;

    public Stopwatch() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public void tick() {
        seconds++;
        if (seconds > 59) {
            minutes++;
            seconds = 0;
        }

        if (minutes > 59) {
            hours++;
            minutes = 0;
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
    }
}
