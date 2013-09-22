package org.nbempire.java.callsmanager;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.nbempire.java.callsmanager.windows.NewCallWindow;

/**
 * User: Nahuel Barrios. Date: Mar 5, 2010. Time: 11:00:40 AM.
 */
public class CallsManagerApp {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Display display = new Display();

        NewCallWindow mainWindow = new NewCallWindow(display);
        Shell shell = mainWindow.getShell();

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();
    }
}
