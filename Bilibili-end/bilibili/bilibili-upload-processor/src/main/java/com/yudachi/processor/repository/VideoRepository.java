package com.yudachi.processor.repository;

import com.yudachi.processor.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, String> {

}
