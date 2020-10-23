package com.rnf.core.modelentitymapper.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation permettant de faire le lien entre attribut de mod�le et attribut d'entit�
 * Code g�n�rique
 * @author SADSB-Mitanjo
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ModelFieldMap {
	String targetField();
}
