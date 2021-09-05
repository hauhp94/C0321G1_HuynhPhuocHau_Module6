package com.example.model.service;

import com.example.model.entity.Saving;
import com.example.model.repository.ISavingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SavingService implements ISavingService {
    @Autowired
    private ISavingRepository savingRepository;

    @Override
    public List<Saving> findAll() {
        return savingRepository.findAll();
    }

    @Override
    public Page<Saving> findAllWithPage(Pageable pageable) {
        return savingRepository.findAll(pageable);
    }

    @Override
    public Optional<Saving> findById(Integer id) {
        System.out.println("da vao fidbyid");
        return savingRepository.findById(id);
    }

    @Override
    public Saving save(Saving saving) {
        System.out.println("da vao save trong service");
        return savingRepository.save(saving);
    }

    @Override
    public void remove(Integer id) {
        savingRepository.deleteById(id);
    }

    @Override
    public List<Saving> findByNameAndId(String keyword) {
        System.out.println("vao phuong thuc search");
        return savingRepository.findByNamCustomerOrId(keyword);
    }
}
