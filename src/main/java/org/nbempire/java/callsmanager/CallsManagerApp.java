package org.nbempire.java.callsmanager;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.nbempire.java.callsmanager.service.CallService;
import org.nbempire.java.callsmanager.windows.NewCallWindow;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * User: Nahuel Barrios. Date: Mar 5, 2010. Time: 11:00:40 AM.
 */
public class CallsManagerApp {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Display display = new Display();

        AbstractApplicationContext context = new GenericXmlApplicationContext("/applicationContext.xml");

        NewCallWindow mainWindow = new NewCallWindow(display, context.getBean(CallService.class));
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
