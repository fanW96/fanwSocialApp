package com.fanw.socialapp.Manager;

import com.fanw.socialapp.model.ImageModel;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class JsoupManager {
    private Document document;

    private JsoupManager(Document document){
        this.document = document;
    }

    public static JsoupManager get(Document document) {
        return new JsoupManager(document);
    }

    public List<ImageModel> getImageList(){
        List<ImageModel> modelList = new ArrayList<>();
        ImageModel imageModel;
        Elements a = document.select("div.img_single").select("a");
        for (Element element : a){
            imageModel = new ImageModel();
            imageModel.url = element.select("imh[class]").attr("src");
            imageModel.detailUrl = element.select("a[class]").attr("href");
            modelList.add(imageModel);
        }
        return modelList;
    }

    public List<ImageModel> getImageDetail(){
        List<ImageModel> list = new ArrayList<>();
        ImageModel imageDetailModel;
        Elements img = document.select("div.panel-body").select("img");
        for (Element element : img){
            imageDetailModel = new ImageModel();
            imageDetailModel.url = element.select("img[src]").attr("src");
            list.add(imageDetailModel);
        }
        return list;
    }
}
