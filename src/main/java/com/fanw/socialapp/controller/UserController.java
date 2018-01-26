package com.fanw.socialapp.controller;


import com.fanw.socialapp.model.User;
import com.fanw.socialapp.model.UserJson;
import com.fanw.socialapp.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fanw.socialapp.util.StaticName;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    * 使用邮箱和密码登陆账号
    * @param user_mail,user_pwd
    * */
    @RequestMapping(value = "/phoneLogin",method = RequestMethod.POST)
    public  String userLoginByPhone(User user){
//        System.out.println(StaticName.savePath);
        User newUser = new User();
        String callback;
        try {
            newUser = userService.loginByPhone(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        callback = loginHelp(newUser);
        return callback;
    }

    /*
    * 使用邮箱和密码登陆账号
    * @param user_mail,user_pwd
    * */
    @RequestMapping(method = RequestMethod.POST ,value = "/mailLogin")
    public String userLoginByMail(User user){
        User newUser = new User();
        String callback;
        try {
            newUser = userService.loginByMail(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        callback = loginHelp(newUser);
        return callback;
    }

    /*
    * @Param headFile,user_id
    * 上传头像
    * */
    @RequestMapping(value = "/headUpload",method = RequestMethod.POST)
    public  String userHeadUploadById(User user, @RequestParam("headFile")MultipartFile multipartFile){
        String callback;
        int test = 0;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        if(multipartFile.isEmpty()){
            callback = new Gson().toJson(new UserJson(500,"not file"));
        }else{
            String headFileName = multipartFile.getOriginalFilename();
            String suffix = headFileName.substring(headFileName.lastIndexOf(".")+1);
            String temp = user.getUser_id()+df.format(new Date())+(int)(Math.random()*100)+"."+suffix;
            File dest = new File(StaticName.headSavePath,temp);
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            try {
                multipartFile.transferTo(dest);
                user.setUser_head(temp);
                /*
                 * 确认user的user_id是存在的
                 * */
                test = userService.uploadHeadById(user);
            } catch (IllegalStateException | IOException e){
                e.printStackTrace();
            }
            if(test == 1){
                callback = new Gson().toJson(new UserJson(200,"success"));
            }else{
                callback = new Gson().toJson(new UserJson(500,"upload wrong,please retry"));
            }
        }
        return callback;
    }

    /*
    * 使用邮箱注册
    * @param user_mail,user_pwd,user_name
    * */
    @RequestMapping(value = "/mailRegister",method = RequestMethod.POST)
    public String userRegisterByMail(User user){
        int test = 0;
        String callback;
        try {
            test = userService.registerUserByMail(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(test == 1){
            callback = new Gson().toJson(new UserJson(200,"success"));
        }else{
            callback = new Gson().toJson(new UserJson(500,"current mail has been used"));
        }
        return callback;
    }

    /*
     * 使用phone注册
     * @param user_mail,user_pwd,user_name
     * */
    @RequestMapping(value = "/phoneRegister",method = RequestMethod.POST)
    public String userRegisterByPhone(User user){
        int test = 0;
        String callback;
        try {
            test = userService.registerUserByPhone(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(test == 1){
            callback = new Gson().toJson(new UserJson(200,"success"));
        }else{
            callback = new Gson().toJson(new UserJson(500,"current phone has been used"));
        }
        return callback;
    }

    /*
    * 使用用户的id修改掉登陆状态实现登出
    * @param user_id
    * */
    @RequestMapping(value = "/signOut",method = RequestMethod.POST)
    public String userSignOutById(User user){
        String callback;
        user.setUser_status(false);
        if(userService.signOut_updateStatusById(user) == 1){
            callback = new Gson().toJson(new UserJson(200,"success"));
        }else{
            callback =new Gson().toJson(new UserJson(500,"sign out wrong,please retry"));
        }
        return callback;
    }

    /*
    * 两种登陆方式的辅助
    * */
    private String loginHelp(User newUser){
        String callback;
        if(newUser!=null && !newUser.isUser_status()){
            newUser.setUser_status(true);
            if(userService.login_updateStatusById(newUser) == 1){
                callback = new Gson().toJson(new UserJson(200,"success",newUser));
            }else{
                callback = new Gson().toJson(new UserJson(500,"Login wrong，please retry"));
            }
        }else if(newUser!=null && newUser.isUser_status()){
            callback = new Gson().toJson(new UserJson(500,"current user have login"));
        }else {
            callback = new Gson().toJson(new UserJson(500,"no such user,please register before login"));
        }
        return callback;
    }

}
