package com.example.Labo.rest_api.model.raport;

import com.example.Labo.rest_api.model.container.ElementsContainer;

public class FoundRaport extends ElementRaport {
    public FoundRaport(Object id, String elementType) {
        super(id, elementType, "Il n'existe pas l'élément ayant cet id");
    }
}
