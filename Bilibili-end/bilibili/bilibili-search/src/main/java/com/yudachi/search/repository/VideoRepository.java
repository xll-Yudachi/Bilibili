package com.yudachi.search.repository;

import com.yudachi.search.entity.Video;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, String> {
    public List<Video> findByTitleContains(String title);
    public List<Video> findByTitleContains(String title, Pageable pageable);
}
