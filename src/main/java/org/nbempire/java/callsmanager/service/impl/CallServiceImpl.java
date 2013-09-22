package org.nbempire.java.callsmanager.service.impl;

import org.nbempire.java.callsmanager.dao.CallDao;
import org.nbempire.java.callsmanager.dao.impl.CallDaoImpl;
import org.nbempire.java.callsmanager.domain.Call;
import org.nbempire.java.callsmanager.service.CallService;

/**
 * Created by: Nahuel Barrios. On: 19/03/2010 at 13:40hs.
 *
 * @author Barrios, Nahuel.
 * @version 1.0
 */
public class CallServiceImpl implements CallService {

    private static CallServiceImpl instance;

    private CallDao dao;

    /**
     * Creates a new CallServiceImpl object.
     */
    public CallServiceImpl() {
        this.dao = new CallDaoImpl();
    }

    /**
     * If there is not a created instance of any CallServiceImpl object, this method instantiate an instance and return it. Else just return that
     * instantiated instance.
     *
     * @return A DeviceManager.
     */
    public static CallServiceImpl getInstance() {
        if (null == instance) {
            instance = new CallServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean exportToFile(Call aCall) {
        return dao.exportToFile(aCall);
    }
}
