package com.ekin.tech.product.management.service.converter;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.TimeZone;

public final class BaseCommonConverter {

    private static final ObjectMapper OBJECT_MAPPER = (new ObjectMapper()).registerModule(new JavaTimeModule());

    static {
        OBJECT_MAPPER.setTimeZone(TimeZone.getDefault());
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }


    private BaseCommonConverter() {
        /* Singleton class cannot be instantiated! */
    }

    public static <T> T convert(Object from, Class<T> clazz) {
        return OBJECT_MAPPER.convertValue(from, clazz);
    }

    public static <T> T convert(Object from, TypeReference<T> typeReference) {
        return OBJECT_MAPPER.convertValue(from, typeReference);
    }

}
