package com.yudachi.media.repository;

import com.yudachi.media.entity.Danmu;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DanmuRepository extends MongoRepository<Danmu,String> {

    public List<Danmu> findByAuthor(String author);
    public List<Danmu> findByPlayerOrderByDateDesc(String player);

}
