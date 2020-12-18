package com.example.Labo.rest_api;

import com.example.Labo.Exeption.ElementAlreadyExistsException;
import com.example.Labo.Exeption.ElementFoundException;
import com.example.Labo.Exeption.FoundExeption;
import com.example.Labo.business.dto.IdentifiedDTO;
import com.example.Labo.rest_api.model.container.ElementsContainer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudController<DTO extends IdentifiedDTO<ID>, ID> {

    // Create
    void create(@RequestBody DTO dto) throws ElementAlreadyExistsException;

    // Read
    ResponseEntity<DTO> getOne(@PathVariable ID id) throws ElementFoundException, FoundExeption;
    ResponseEntity<ElementsContainer<DTO>> getAll();

    // Update
    ResponseEntity<String> update(@RequestBody DTO dto) throws ElementFoundException, FoundExeption;

    // Delete
    ResponseEntity<DTO> delete(@PathVariable ID id) throws ElementFoundException, FoundExeption;
}
