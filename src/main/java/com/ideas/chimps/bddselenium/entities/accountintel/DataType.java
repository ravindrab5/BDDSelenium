package com.ideas.chimps.bddselenium.entities.accountintel;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum DataType {
    SYSTEM_DEFINED,
    USER_DEFINED;

    static Map<String, DataType> dataTypes = Arrays.stream(DataType.values()).collect(Collectors.toMap(Enum::name, dp -> dp));
    public static DataType search(String key) {
        return dataTypes.get(key);
    }

}
