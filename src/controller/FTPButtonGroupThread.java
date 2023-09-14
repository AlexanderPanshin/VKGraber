package controller;

import model.FTPConnect;

public class FTPButtonGroupThread {
    public void startThread() {
        FTPReadyDemon ftpReadyDemon = new FTPReadyDemon();
        ftpReadyDemon.setDaemon(true);
        ftpReadyDemon.start();
        Thread controlThread = new Thread(() -> {
            while (true) {
                if (Center.getBfp() != null && Center.getBfp().getFtpPanel1() != null && Center.getBfp().getFtpPanel1().getOn() != null) {

                    if (Center.getBfp().getFtpPanel1().getOn().isSelected()) {
                        Center.getBfp().getFtpPanel2().getPathFtp().setEnabled(true);
                        Center.getBfp().getFtpPanel3().getLoginFtp().setEnabled(true);
                        Center.getBfp().getFtpPanel4().getPass().setEnabled(true);
                        Center.getBfp().getFtpPanel5().getDomainFTP().setEnabled(true);
                        Center.getBfp().getFtpPanel6().getSave().setEnabled(true);
                        Center.getBfp().getFtpPanel6().getConnectStatus().setFocusable(true);
                        FTPConnect.setIsFTPon(true);
                    } else {
                        Center.getBfp().getFtpPanel2().getPathFtp().setEnabled(false);
                        Center.getBfp().getFtpPanel3().getLoginFtp().setEnabled(false);
                        Center.getBfp().getFtpPanel4().getPass().setEnabled(false);
                        Center.getBfp().getFtpPanel5().getDomainFTP().setEnabled(false);
                        Center.getBfp().getFtpPanel6().getSave().setEnabled(false);
                        Center.getBfp().getFtpPanel6().getConnectStatus().setFocusable(false);
                        FTPConnect.setIsFTPon(false);
                    }
                }
            }
        });
        controlThread.setDaemon(true);
        controlThread.start();


    }
}
