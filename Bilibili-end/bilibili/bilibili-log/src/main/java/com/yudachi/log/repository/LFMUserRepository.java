package com.yudachi.log.repository;


import com.yudachi.log.entity.LFMUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LFMUserRepository extends JpaRepository<LFMUser,String> {
    public LFMUser findByUid(String uid);
}
