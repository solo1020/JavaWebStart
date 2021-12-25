package com.itcast.controller;

import com.itcast.domain.MybatisUser;
import com.itcast.domain.ValueObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @ClassName RequestDataController
 * @description: 获取请求参数
 * @author: isquz
 * @time: 2021/11/28 1:04
 */
@Controller
public class RequestDataController {

    @RequestMapping(value = "/uploadFiles")
    @ResponseBody
    public void uploadFiles (String filename, MultipartFile[] upload) throws IOException {
        System.out.println("start to upload file : " + filename);
        System.out.println("get multipartFile: " + upload);
        for(MultipartFile file : upload){
            String originalFilename = file.getOriginalFilename();
            file.transferTo(new File( "D:\\J2EE\\JavaWeb\\testupload\\" + originalFilename));
        }
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public void upload (String filename, MultipartFile upload,
                        HttpServletRequest request) throws IOException {
        System.out.println("start to upload file : " + filename);
        System.out.println("get multipartFile: " + upload);
        String originalFilename = upload.getOriginalFilename();

        upload.transferTo(new File( "D:\\saveUpload.png"));
    }

    @RequestMapping(value = "/getCookie")
    @ResponseBody
    public void getCookie(@CookieValue(value = "JSESSIONID") String jsessionId){
        System.out.println("get request cookie jsessionId: " + jsessionId);
    }

    @RequestMapping(value = "/getRequestHeader")
    @ResponseBody
    public void getRequestHeader(@RequestHeader(value = "User-Agent", required = false) String userAgent){
        System.out.println("get request header User-Agent: " + userAgent);
    }


    @RequestMapping(value = "/getServletAPI")
    @ResponseBody
    public void getServletAPI(HttpServletRequest request, HttpServletResponse response,
                              HttpSession session){
        System.out.println("get servlet HttpServletRequest: " + request);
        System.out.println("get servlet HttpServletResponse: " + response);
        System.out.println("get servlet HttpSession: " + session);
    }

    @RequestMapping(value = "/paramConvertor")
    @ResponseBody
    public void paramConvertor(Date date){
        System.out.println("convertor data: " + date);
    }

    /**
     * @description: Restful风格请求
     * @param: username
     * @return: void
     * @author: isquz
     * @date: 2021/12/1 0:49
     */  
    @RequestMapping(value = "/reqRestful/{username}", method = RequestMethod.GET)
    @ResponseBody
    public void requestRestful(@PathVariable(value = "username") String username){
        System.out.println("requestRestful mapping path to variable -- username: " + username);
    }

    /**
     * @description: 请求参数映射：
     *
     * 将@RequestParam("name"） name ----- 此处的name 必须与实际请求参数的名称一致
     * 和 方法形参名 username 进行映射对应
     *
     *
     * @param: username
     * @return: void
     * @author: isquz
     * @date: 2021/11/30 23:51
     */
    @RequestMapping("reqParamMapping")
    @ResponseBody
    public void requestParamMapping(
            @RequestParam(
                    value = "name",
                    defaultValue = "default"
            ) String username){
        System.out.println("reqeustParamMapping username: " + username);
    }

    @RequestMapping("ajaxReq")
    @ResponseBody
    public void getRequestAjaxCollection(@RequestBody List<MybatisUser> userList){
        System.out.println(userList);
    }


    @RequestMapping("requestParamCollection")
    @ResponseBody
    public void getRequestParamCollection(ValueObject object){
        System.out.println(object);
        for(MybatisUser user: object.getUserList()){
            System.out.println("user inside ValueObject: " + user);
        }
    }

    @RequestMapping("requestParamArray")
    @ResponseBody
    public void getRequestParamArray(String[] arr){
        for(String s: arr){
            System.out.println("get param: " + s);
        }
    }

    @RequestMapping("requestParamToPojo")
    @ResponseBody
    public void getRequestParamToPojoObject(MybatisUser user){
        System.out.println("user: " + user);
    }


    /**
     * @description: 获取基本类型参数 直接把request域中参数名对应一致的放在方法参数中即可
     * @ResponseBody 表明只进行数据回写不进行页面跳转
     * 当前方法中返回值为void 即表示 本方法的response body为空
     * @param:
     * @return: void
     * @author: isquz
     * @date: 2021/11/28 1:06
     */
    @RequestMapping("requestParam")
    @ResponseBody
    public void getRequestParam(String username, int age){
        System.out.println("get username: " + username);
        System.out.println("get age: " + age);
    }



}
