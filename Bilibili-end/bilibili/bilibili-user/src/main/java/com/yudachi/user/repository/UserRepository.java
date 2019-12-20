package com.yudachi.user.repository;

import com.yudachi.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    public List<User> findUserByPhone(String phone);

    public List<User> findUserByUsername(String username);

    public List<User> findUserByEmail(String email);

    @Query(value = "update user set sign = ?1 where id = ?2", nativeQuery = true)
    @Modifying
    public void changeSign(String sign , String uid);

    public User findByUsername(String username);
}
