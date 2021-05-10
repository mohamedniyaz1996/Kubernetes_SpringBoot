package com.ugam.ems.dao;

import com.ugam.ems.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<Users, Long> {
    @Query("SELECT u FROM Users u WHERE u.username = :un AND u.password = :pw")
    public Users findUser(@Param("un") String userName, @Param("pw") String password);
}
