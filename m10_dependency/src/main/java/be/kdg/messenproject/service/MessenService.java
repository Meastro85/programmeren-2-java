package be.kdg.messenproject.service;

import be.kdg.messenproject.exceptions.MessenException;
import be.kdg.messenproject.model.Mes;

import java.sql.SQLException;
import java.util.List;

/**
 * Vincent Verboven
 * 21/12/2023
 */
public interface MessenService {

    List<Mes> getAllMessen() throws MessenException;
    boolean addMes(Mes mes) throws MessenException;

}
