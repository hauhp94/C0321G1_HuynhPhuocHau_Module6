package com.example.model.service;

import com.example.model.entity.Saving;

import java.util.List;
import java.util.Optional;

public interface ISavingService {
    List<Saving> findAll();

    Optional<Saving> findById(Integer id);

    Saving save(Saving saving);

    void remove(Integer id);
}
