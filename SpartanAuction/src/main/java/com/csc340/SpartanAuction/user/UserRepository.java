package com.csc340.SpartanAuction.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 */
public interface UserRepository extends JpaRepository<User, Integer>{

}
