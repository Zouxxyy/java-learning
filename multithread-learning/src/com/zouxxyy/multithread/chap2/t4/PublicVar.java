package com.zouxxyy.multithread.chap2.t4;

public class PublicVar {
    private String username = "A";
    private String password = "AA";
    synchronized public void setValue(String username, String password) {
        try{
            this.username = username;
            Thread.sleep(5000);
            this.password = password;
            System.out.println("setValue method name=" + Thread.currentThread().getName() + " username ="
                    + username + " password=" + password);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getValue() {
        System.out.println("getValue method name=" + Thread.currentThread().getName() + " username ="
                + username + " password=" + password);
    }
}
