package com.fanw.socialapp.controller;


import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fanw.socialapp.util.StaticName;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /*
    * 使用邮箱和密码登陆账号
    * */
    @RequestMapping(value = "/phoneLogin",method = RequestMethod.POST)
    public  String userLoginByPhone(User user){
        System.out.println(StaticName.savePath);
        User newUser = userService.loginByPhone(user);
        if(newUser!= null){
            newUser.setUser_status(true);
            if(userService.login_updateStatusById(newUser) == 1){
                return newUser.toString();
            }
        }
        return "Fail";
    }

    /*
    * 使用电话和密码登陆账号
    * */
    @RequestMapping(method = RequestMethod.POST ,value = "/mailLogin")
    public String userLoginByMail(User user){
        return userService.loginByMail(user).toString();
    }

    /*
    * @Param:headFile
    * 上传头像
    * */
    @RequestMapping(value = "/headUpload",method = RequestMethod.POST)
    public  String userHeadUploadById(User user, @RequestParam("headFile")MultipartFile multipartFile){
        if(multipartFile.isEmpty()){
            return  "Empty";
        }
        String headFileName = multipartFile.getOriginalFilename();
        File dest = new File(StaticName.savePath,headFileName);
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            multipartFile.transferTo(dest);
//            user.setUser_id(1);
            user.setUser_head(StaticName.savePath+headFileName);
            /*
            * 确认user的user_id是存在的
            * */
            int test = userService.uploadHeadById(user);
//            System.out.println(test);
//            System.out.println(user.getUser_head());
            return "Success";
        } catch (IllegalStateException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Fail";
    }

    @RequestMapping(value = "/mailRegister",method = RequestMethod.POST)
    public String userRegisterByMail(User user){
        int test = userService.registerUserByMail(user);
        if(test == 1){
            return "Success";
        }
        return "Fail";
    }


    @RequestMapping(value = "/signOut",method = RequestMethod.POST)
    public String userSignOutById(User user){
        user.setUser_status(false);
        if(userService.signOut_updateStatusById(user) == 1){
            return "sign out success";
        }
        return "Fail";
    }

}
