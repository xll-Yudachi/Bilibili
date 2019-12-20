package com.yudachi.upload.repository;

import com.yudachi.upload.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Video,String> {

}
