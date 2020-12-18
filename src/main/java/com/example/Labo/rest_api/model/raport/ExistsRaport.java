package com.example.Labo.rest_api.model.raport;

import com.example.Labo.rest_api.model.container.ElementsContainer;
import lombok.Getter;

@Getter
public class ExistsRaport extends ElementRaport {
    public ExistsRaport(Object id, String elementType) {
        super(id, elementType, "Un élément avec l'id mentionné existe déjà");
    }
}
