package org.nbempire.java.callsmanager.util;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Widget;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Barrios, Nahuel.
 * @version 1.0
 * @since Mar 19, 2010, 12:34:42 PM
 */
public class CallManagerUtil {

    /**
     * Adds each value of the list parameter to the combo parameter. Please note that the method will throw a NullPointerException when either the
     * combo or the list are null.
     *
     * @param combo
     *         An instantiated Combo.
     * @param list
     *         The values to add to the combo parameter.
     */
    public static void insertComboValues(Combo combo, List list) {
        try {
            for (Object aList : list) {
                combo.add((String) aList);
            }
        } catch (Exception e) {
            System.err.println("There was an error trying to add a value to a combo at:\nFichaverUtil.insertComboValues()");
        }
    }

    /**
     * @param aWidget
     *         A {@link Widget}.
     *
     * @return <code>true</code> when the specified aWidget parameter was build bofore calling this method, otherwise <code>false</code>.
     */
    public static boolean isBuild(Widget aWidget) {
        return aWidget != null && !aWidget.isDisposed();
    }

    /**
     * Adds the element parameter only if it isn't inside yet.
     *
     * @param aList
     *         The {@link List} to fill.
     * @param element
     *         The element to add to the aList parameter.
     */
    public static void addWhenNecessary(List aList, Object element) {
        if (aList == null) {
            aList = new ArrayList();
            aList.add(element);
            return;
        }

        if (!aList.contains(element)) {
            aList.add(element);
        }
    }

    /**
     * @param date
     *
     * @return
     */
    public static String getFormatedDate(Date date) {
        return date.getYear() + "-" + date.getMonth() + "-" + date.getDay() + " - At " + date.getHours() + ":" + date.getMinutes();
    }
}
