package com.shortenerbackend.URLShortener.Backend.Service;

import com.shortenerbackend.URLShortener.Backend.Models.LoginStatus;
import com.shortenerbackend.URLShortener.Backend.Models.PostResponseStatus;
import com.shortenerbackend.URLShortener.Backend.Models.UserRequest;

public interface IUserService {
    public PostResponseStatus register(UserRequest userRequest);

    //me
    public LoginStatus login(UserRequest userRequest);
    public PostResponseStatus urlPost(String longURL,String userId);
}
