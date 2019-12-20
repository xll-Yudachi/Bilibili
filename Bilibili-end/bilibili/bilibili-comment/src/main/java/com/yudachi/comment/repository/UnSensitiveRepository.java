package com.yudachi.comment.repository;

import com.yudachi.comment.entity.UnSensitiveWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnSensitiveRepository extends JpaRepository<UnSensitiveWord, Integer> {

}
