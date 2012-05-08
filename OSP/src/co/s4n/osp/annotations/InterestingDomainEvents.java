package co.s4n.osp.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

/**
 * Certifactura
 * InterestingDomainEvents.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */

@BindingAnnotation 
@Target( { FIELD, METHOD } ) 
@Retention( RUNTIME )
public @interface InterestingDomainEvents { }
