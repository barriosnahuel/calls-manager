/**
 * Created by: Nahuel Barrios.
 * On: 17/08/12 at 11:55hs.
 */
package org.nbempire.java.callsmanager.dao;

import org.nbempire.java.callsmanager.domain.Call;

/**
 * @author Nahuel Barrios.
 */
public interface CallDao {

    /**
     * @param aCall
     *         The Call to export.
     *
     * @return boolean indicating with <code>true</code> when the export completed succesfully. Otherwise <code>false</code>.
     */
    public boolean exportToFile(Call aCall);
}
