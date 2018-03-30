package by.erizo.domain.entity;

/**
 * Created by Erizo on 26.03.2018.
 */

public class Image {

    private String type;
    private String userName;

    public Image() {
    }

    public Image(String userName) {
        this.userName = userName;
    }

    public Image(String type, String userName) {
        this.type = type;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
