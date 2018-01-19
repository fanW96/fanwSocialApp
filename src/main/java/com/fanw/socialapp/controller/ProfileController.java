package com.fanw.socialapp.controller;


import com.fanw.socialapp.model.Profile;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.ProfileService;
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
    * */
    @RequestMapping(value = "/createProfile",method = RequestMethod.POST)
    public String createProfileByUserId(User user){
        int ret = 0;
        try {
            ret = profileService.createProfleByUserId(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ret == 1){
            return "success";
        }
        return "fail";
    }
    /*
    * 依靠user_id查询出相应的profile信息并且全部返回
    * */
    @RequestMapping(value = "/showProfile",method = RequestMethod.POST)
    public String showProfileByUserId(User user){
        return profileService.showProFileByUserId(user).toString();
    }
    /*
    * 依靠profile_id查询出对应的profile元组，根据传来的profile的信息做判断来更新数据的内容
    * */
    @RequestMapping(value = "/updateProfile",method = RequestMethod.POST)
    public String updateProfileByProfileId(Profile profile){
        int ret = 0;
        try {
            ret = profileService.updateProfileById(profile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ret == 1){
            return "success";
        }
        return "fail";
    }
}
