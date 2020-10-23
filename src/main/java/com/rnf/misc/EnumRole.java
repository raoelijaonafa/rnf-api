package com.rnf.misc;

import java.util.HashMap;
import java.util.Map;

public enum EnumRole {
	ROLE_SUPERADMIN(1),
	ROLE_ADMIN(2),
	ROLE_MINISTERE(3);
	
	private int value;
    private static Map<Integer, EnumRole> map = new HashMap<>();

    private EnumRole(int value) {
        this.value = value;
    }

    static {
        for (EnumRole pageType : EnumRole.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static EnumRole valueOf(int pageType) {
        return (EnumRole) map.get(pageType);
    }

    public int getValue() {
        return value;
    }
}
