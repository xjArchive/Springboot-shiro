package com.boot.shirojwt.controller;


import com.boot.shirojwt.mapper.UserMapper;
import com.boot.shirojwt.model.ResultMap;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: UserController
 * Description:
 * date: 2020/2/13 16:52
 *
 * @author xujin <br/>
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserMapper userMapper;
    private final ResultMap resultMap;

    @Autowired
    public UserController(UserMapper userMapper, ResultMap resultMap) {
        this.userMapper = userMapper;
        this.resultMap = resultMap;
    }

    /**
     * 拥有 user, admin 角色的用户可以访问下面的页面
     */
    @GetMapping("/getMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public ResultMap getMessage() {
        return resultMap.success().code(200).message("成功获得信息！");
    }

    @PostMapping("/updatePassword")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public ResultMap updatePassword(String username, String oldPassword, String newPassword) {
        String dataBasePassword = userMapper.getPassword(username);
        if (dataBasePassword.equals(oldPassword)) {
            userMapper.updatePassword(username, newPassword);
        } else {
            return resultMap.fail().message("密码错误！");
        }
        return resultMap.success().code(200).message("成功获得信息！");
    }

    /**
     * 拥有 vip 权限可以访问该页面
     */
    @GetMapping("/getVipMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    @RequiresPermissions("vip")
    public ResultMap getVipMessage() {
        return resultMap.success().code(200).message("成功获得 vip 信息！");
    }
}
