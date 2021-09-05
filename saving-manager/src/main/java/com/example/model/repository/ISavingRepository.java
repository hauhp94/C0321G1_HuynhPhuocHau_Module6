package com.example.model.repository;

import com.example.model.entity.Saving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISavingRepository extends JpaRepository<Saving, Integer> {
    @Query(value = "select * from saving join customer on saving.customer_id = customer.id where concat(saving.id,customer.name) like %:keyword%", nativeQuery = true)
    List<Saving> findByNamCustomerOrId(String keyword);
}
