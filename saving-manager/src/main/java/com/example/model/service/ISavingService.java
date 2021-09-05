package com.example.model.service;

import com.example.model.entity.Customer;
import com.example.model.entity.Saving;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISavingService {
    List<Saving> findAll();

    Page<Saving> findAllWithPage(Pageable pageable);

    Optional<Saving> findById(Integer id);

    Saving save(Saving saving);

    void remove(Integer id);
    List<Saving> findByNameAndId(String keyword);

}
