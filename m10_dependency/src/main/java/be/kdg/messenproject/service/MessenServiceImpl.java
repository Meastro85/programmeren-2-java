package be.kdg.messenproject.service;

import be.kdg.messenproject.database.MesDao;
import be.kdg.messenproject.exceptions.MessenException;
import be.kdg.messenproject.model.Mes;

import java.sql.SQLException;
import java.util.List;

/**
 * Vincent Verboven
 * 21/12/2023
 */
public class MessenServiceImpl implements MessenService{

    private MesDao mesDao;

    public MessenServiceImpl(MesDao mesDao){
        this.mesDao = mesDao;
    }


    @Override
    public List<Mes> getAllMessen() throws MessenException {
        return mesDao.getAllMessen();
    }

    @Override
    public boolean addMes(Mes mes) throws MessenException {
        return mesDao.insert(mes);
    }
}
