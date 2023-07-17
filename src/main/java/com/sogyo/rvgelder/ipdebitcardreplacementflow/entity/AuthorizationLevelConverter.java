package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter()
    public class AuthorizationLevelConverter implements AttributeConverter<AuthorizationLevel, Integer> {

        @Override
        public Integer convertToDatabaseColumn(AuthorizationLevel level) {
            if (level == null) {
                return null;
            }
            return level.getLevel();
        }

        @Override
        public AuthorizationLevel convertToEntityAttribute(Integer level) {
            if (level == null) {
                return null;
            }

            return Stream.of(AuthorizationLevel.values())
                    .filter(c -> c.getLevel().equals(level))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
        }
    }
