package com.fanw.socialapp.controller;

import com.fanw.socialapp.model.Essay;
import com.fanw.socialapp.model.EssayJson;
import com.fanw.socialapp.model.User;
import com.fanw.socialapp.service.EssayService;
import com.fanw.socialapp.util.StaticName;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/essay")
public class EssayController {

    @Autowired
    private EssayService essayService;

    /*
    * 获取全部的essay
    * @PathVariable请求动态参数
    * */
    @RequestMapping(value = "/showAll/{pageNum}/{pageSize}",method = RequestMethod.GET)
    public String showAllEssays(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        String callback;
        List<Essay> temp = new ArrayList<>();
        try {
            temp = essayService.showAllEssays(pageNum,pageSize);
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
    @RequestMapping(value = "/showOne",method = RequestMethod.POST)
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
    @RequestMapping(value = "/showOneUser/{pageNum}/{pageSize}",method = RequestMethod.POST)
    public String showOneUserEssays(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize,User user){
        String callback;
        List<Essay> temp = new ArrayList<>();
        try {
            temp = essayService.showOneUserEssays(pageNum,pageSize,user);
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
    @RequestMapping(value = "/give",method = RequestMethod.POST)
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
    @RequestMapping(value = "/cancel",method = RequestMethod.POST)
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
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
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
    * @param essay_content,essay_pic_count,user.user_id,pic_1,pic_2,pic_3
    * */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createOneEssay(Essay essay, @RequestParam("pic_1")MultipartFile pic_1, @RequestParam("pic_2")MultipartFile pic_2, @RequestParam("pic_3")MultipartFile pic_3){
        String callback;
        int temp = 0;
        /*
        * essay.setEssay_date(new Date());
        * 在数据库中设置了直接夺取当前时间
        * */
        if(!pic_1.isEmpty()){
            String pic_1_temp = getNewFileName(pic_1,essay.getUser().getUser_id());
            essay.setEssay_pic_1(pic_1_temp);
        }
        if(!pic_2.isEmpty()){
            String pic_2_temp = getNewFileName(pic_2,essay.getUser().getUser_id());
            essay.setEssay_pic_2(pic_2_temp);
        }
        if(!pic_3.isEmpty()){
            String pic_3_temp = getNewFileName(pic_3,essay.getUser().getUser_id());
            essay.setEssay_pic_3(pic_3_temp);
        }
        temp = essayService.createOneEssay(essay);
        if(temp == 1){
            callback = new Gson().toJson(new EssayJson(200,"success"));
        }else {
            callback = new Gson().toJson(new EssayJson(500,"create wrong,please retry"));
        }
        return callback;
    }

    /*
    * 发表一条essay
    * @param essay_content,essay_pic_count,user.user_id,pic_1
    * */

    /*
    * 发表一条essay
    * @param essay_content,essay_pic_count,user.user_id,pic_1,pic_2
    * */

    public String getNewFileName(MultipartFile pic,int id){
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String pic_filename = pic.getOriginalFilename();
        String pic_suffix = pic_filename.substring(pic_filename.lastIndexOf(".")+1);
        String pic_temp = id+df.format(new Date())+(int)(Math.random()*100)+"."+pic_suffix;
        File pic_dest = new File(StaticName.picSavePath,pic_temp);
        if(!pic_dest.getParentFile().exists()){
            pic_dest.getParentFile().mkdirs();
        }
        try {
            pic.transferTo(pic_dest);
            return pic_temp;
        } catch (IllegalStateException | IOException e){
            e.printStackTrace();
            return null;
        }

    }


}
