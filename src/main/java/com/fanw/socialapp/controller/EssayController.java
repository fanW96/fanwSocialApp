package com.fanw.socialapp.controller;

import com.fanw.socialapp.model.Essay;
import com.fanw.socialapp.model.EssayJson;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.EssayService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/essay")
public class EssayController {

    @Autowired
    private EssayService essayService;

    /*
    * 获取全部的essay
    * */
    @RequestMapping(value = "/showAll")
    public String showAllEssays(){
        String callback;
        List<Essay> temp = new ArrayList<>();
        try {
            temp = essayService.showAllEssays();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(temp != null){
            callback = new Gson().toJson(new EssayJson(200,"success",temp));
        }else {
            callback =new Gson().toJson(new EssayJson(500,"no essays"));
        }
        return callback;
    }

    /*
    * 单独打开一条essay
    * @param essay_id
    * */
    @RequestMapping(value = "/showOne")
    public String showOneEssayById(Essay essay){
        String callback;
        Essay temp = new Essay();
        temp = essayService.showOneEssayById(essay);
        if(temp != null){
            callback = new Gson().toJson(new EssayJson(200,"success",temp));
        }else {
            callback = new Gson().toJson(new EssayJson(500,"open wrong,please retry"));
        }
        return callback;
    }

    /*
    * 获取一位用户的全部essay
    * @param user_id
    * */
    @RequestMapping(value = "/showOneUser")
    public String showOneUserEssays(User user){
        String callback;
        List<Essay> temp = new ArrayList<>();
        try {
            temp = essayService.showOneUserEssays(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(temp != null){
            callback = new Gson().toJson(new EssayJson(200,"success",temp));
        }else {
            callback =new Gson().toJson(new EssayJson(500,"no essays"));
        }
        return callback;
    }

    /*
    * 点赞
    * @param essay_id
    * */
    @RequestMapping(value = "/give")
    public String giveThumb(Essay essay){
        String callback;
        int temp = 0;
        temp = essayService.giveThumb(essay);
        if(temp == 1){
            callback = new Gson().toJson(new EssayJson(200,"success"));
        }else {
            callback = new Gson().toJson(new EssayJson(500,"give wrong,please retry"));
        }
        return callback;
    }

    /*
     *取消点赞
     * @param essay_id
     * */
    @RequestMapping(value = "/cancel")
    public String cancelThumb(Essay essay){
        String callback;
        int temp = 0;
        temp = essayService.cancelThumb(essay);
        if(temp == 1){
            callback = new Gson().toJson(new EssayJson(200,"success"));
        }else {
            callback = new Gson().toJson(new EssayJson(500,"cancel wrong,please retry"));
        }
        return callback;
    }

    /*
    * 删除一条essay
    * @param essay_id
    * */
    @RequestMapping(value = "/delete")
    public String deleteOneEssayById(Essay essay){
        String callback;
        int temp = 0;
        temp = essayService.deleteOneEssayById(essay);
        if(temp == 1){
            callback = new Gson().toJson(new EssayJson(200,"success"));
        }else {
            callback = new Gson().toJson(new EssayJson(500,"delete wrong,please retry"));
        }
        return callback;
    }

    /*
    * 发表一条essay
    * @param essay_content,essay_pic_count,essay_user_id,essay_pic_1,essay_pic_2,essay_pic_3
    * */
    @RequestMapping(value = "/create")
    public String createOneEssay(Essay essay){
        String callback;
        int temp = 0;
        temp = essayService.createOneEssay(essay);
        if(temp == 1){
            callback = new Gson().toJson(new EssayJson(200,"success"));
        }else {
            callback = new Gson().toJson(new EssayJson(500,"create wrong,please retry"));
        }
        return callback;
    }


}
