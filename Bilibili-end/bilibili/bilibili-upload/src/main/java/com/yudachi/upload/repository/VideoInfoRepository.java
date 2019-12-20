package com.yudachi.upload.repository;

import com.yudachi.upload.entity.VideoMore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoInfoRepository extends JpaRepository<VideoMore, String> {

}
