package com.yudachi.media.service;

import com.yudachi.media.entity.*;
import com.yudachi.media.repository.*;
import com.yudachi.model.response.Media.CategoryResult;
import com.yudachi.model.response.Media.CommercialResult;
import com.yudachi.model.response.Media.CommercialWayResult;
import com.yudachi.model.response.Media.LanguageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private LanguageRepository languageRepository;
    @Autowired
    private CommercialRepository commercialRepository;
    @Autowired
    private CommercialWayRepository commercialWayRepository;

    public List<CategoryResult> initCategoryList(){

        List<CategoryResult> list = new ArrayList<>();

        List<Category> parentList = categoryRepository.findByParentidIsNull();

        for (Category category : parentList){
            CategoryResult categoryResult = new CategoryResult();
            categoryResult.setLabel(category.getCategoryname());
            categoryResult.setValue(category.getCategoryname());
            List<Category> childrenList = categoryRepository.findByParentid(category.getId());
            List<CategoryResult> children = new ArrayList<>();
            for (Category tmp : childrenList){
                CategoryResult categoryResultChildren = new CategoryResult();
                categoryResultChildren.setValue(tmp.getCategoryname());
                categoryResultChildren.setLabel(tmp.getCategoryname());
                children.add(categoryResultChildren);
            }
            categoryResult.setChildren(children);
            list.add(categoryResult);
        }

        return list;
    }

    public String findVideoUrlById(String id){
        Optional<Video> optional = videoRepository.findById(id);
        if (optional.isPresent()){
            return optional.get().getVideo_url();
        }else{
            return null;
        }
    }

    public List<LanguageResult> initLanguage(){
        List<Language> all = languageRepository.findAll();
        List<LanguageResult> list = new ArrayList<>();
        for (Language language : all){
            LanguageResult languageResult = new LanguageResult();
            languageResult.setLabel(language.getLname());
            languageResult.setValue(language.getLname());
            list.add(languageResult);
        }
        return list;
    }

    public List<CommercialResult> initCommercial(){
        List<Commercial> all = commercialRepository.findAll();
        List<CommercialResult> list = new ArrayList<>();
        for (Commercial commercial : all){
            CommercialResult commercialResult = new CommercialResult();
            commercialResult.setLabel(commercial.getCname());
            commercialResult.setValue(commercial.getCname());
            list.add(commercialResult);
        }
        return list;
    }

    public List<CommercialWayResult> initCommercialWay(){
        List<CommercialWay> all = commercialWayRepository.findAll();
        List<CommercialWayResult> list = new ArrayList<>();
        for (CommercialWay commercialWay : all){
            CommercialWayResult commercialWayResult = new CommercialWayResult();
            commercialWayResult.setLabel(commercialWay.getWay());
            commercialWayResult.setValue(commercialWay.getWay());
            list.add(commercialWayResult);
        }
        return list;
    }

    public Video findVideoById(String id){
        Optional<Video> optionalVideo = videoRepository.findById(id);
        if (optionalVideo.isPresent()){
            return optionalVideo.get();
        }else{
            return null;
        }
    }
}
