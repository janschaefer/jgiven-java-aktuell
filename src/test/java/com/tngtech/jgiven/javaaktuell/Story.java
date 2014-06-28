package com.tngtech.jgiven.javaaktuell;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.tngtech.jgiven.annotation.IsTag;

@IsTag(prependType=true)
@Retention(RetentionPolicy.RUNTIME)
public @interface Story {
    String value();
}
