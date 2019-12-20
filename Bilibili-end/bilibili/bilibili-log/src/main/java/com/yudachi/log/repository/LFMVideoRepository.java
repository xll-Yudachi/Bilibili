package com.yudachi.log.repository;


import com.yudachi.log.entity.LFMVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LFMVideoRepository extends JpaRepository<LFMVideo,String> {
    public LFMVideo findByVid(String vid);
    public LFMVideo findByLfmvid(int LFMvid);
}
