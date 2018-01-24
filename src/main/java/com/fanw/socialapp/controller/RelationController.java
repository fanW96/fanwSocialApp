package com.fanw.socialapp.controller;


import com.fanw.socialapp.model.Relation;
import com.fanw.socialapp.model.RelationJson;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.RelationService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/relation")
public class RelationController {

    @Autowired
    private RelationService relationService;


    /*
    * 提供用户的id获得粉丝数
    * @param user_id
    * */
    @RequestMapping(value = "/fansCount",method = RequestMethod.POST)
    public int getFansCount(User user){
        int temp = 0;
        try {
            temp = relationService.getFansCount(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    /*
     * 提供用户的id获得关注数
     * @param user_id
     * */
    @RequestMapping(value = "/upsCount",method = RequestMethod.POST)
    public int getUpsCount(User user){
        int temp = 0;
        try {
            temp = relationService.getUpsCount(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    /*
    * 提供relation中的up_id和fan_id，创建新的关注与被关注的关系
    * @param up.user_id,fan.user_id
    * */
    @RequestMapping(value = "/follow",method = RequestMethod.POST)
    public String createFollow(Relation relation){
        int temp = 0;
        try {
            temp = relationService.createFollow(relation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(temp ==1){
            return "success";
        }
        return "fail";
    }

    /*
    * 提供relation中的up_id和fan_id唯一确定某一行，删除本行，实现取消关注的效果
    * @param up.user_id,fan.user_id
    * */
    @RequestMapping(value = "/cancelFollow",method = RequestMethod.POST)
    public String cancelFollow(Relation relation){
        int temp = 0;
        try {
            temp = relationService.cancelFollow(relation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(temp ==1){
            return "success";
        }
        return "fail";
    }

    /*
    * 使用用户的user_id来查询出全部的fans的user的全部信息
    * @param user_id
    * */
    @RequestMapping(value = "/showAllFans",method = RequestMethod.POST)
    public String showAllFans(User user){
        List<Relation> temp = null;
        String callback = new String();
        try {
            temp = relationService.showAllFans(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        String result = null;
//        if(temp != null){
//            for (Relation r:temp) {
//                result += r.toFansString();
//            }
//        }
        if(temp != null){
            callback = new Gson().toJson(new RelationJson(200,"success",temp));
        }
        return callback;
    }

    /*
     * 使用用户的user_id来查询出全部的ups的user的全部信息
     * @param user_id
     * 返回json
     * */
    @RequestMapping(value = "/showAllUps",method = RequestMethod.POST)
    public String showAllUps(User user){
        List<Relation> temp = new ArrayList<>();
        try {
            temp = relationService.showAllUps(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String result = new String();
        if(temp != null){
            for (Relation r:temp) {
                result += r.toUpsString();
            }
        }
        return result;
    }
}
