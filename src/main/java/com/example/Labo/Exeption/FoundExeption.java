package com.example.Labo.Exeption;

import lombok.Getter;

@Getter
public class FoundExeption extends Exception {

    private final Object id;
    private final Class<?> clazz;

    public FoundExeption(Class<?> ofClass, Object id) {
        super("L'element de classe " + ofClass.getSimpleName() + " d'id(" + id + ") n'a pas été trouvé");
        this.id = id;
        this.clazz = ofClass;
    }
}
