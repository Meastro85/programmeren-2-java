import be.kdg.model.Mes;
import be.kdg.model.Messen;
import be.kdg.model.Steekwapen;
import be.kdg.reflection.ReflectionTools;

import java.lang.reflect.InvocationTargetException;

/**
 * Vincent Verboven
 * 2/10/2023
 */
public class Demo_3 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReflectionTools.classAnalysis(Steekwapen.class, Mes.class, Messen.class);
        Object obj = ReflectionTools.runAnnotated(Mes.class);
        System.out.println(obj);
    }
}
