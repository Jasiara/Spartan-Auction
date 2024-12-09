package com.csc340.SpartanAuction.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Provides the actual database transactions.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "SELECT * FROM user WHERE username = :username AND password = :password", nativeQuery = true)
    User findLoginUser(@Param("username") String username, @Param("password") String password);

    @Query(value = "DELETE FROM user WHERE username = ':username';", nativeQuery = true)
    void deleteByUsername(String username);

    @Query(value = "SELECT * FROM user WHERE username = :username;", nativeQuery = true)
    User findByUsername(String username);
}
