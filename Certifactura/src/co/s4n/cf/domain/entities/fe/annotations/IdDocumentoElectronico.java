package co.s4n.cf.domain.entities.fe.annotations;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

/**
 * Certifactura
 * IdDocumentoElectronico.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
@BindingAnnotation 
@Target( { FIELD, METHOD, CONSTRUCTOR, PARAMETER } ) 
@Retention( RUNTIME )
public @interface IdDocumentoElectronico { }
