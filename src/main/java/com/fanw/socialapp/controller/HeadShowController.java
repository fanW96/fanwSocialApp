package com.fanw.socialapp.controller;

import com.fanw.socialapp.util.StaticName;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Paths;

@Api("图片显示相关Api")
@RestController
@RequestMapping(value = "/head")
public class HeadShowController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public HeadShowController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{fileName:.+}")
    @ApiOperation("获取图片")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "fileName",dataType = "String")
    })
    @ApiResponses({
            @ApiResponse(code = 200,message = "success"),
            @ApiResponse(code = 500,message = "fail")
    })
    public ResponseEntity<?> getFile(@PathVariable String fileName) {

        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(StaticName.headSavePath,fileName).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
