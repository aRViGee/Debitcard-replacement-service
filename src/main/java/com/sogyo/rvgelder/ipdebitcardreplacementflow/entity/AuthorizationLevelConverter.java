package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.AuthorizationLevel;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(/*autoApply = true*/)
    public class AuthorizationLevelConverter implements AttributeConverter<AuthorizationLevel, Integer> {

        @Override
        public Integer convertToDatabaseColumn(AuthorizationLevel authorizationLevel) {
            if (authorizationLevel == null) {
                return null;
            }
            return authorizationLevel.getLevel();
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
