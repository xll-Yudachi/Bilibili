package com.yudachi.user.service;

import com.yudachi.model.response.ResponseResult;
import com.yudachi.model.response.UserCode.UserCode;
import com.yudachi.user.entity.LFMUser;
import com.yudachi.user.entity.User;
import com.yudachi.user.repository.LFMUserRepository;
import com.yudachi.user.repository.UserRepository;
import com.yudachi.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author Yudachi
 * @Description 用户服务类
 * @Date 2019/11/11 18:22
 * @Version 1.0
 **/
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private LFMUserRepository lfmUserRepository;

    public ResponseResult register(User user, String code){
        user.setId(idWorker.nextId() + "");
        user.setPassword(encoder.encode(user.getPassword()));
        user.setCreate_time(new Date());
        user.setHead_img("http://192.168.202.167/group1/M00/00/00/wKjKp137PzyATdh8AAARQXS0jHQ722.gif");
        LFMUser lfmUser = new LFMUser();
        lfmUser.setId(idWorker.nextId() + "");
        lfmUser.setUid(user.getId());
        lfmUserRepository.save(lfmUser);
        String redisCode = redisTemplate.opsForValue().get(user.getPhone());
        if (redisCode == null  || (!redisCode.equals(code))){
            return new ResponseResult(UserCode.CODE_ERROR);
        }
        userRepository.save(user);
        return new ResponseResult(UserCode.REGISTER_SUCCESS);
    }

    public ResponseResult findUserByPhone(String phone) {
        List<User> exits = userRepository.findUserByPhone(phone);

        if (exits.size() > 0){
            return new ResponseResult(UserCode.DUPLICATE_USERPHONE);
        }else{
            return new ResponseResult(UserCode.USERPHONE_SUCCESS);
        }
    }

    public ResponseResult findUserByUsername(String username){
        List<User> exits = userRepository.findUserByUsername(username);
        if (exits.size() > 0){
            return new ResponseResult(UserCode.DUPLICATE_USERNAME);
        }else{
            return new ResponseResult(UserCode.USERNAME_SUCCESS);
        }
    }

    public ResponseResult login(User user) {
        List<User> userList = new ArrayList<>();
        if (!StringUtils.isEmpty(user.getPhone())){
            userList = userRepository.findUserByPhone(user.getPhone());
        }
        if (!StringUtils.isEmpty(user.getEmail())){
            userList = userRepository.findUserByEmail(user.getEmail());
        }
        if (userList.size() > 0){
            User findUser = userList.get(0);
            boolean matches = encoder.matches(user.getPassword(), findUser.getPassword());
            if (!matches){
                return new ResponseResult(UserCode.LOGIN_FAIL);
            }else{
                return new ResponseResult(UserCode.LOGIN_SUCCESS,findUser.getId());
            }
        }else{
            return new ResponseResult(UserCode.LOGIN_FAIL);
        }
    }

    public ResponseResult getUserInfo(String userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()){
            return new ResponseResult(UserCode.SEARCH_USERINFO_SUCCESS, user.get());
        }else{
            return new ResponseResult(UserCode.SEARCH_USERINFO_FAIL);
        }
    }

    @Transactional
    public ResponseResult changeSign(String uid, String sign) {

        userRepository.changeSign(sign, uid);

        return new ResponseResult(UserCode.CHANGESIGN_SUCCESS);
    }

}
