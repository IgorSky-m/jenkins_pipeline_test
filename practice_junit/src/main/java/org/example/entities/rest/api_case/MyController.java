package org.example.entities.rest.api_case;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.rest.api_case.api.IMyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/my")
public class MyController {

    private final IMyService service;


    public MyController(IMyService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public MyEntity getOne(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping
    public List<MyEntity> getAll() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<MyEntity> create(@RequestBody MyEntity entity) {
        return new ResponseEntity<>(service.create(entity), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public MyEntity update(@RequestBody MyEntity entity, @PathVariable UUID id) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
