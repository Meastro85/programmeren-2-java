package be.kdg.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Vincent Verboven
 * 2/10/2023
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CanRun {
    String value() default "dummy";
}
