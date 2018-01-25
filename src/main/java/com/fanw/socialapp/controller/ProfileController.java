package com.fanw.socialapp.controller;


import com.fanw.socialapp.model.Profile;
import com.fanw.socialapp.model.ProfileJson;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.ProfileService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    /*
    * 注册用户的时候，创建与之对应的profile元组
    * @param user_id
    * */
    @RequestMapping(value = "/createProfile",method = RequestMethod.POST)
    public String createProfileByUserId(User user){
        String callback;
        int ret = 0;
        try {
            ret = profileService.createProfleByUserId(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ret == 1){
            callback = new Gson().toJson(new ProfileJson(200,"success"));
        }else{
            callback = new Gson().toJson(new ProfileJson(500,"profile create wrong,please wait for retry"));
        }
        return callback;
    }

    /*
    * 依靠user_id查询出相应的profile信息并且全部返回
    * @param user_id
    * */
    @RequestMapping(value = "/showProfile",method = RequestMethod.POST)
    public String showProfileByUserId(User user){
        String callback;
        Profile temp = new Profile();
        try {
            temp = profileService.showProFileByUserId(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(temp != null){
            callback = new Gson().toJson(new ProfileJson(200,"success",temp));
        }else {
            callback = new Gson().toJson(new ProfileJson(500,"get profile wrong,please wait for retry"));
        }
        return callback;
    }

    /*
    * 依靠profile_id查询出对应的profile元组，根据传来的profile的信息做判断来更新数据的内容
    * @param profile_id,profile_sign,profile_sex,profile_location
    * */
    @RequestMapping(value = "/updateProfile",method = RequestMethod.POST)
    public String updateProfileByProfileId(Profile profile){
        String callback;
        int ret = 0;
        try {
            ret = profileService.updateProfileById(profile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ret == 1){
            callback = new Gson().toJson(new ProfileJson(200,"success"));
        }else{
            callback = new Gson().toJson(new ProfileJson(500,"update profile wrong,please retry"));
        }
        return callback;
    }
}
