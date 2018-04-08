package com.fanw.socialapp.controller;

import com.fanw.socialapp.Manager.JsoupManager;
import com.fanw.socialapp.model.Callback;
import com.fanw.socialapp.model.ImageModel;
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    @RequestMapping(value = "/list/{pageOffset}",method = RequestMethod.GET)
    public String getList(@PathVariable("pageOffset") int pageOffset){
        String callback;
        try {
            Document document = Jsoup.connect("https://www.dbmeinv.com/dbgroup/show.htm?pager_offset="+pageOffset).get();
            List<ImageModel> listTemp = new ArrayList<>();
            listTemp.addAll(JsoupManager.get(document).getImageDetail());
            callback = new Gson().toJson(new Callback(200,"success",listTemp));
        } catch (IOException e) {
            callback = new Gson().toJson(new Callback(500,"failed",new ArrayList<ImageModel>()));
            e.printStackTrace();
        }
        return callback;
    }
}
