package com.ideas.chimps.bddselenium.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UIName {
    String uiName();
}
