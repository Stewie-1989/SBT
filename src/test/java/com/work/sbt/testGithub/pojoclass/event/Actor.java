package com.work.sbt.testGithub.pojoclass.event;;

public class Actor
{
    private String id;
    private String login;
    private String display_login;
    private String gravatar_id;
    private String url;
    private String avatar_url;

    public Actor() {
    }

    public Actor(String id, String login, String display_login, String gravatar_id, String url, String avatar_url) {
        this.id = id;
        this.login = login;
        this.display_login = display_login;
        this.gravatar_id = gravatar_id;
        this.url = url;
        this.avatar_url = avatar_url;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getDisplay_login() {
        return display_login;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setDisplay_login(String display_login) {
        this.display_login = display_login;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        return "Actor\n{" +
                "\nid='" + id + '\'' +
                ", \nlogin='" + login + '\'' +
                ", \ndisplay_login='" + display_login + '\'' +
                ", \ngravatar_id='" + gravatar_id + '\'' +
                ", \nurl='" + url + '\'' +
                ", \navatar_url='" + avatar_url + '\'' +
                '\n'+'}';
    }
}
