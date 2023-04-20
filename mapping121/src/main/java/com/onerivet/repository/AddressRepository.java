package com.onerivet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onerivet.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
