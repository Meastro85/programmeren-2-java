package be.kdg.reflection;
import java.lang.reflect.*;

/**
 * Vincent Verboven
 * 2/10/2023
 */
public class ReflectionTools {
    public static void classAnalysis(Class<?>... aClass){
        for(Class<?> bClass : aClass){
            StringBuilder getterString = new StringBuilder();
            StringBuilder setterString = new StringBuilder();
            StringBuilder otherMethodString = new StringBuilder();
            for(Method m : bClass.getDeclaredMethods()){
                if(m.getName().contains("get")){
                    getterString.append("\n").append(m.getName());
                } else if(m.getName().contains("set")){
                    setterString.append("\n").append(m.getName());
                } else {
                    otherMethodString.append("\n").append(m.getName());
                }
            }

            StringBuilder attributeString = new StringBuilder();
            for(Field f : bClass.getDeclaredFields()){
                attributeString.append("\n").append(f.getName()).append("(").append(f.getType().getSimpleName()).append(")");
            }

            StringBuilder interfaceString = new StringBuilder();
            for(Class<?> iface : bClass.getInterfaces()){
                interfaceString.append("\n").append(iface.getSimpleName());
            }

            StringBuilder constructorString = new StringBuilder();
            for(Constructor<?> con : bClass.getDeclaredConstructors()){
                constructorString.append("\n").append(con.toGenericString());
            }

            System.out.printf("""
                Analyse van de klasse: %s
                ============================================
                Fully qualified name: %s
                Naam van de superklasse: %s
                Naam van de package: %s
                Interfaces: %s
                Constructors: %s
                attributen: %s
                getters: %s
                setters: %s
                andere methoden: %s
                """, bClass.getSimpleName(),
                    bClass.getName(),
                    bClass.getAnnotatedSuperclass(),
                    bClass.getPackageName(),
                    interfaceString,
                    constructorString,
                    attributeString,
                    getterString,
                    setterString,
                    otherMethodString);
        }
        }

        public static Object runAnnotated(Class<?> aClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            Object obj = aClass.getConstructor().newInstance();
            for (Method m : obj.getClass().getMethods()){
                CanRun canRun = m.getAnnotation(CanRun.class);
                if(canRun != null && m.getGenericParameterTypes().length == 1 && m.getParameterTypes()[0].getSimpleName().equals("String")){
                    m.invoke(obj, canRun.value());
                }
            }
            return obj;
        }


}
