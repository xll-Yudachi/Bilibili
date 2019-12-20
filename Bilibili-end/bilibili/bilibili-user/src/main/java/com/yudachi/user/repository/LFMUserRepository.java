package com.yudachi.user.repository;


import com.yudachi.user.entity.LFMUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LFMUserRepository extends JpaRepository<LFMUser,String> {
    public LFMUser findByUid(String uid);
    public LFMUser findByLfmuid(int LFMuid);
}
