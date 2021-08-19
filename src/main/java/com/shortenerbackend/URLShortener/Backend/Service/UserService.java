package com.shortenerbackend.URLShortener.Backend.Service;

import com.shortenerbackend.URLShortener.Backend.Models.LoginStatus;
import com.shortenerbackend.URLShortener.Backend.Models.PostResponseStatus;
import com.shortenerbackend.URLShortener.Backend.Models.users;
import com.shortenerbackend.URLShortener.Backend.Repository.IUserDal;
import com.shortenerbackend.URLShortener.Backend.Repository.UserDal;
import com.shortenerbackend.URLShortener.Backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shortenerbackend.URLShortener.Backend.Models.UserRequest;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserDal userDal;


//    private String encrypt(String password){
//        return password;
//    }


    @Override
    public PostResponseStatus register(UserRequest userRequest){
        //userRequest.setPassword(encrypt(userRequest.getPassword()));
        users users = new users(userRequest);
        users = userRepository.save(users);
        return new PostResponseStatus("User Registered",true);
    }

    //me
    public LoginStatus login(UserRequest userRequest){
        //userRequest.setPassword(encrypt(userRequest.getPassword()));
        boolean isGood = userDal.login(userRequest);
         if(isGood){
             return new LoginStatus("Allow");
         }
         return new LoginStatus("dont Allow");

    }

    public PostResponseStatus urlPost(String longURL,String userId){
//        users users = userRepository.findById(userId).get();

        if(userDal.isLongUrlPresent(longURL,userId)) {
            return new PostResponseStatus("Long URL already Present", false);
        }
//        userDal.createShortUrl

        return new PostResponseStatus("Short URL created", true);

    }


}
