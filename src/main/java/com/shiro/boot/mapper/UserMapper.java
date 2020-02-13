package com.shiro.boot.mapper;

import org.springframework.stereotype.Repository;

/**
 * ClassName: UserMapper
 * Description:
 * date: 2020/2/13 16:54
 *
 * @author xujin <br/>
 * @since JDK 1.8
 */
@Repository
public interface UserMapper {
    /**
     * 获得密码
     * @param username 用户名
     */
    String getPassword(String username);

    /**
     * 获得角色权限
     * @param username 用户名
     * @return user/admin
     */
    String getRole(String username);
}
