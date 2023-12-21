package be.kdg.messenproject.database;

import be.kdg.messenproject.model.Mes;

import java.sql.SQLException;
import java.util.List;

/**
 * Vincent Verboven
 * 23/10/2023
 */
public interface MesDao {
    boolean insert(Mes mes);
    boolean delete(String params);
    boolean update(Mes mes);
    Mes retrieve(int id);
    List<Mes> SortedOn(String query);
    List<Mes> getAllMessen();
}
