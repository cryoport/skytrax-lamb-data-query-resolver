package com.cryoport.skytrax.resolver.model.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record Device(String id, String message) {
}
