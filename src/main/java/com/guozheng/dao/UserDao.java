package com.guozheng.dao;

import com.guozheng.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query(value = "SELECT u.* FROM shop_owner.\"USER\" u WHERE u.username = :username", nativeQuery = true)
    User findByUsername(String username);
}
