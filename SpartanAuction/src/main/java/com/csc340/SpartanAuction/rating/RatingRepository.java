package com.csc340.SpartanAuction.rating;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    @Query(value = "SELECT * FROM rating WHERE user_id = :userId", nativeQuery = true)
    public List<Rating> getAllRatingsForOneUser(@Param("userId") int userId);


    /*
    * select (CASE WHEN IDParent< 1 then ID
             else IDParent END) as columnname
from tablenmae
    * */
    @Query(value = "SELECT (CASE WHEN rating <> NULL then AVG(rating) else 0 END) FROM rating WHERE user_id = :userId;", nativeQuery = true)
    public double getAverageRatingForOneUser(@Param("userId") int userId);
}
