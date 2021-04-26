package me.hammer86gn.djar.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface Marked {
    enum MarkType {
        REMOVAL,
        DEPRECATION,
    }

    MarkType type() default MarkType.DEPRECATION;
    String date() default "N/A";



}
