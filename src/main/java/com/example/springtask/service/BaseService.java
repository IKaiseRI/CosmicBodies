package com.example.springtask.service;

import com.example.springtask.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

@RequiredArgsConstructor
public abstract class BaseService<ELEMENT> {
    private final BaseRepository<ELEMENT> repository;

    public ELEMENT create(ELEMENT element) {
        return repository.save(element);
    }


    public ELEMENT findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Planet is not found"));
    }

    @SneakyThrows
    public void update(Long id, ELEMENT updatedElement) {
        ELEMENT existingElement = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Planet is not found"));

        Field[] fields = updatedElement.getClass().getDeclaredFields();
        for (var field : fields) {
            field.setAccessible(true);
            if (field.get(updatedElement) != null) {
                field.set(existingElement, field.get(updatedElement));
            }
            field.setAccessible(false);
        }

        repository.save(existingElement);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
