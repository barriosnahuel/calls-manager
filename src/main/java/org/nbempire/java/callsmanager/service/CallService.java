/**
 * Created by: Nahuel Barrios.
 * On: 17/08/12 at 11:53hs.
 */
package org.nbempire.java.callsmanager.service;

import org.nbempire.java.callsmanager.domain.Call;

/**
 * @author Nahuel Barrios.
 */
public interface CallService {

    /**
     * Exports the aCall parameter to a text file.
     *
     * @param aCall
     *         The Call to export.
     *
     * @return If the export action returns O.K. then true, otherwise false.
     */
    public boolean exportToFile(Call aCall);
}
