package com.yudachi.search.repository;

import com.yudachi.search.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
