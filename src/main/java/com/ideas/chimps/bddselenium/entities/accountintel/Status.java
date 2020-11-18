package com.ideas.chimps.bddselenium.entities.accountintel;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum Status {
    PENDING,
    ACCEPTED,
    EXCLUDED,
    CONTRACTED;
    static Map<String, Status> statuses = Arrays.stream(Status.values()).collect(Collectors.toMap(Enum::name, status -> status));

    public static Status search(String key) {
        return statuses.get(key);
    }
}