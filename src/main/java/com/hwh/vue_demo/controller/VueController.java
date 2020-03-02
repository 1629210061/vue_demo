package com.hwh.vue_demo.controller;

import com.hwh.vue_demo.entity.Token;
import com.hwh.vue_demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description TODO
 * @Author hwh
 * @Date 2020/2/25 12:48
 **/
@RestController
@CrossOrigin(origins = "*")
public class VueController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getToken")
    public Token getToken(@RequestBody Token token){
        token.setToken(UUID.randomUUID().toString().replaceAll("-",""));
        return token;
    }

    @RequestMapping("/getNav")
    public String getNav(){
        String nav = "{\"data\":[{\"id\":1,\"authwame\":\"用户管理\",\"path\":\"/user\",\"children\":[{\"id\":11,\"authlame\":\"用户列表\",\"path\":\"/user\",\"children\":[]}]},{\"id\":2,\"authwame\":\"权限管理\",\"path\":\"/jurisdiction\",\"children\":[{\"id\":21,\"authlame\":\"权限列表\",\"path\":\"/jurisdiction\",\"children\":[]}]},{\"id\":3,\"authwame\":\"商品管理\",\"path\":null,\"children\":[{\"id\":31,\"authlame\":\"用户列表\",\"path\":null,\"children\":[]}]},{\"id\":4,\"authwame\":\"订单管理\",\"path\":null,\"children\":[{\"id\":41,\"authlame\":\"用户列表\",\"path\":null,\"children\":[]}]},{\"id\":5,\"authwame\":\"数据统计\",\"path\":null,\"children\":[{\"id\":51,\"authlame\":\"用户列表\",\"path\":null,\"children\":[]}]}],\"meta\":{\"msg\":\"获取菜单列表成功\",\"status\":200}}";
        return nav;
    }


}
