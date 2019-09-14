package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class ListController {
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String upload(){

        return "salemessage";
    }

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpSession httpSession){

        String filename = file.getOriginalFilename();
        System.out.println(filename);

//        String path = httpSession.getServletContext().getRealPath("files");
        String path = "C:\\Users\\10842\\Desktop\\CrazyApeFiles";
        System.out.println(path);
        File file1 = new File(path);

        try {
            file.transferTo(new File(path+"/"+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "salemessage";
    }
}
