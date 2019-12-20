package com.yudachi.comment.repository;

import com.yudachi.comment.entity.SensitiveWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensitiveRepository extends JpaRepository<SensitiveWord, Integer> {

}
