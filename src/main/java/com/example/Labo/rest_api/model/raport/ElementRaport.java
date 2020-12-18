package com.example.Labo.rest_api.model.raport;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class ElementRaport {

    private final Object id;
    private final String elementType;
    private final String message;
}
