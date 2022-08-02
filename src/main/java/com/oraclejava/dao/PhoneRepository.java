package com.oraclejava.dao;

import com.oraclejava.model.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends
        CrudRepository<Phone,Integer> {
}
