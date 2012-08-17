package org.nbempire.java.callsmanager.dao.impl;

import java.util.Calendar;

import org.nbempire.java.boc6.model.io.file.javase.impl.FileHandlerImpl;
import org.nbempire.java.callsmanager.dao.CallDao;
import org.nbempire.java.callsmanager.domain.Call;

/**
 * @author Barrios, Nahuel.
 * @version 1.0
 */
public class CallDaoImpl implements CallDao {

    //@Override
    public boolean exportToFile(Call aCall) {
        String outputDirectory;
        if (aCall.getOutputDirectory() != null) {
            outputDirectory = aCall.getOutputDirectory();
        } else {
            return false;
        }

        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(aCall.getDate());

        String date = String.valueOf(aCalendar.get(Calendar.YEAR)) + String.valueOf(aCalendar.get(Calendar.MONTH) + 1) + String.valueOf
                                                                                                                                        (aCalendar.get
                                                                                                                                                           (Calendar.DAY_OF_MONTH));
        String time = String.valueOf(aCalendar.get(Calendar.HOUR_OF_DAY)) + String.valueOf(aCalendar.get(Calendar.MINUTE)) + String.valueOf
                                                                                                                                            (aCalendar.get(Calendar.SECOND));
        aCall.setPathToExport(outputDirectory + System.getProperty("file.separator") + date + "-" + time + " - " + aCall.getContact()
                                                                                                                           .getFullName() + ".txt");

        return new FileHandlerImpl().export(aCall);
    }
}
