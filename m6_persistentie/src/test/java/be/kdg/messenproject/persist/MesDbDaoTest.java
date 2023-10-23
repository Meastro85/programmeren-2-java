package be.kdg.messenproject.persist;

import be.kdg.data.Data;
import be.kdg.model.Mes;
import be.kdg.persist.MesDbDao;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Vincent Verboven
 * 23/10/2023
 */
public class MesDbDaoTest {

    private static MesDbDao mesDbDao;

    @BeforeAll
    public static void before(){
        mesDbDao = new MesDbDao("db/messenDatabase");
    }

    @AfterAll
    public static void after(){
        mesDbDao.close();
    }

    @BeforeEach
    public void setUp(){
        Data.getData().forEach(mesDbDao::insert);
    }

    @AfterEach
    public void tearDown(){
        mesDbDao.delete("*");
    }

    @Test
    public void testInsert(){
        assertEquals(Data.getData().size(), mesDbDao.SortedOnType().size(), "De Database moet evenveel objecten bevatten als de Data lijst.");
    }

    @Test
    public void testRetrieveUpdate(){
        Mes mes  = mesDbDao.retrieve(1);
        mes.setType("TestType");
        mesDbDao.update(mes);
        Mes newMes = mesDbDao.retrieve(1);
        assertEquals(mes, newMes,"De database moet bij een update het object updaten.");
    }

    @Test
    public void selectAll() throws SQLException {
        mesDbDao.selectAll();
    }

    @Test
    public void testDelete(){
        mesDbDao.delete("id = 3");
        assertNotEquals(Data.getData().size(), mesDbDao.SortedOnType().size(), "Bij een delete moet de database het record verwijderen.");
    }

    @Test
    public void testSort(){
        assertEquals(Data.getData().stream().sorted(Comparator.comparing(Mes::getHardheid)).collect(Collectors.toList()), mesDbDao.SortedOnHardheid(), "Bij het sorteren moeten de lijsten hetzelfde zijn");
    }

}
