package controller;

import model.FTPConnect;

public class FTPReadyDemon extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (Center.getBP() != null) {
                if (!FTPConnect.isFTPConn()&&FTPConnect.isFTPon()) {
                    Center.getBP().getBigTextPanel().getButtonTextPanel().getButton().setEnabled(false);
                }else {
                    Center.getBP().getBigTextPanel().getButtonTextPanel().getButton().setEnabled(true);
                }
            }
        }
    }
}
