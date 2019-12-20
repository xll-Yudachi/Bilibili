package com.yudachi.user.repository;


import com.yudachi.user.entity.LFMVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LFMVideoRepository extends JpaRepository<LFMVideo,String> {
    public LFMVideo findByVid(String vid);
    public LFMVideo findByLfmvid(int LFMvid);
}
