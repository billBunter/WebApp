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
    
    private static AccountController instance;
    private Account account;
    private SessionManager sessionManager;
    
    private AccountController(){
    }
    
    public static AccountController getInstanz(){
        if (AccountController.instance == null){
            AccountController.instance = new AccountController();
        }
        return AccountController.instance;
    }
    
    public boolean isRegistered(){
        if (account != null){
            return true;
        }
        return false;
    }
    
    public String getRights(){
        return account.getRechte();
    }
    
    public void setAccount(Account acc){
        sessionManager = new SessionManager();
        account = acc;
    }
    
    public void loggOff(){
        sessionManager = null;
        account = null;
    }
    
    public Account getAccount(){
        return account;
    }
    
    public void addToHistory(String url){
        sessionManager.addToHistory(url);
    }
    
}
