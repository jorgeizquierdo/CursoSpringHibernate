package com.hiberus.api.aop.annotation;

import java.lang.annotation.*;

/**
 * Created by Daniel on 18/06/2016.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RegisterLog {
}