package chkksjpt.colomind.chkksjpt.httputils;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * �Զ���ע��
 * Created by pangcongocng on 2015/8/14.
 */

@Target({ElementType.METHOD,ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.SOURCE)
public @interface Warning {
    String value();
}
