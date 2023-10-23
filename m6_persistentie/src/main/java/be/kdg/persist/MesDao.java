package be.kdg.persist;

import be.kdg.model.Lemmet;
import be.kdg.model.Mes;

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
}
