package com.boot.shirojwt.controller;

import com.boot.shirojwt.mapper.UserMapper;
import com.boot.shirojwt.model.ResultMap;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
    private final UserMapper userMapper;
    private final ResultMap resultMap;

    @Autowired
    public AdminController(UserMapper userMapper, ResultMap resultMap) {
        this.userMapper = userMapper;
        this.resultMap = resultMap;
    }

    @GetMapping("/getUser")
    @RequiresRoles("admin")
    public ResultMap getUser() {
        List<String> list = userMapper.getUser();
        return resultMap.success().code(200).message(list);
    }

    /**
     * 封号操作
     */
    @PostMapping("/banUser")
    @RequiresRoles("admin")
    public ResultMap updatePassword(String username) {
        userMapper.banUser(username);
        return resultMap.success().code(200).message("成功封号！");
    }
}
