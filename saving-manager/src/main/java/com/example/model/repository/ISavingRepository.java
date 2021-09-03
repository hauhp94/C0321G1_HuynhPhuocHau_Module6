package com.example.model.repository;

import com.example.model.entity.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISavingRepository extends JpaRepository<Saving, Integer> {
}
