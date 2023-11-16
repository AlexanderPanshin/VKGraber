package model;

public enum Props {
    IS_AVTO_SAVE ("Is_avto_save"),
    VK_URL ("Vk_url"),
    PATH_IMG ("Path_img"),
    PATH_TXT("Path_txt"),
    IS_FTP_ON ("Is_ftp_on"),
    PATH_FTP ("Path_FTP"),
    LOGIN_FTP ("Login_ftp"),
    PASSWORD_FTP ("Password_FTP"),
    DOMAIN_FTP ("Domain_FTP"),
    TEXT_EDITOR ("Text_editor"),
    IS_CREATED_FOLDER("Is_created_folder");


    private String title;

    Props(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
