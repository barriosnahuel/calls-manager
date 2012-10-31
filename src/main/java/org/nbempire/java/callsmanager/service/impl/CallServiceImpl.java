package org.nbempire.java.callsmanager.service.impl;

import org.nbempire.java.callsmanager.dao.CallDao;
import org.nbempire.java.callsmanager.dao.impl.CallDaoImpl;
import org.nbempire.java.callsmanager.domain.Call;
import org.nbempire.java.callsmanager.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by: Nahuel Barrios. On: 19/03/2010 at 13:40hs.
 *
 * @author Barrios, Nahuel.
 * @version 1.0
 */
@Service
public class CallServiceImpl implements CallService {

    @Autowired
    private CallDao dao;

    @Override
    public boolean exportToFile(Call aCall) {
        return dao.exportToFile(aCall);
    }
}
