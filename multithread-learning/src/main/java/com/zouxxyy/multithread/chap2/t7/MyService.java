package com.zouxxyy.multithread.chap2.t7;

public class MyService {
    public MyList addServiceMethod(MyList list, String data) {
        try {
            if(list.getSize() < 1) {
                Thread.sleep(2000);
                list.add(data);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
