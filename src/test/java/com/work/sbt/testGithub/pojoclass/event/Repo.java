package com.work.sbt.testGithub.pojoclass.event;

public class Repo
{
    private String id;
    private String name;
    private String url;

    public Repo() {
    }

    public Repo(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Repo\n{" +
                "\nid='" + id + '\'' +
                ", \nname='" + name + '\'' +
                ", \nurl='" + url + '\'' +
                '\n'+'}';
    }
}
