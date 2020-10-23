package com.rnf.misc;

import java.util.HashMap;
import java.util.Map;

public enum EnumEtatUser {
	ACTIVEE(0),
	DESACTIVEE(1),
	REINITIALISER(2);
	
	private int value;
    private static Map<Integer, EnumEtatUser> map = new HashMap<>();

    private EnumEtatUser(int value) {
        this.value = value;
    }

    static {
        for (EnumEtatUser pageType : EnumEtatUser.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static EnumEtatUser valueOf(int pageType) {
        return (EnumEtatUser) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}
