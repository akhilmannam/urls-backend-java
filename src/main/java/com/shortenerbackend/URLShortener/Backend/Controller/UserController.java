package com.shortenerbackend.URLShortener.Backend.Controller;


import com.shortenerbackend.URLShortener.Backend.Models.LoginStatus;
import com.shortenerbackend.URLShortener.Backend.Models.PostResponseStatus;
import com.shortenerbackend.URLShortener.Backend.Models.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.shortenerbackend.URLShortener.Backend.Service.IUserService;


@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UserController {

    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<PostResponseStatus> register(@RequestBody UserRequest userRequest){
        PostResponseStatus responseStatus = userService.register(userRequest);
        if(responseStatus.getStatus()){
            return new ResponseEntity<>(responseStatus,HttpStatus.OK);
        }
        return new ResponseEntity<>(responseStatus,HttpStatus.BAD_REQUEST);
    }

    //me
    @PostMapping("/login")
    public ResponseEntity<LoginStatus> login(@RequestBody UserRequest userRequest){
        LoginStatus loginStatus = userService.login(userRequest);
        return new ResponseEntity<>(loginStatus, HttpStatus.OK);
    }

    @PostMapping("/urls/{userId}")
    public ResponseEntity<PostResponseStatus> urlPost(@RequestBody String longURL, @PathVariable String userId ){
        PostResponseStatus responseStatus = userService.urlPost(longURL,userId);
        return new ResponseEntity<PostResponseStatus>(responseStatus, HttpStatus.OK);
    }

//    @GetMapping("urls/{id}")
//    public ResponseEntity<T> urlGet(@PathVariable String id){
//
//    }


}
