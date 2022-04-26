/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.account.ultil;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Thanh Sang
 */
public class EncryptedPasswordUtil {
    public static void main(String[] args) {
        String password = "123";
        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
        System.out.println("Encrypted Password: "+crypt.encode(password));
    }
}
