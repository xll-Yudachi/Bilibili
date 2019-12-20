package com.yudachi.media.service;

import com.yudachi.media.entity.Danmu;
import com.yudachi.media.repository.DanmuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanmuService {

    @Autowired
    private DanmuRepository danmuRepository;

    public List<Danmu> findDanmuByPlayer(String player){
        return danmuRepository.findByPlayerOrderByDateDesc(player);
    }

    public List<Danmu> findDanmuByAuthor(String author){
        return danmuRepository.findByAuthor(author);
    }

    public List<Danmu> findOrderByDateTop12(String player){
        List<Danmu> list = danmuRepository.findByPlayerOrderByDateDesc(player);

        return list.subList(0, 12);

    }
}
