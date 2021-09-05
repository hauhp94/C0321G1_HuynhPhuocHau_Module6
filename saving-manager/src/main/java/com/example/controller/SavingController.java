package com.example.controller;

import com.example.model.entity.Saving;
import com.example.model.service.ISavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/savings")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SavingController {

    @Autowired
    private ISavingService savingService;

    @GetMapping
    public ResponseEntity<List<Saving>> findAllSaving() {
        List<Saving> savingList = savingService.findAll();
        if (savingList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(savingList, HttpStatus.OK);
    }
//    @GetMapping
//    public ResponseEntity<Page<Saving>> findAllSaving(@PageableDefault(value = 1) Pageable pageable) {
//        Page<Saving> savingList = savingService.findAllWithPage(pageable);
//        if (savingList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(savingList, HttpStatus.OK);
//    }
    @GetMapping("search")
    public ResponseEntity<List<Saving>> searchSaving(@RequestParam String keyword) {
        List<Saving> savingList = savingService.findByNameAndId(keyword);
        if (savingList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(savingList, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Saving> findSavingById(@PathVariable Integer id) {
        Optional<Saving> saving = savingService.findById(id);
        if (!saving.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(saving.get(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Saving> saveSaving(@RequestBody Saving saving) {
        return new ResponseEntity<>(savingService.save(saving), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Saving> updateSaving(@PathVariable Integer id, @RequestBody Saving saving) {
        System.out.println("vao patch mapping");
        Optional<Saving> saving1 = savingService.findById(id);
        if (!saving1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        System.out.println("tim dc id: " + saving1.get().getId());
        Saving currentSaving = saving1.get();
        currentSaving.setId(saving.getId());
        currentSaving.setCustomer(saving.getCustomer());
        currentSaving.setDate(saving.getDate());
        currentSaving.setPeriod(saving.getPeriod());
        currentSaving.setDeposit(saving.getDeposit());
        currentSaving.setRate(saving.getRate());
        currentSaving.setOffer(saving.getOffer());
        savingService.save(currentSaving);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Saving> deleteSaving(@PathVariable Integer id) {
        Optional<Saving> saving = savingService.findById(id);
        if (!saving.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        savingService.remove(id);
        return new ResponseEntity<>(saving.get(), HttpStatus.OK);
    }
}
