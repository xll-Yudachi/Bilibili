package com.yudachi.search.service;

import com.yudachi.model.response.Search.SearchResult;
import com.yudachi.search.entity.User;
import com.yudachi.search.entity.Video;
import com.yudachi.search.repository.UserRepository;
import com.yudachi.search.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private UserRepository userRepository;

    public List<SearchResult> findAllVideo(String keyword){
        List<Video> all = videoRepository.findByTitleContains(keyword);
        List<SearchResult> list = new ArrayList<>();
        for (Video video : all){
            SearchResult searchResult = new SearchResult();
            searchResult.setId(video.getId());
            searchResult.setDuration(video.getDuration());
            searchResult.setImage_url(video.getImage_url());
            searchResult.setPlay_num(video.getPlay_num());
            searchResult.setTitle(video.getTitle());
            searchResult.setUpload_time(video.getUpload_time());
            Optional<User> optionalUser = userRepository.findById(video.getUpid());
            if (optionalUser.isPresent()){
                searchResult.setUpname(optionalUser.get().getUsername());
                list.add(searchResult);
            }
        }
        return list;
    }

    public List<SearchResult> findVideoByPage(String keyword, String page) {
        List<Video> all = videoRepository.findByTitleContains(keyword, PageRequest.of(Integer.parseInt(page)-1, 20));
        List<SearchResult> list = new ArrayList<>();
        for (Video video : all){
            SearchResult searchResult = new SearchResult();
            searchResult.setId(video.getId());
            searchResult.setDuration(video.getDuration());
            searchResult.setImage_url(video.getImage_url());
            searchResult.setPlay_num(video.getPlay_num());
            searchResult.setTitle(video.getTitle());
            searchResult.setUpload_time(video.getUpload_time());
            Optional<User> optionalUser = userRepository.findById(video.getUpid());
            if (optionalUser.isPresent()){
                searchResult.setUpname(optionalUser.get().getUsername());
                list.add(searchResult);
            }
        }
        return list;
    }
}
