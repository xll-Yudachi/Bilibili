package com.yudachi.comment.repository;

import com.yudachi.comment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
