package com.shiro.boot.exception;

/**
 * ClassName: AccountException
 * Description:
 * date: 2020/2/13 17:40
 *
 * @author xujin <br/>
 * @since JDK 1.8
 */
public class AccountException extends Exception {

    public AccountException(String message) {
        super(message);
    }

    public AccountException() {
    }
}
