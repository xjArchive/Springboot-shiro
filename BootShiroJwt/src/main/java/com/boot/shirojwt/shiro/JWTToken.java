package com.boot.shirojwt.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * ClassName: JWTToken
 * Description:
 * date: 2020/2/14 22:04
 *
 * @author xujin <br/>
 * @since JDK 1.8
 */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
