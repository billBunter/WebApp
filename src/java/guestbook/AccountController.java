/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guestbook;

import guestbook.pojo.Account;

/**
 *
 * @author Billy
 */
public class AccountController {
    
    private Account account;
    private boolean existiert = false;
    
    protected AccountController(){
        existiert = true;
    }
    
    public AccountController getAccountController(){
        if (existiert){
            return this;
        } else {
            return new AccountController();
        }
    }
    
}
