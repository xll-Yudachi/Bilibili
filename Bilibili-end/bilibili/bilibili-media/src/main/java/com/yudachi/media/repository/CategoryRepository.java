package com.yudachi.media.repository;

import com.yudachi.media.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public List<Category> findByParentidIsNull();

    public List<Category> findByParentid(Integer parentid);
}
