package com.work.sbt.testGithub.pojoclass.repository;

public class Owner
{
    private String login;
    private String id;
    private String avatar_url;
    private String gravatar_id;
    private String url;
    private String html_url;
    private String followers_url;
    private String following_url;
    private String gists_url;
    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
    private String events_url;
    private String received_events_url;
    private String type;
    private Boolean site_admin;

    public Owner()
    { }

    public Owner(String login, String id, String avatar_url, String gravatar_id, String url, String html_url, String followers_url, String following_url, String gists_url, String starred_url, String subscriptions_url, String organizations_url, String repos_url, String events_url, String received_events_url, String type, Boolean site_admin) {
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
        this.gravatar_id = gravatar_id;
        this.url = url;
        this.html_url = html_url;
        this.followers_url = followers_url;
        this.following_url = following_url;
        this.gists_url = gists_url;
        this.starred_url = starred_url;
        this.subscriptions_url = subscriptions_url;
        this.organizations_url = organizations_url;
        this.repos_url = repos_url;
        this.events_url = events_url;
        this.received_events_url = received_events_url;
        this.type = type;
        this.site_admin = site_admin;
    }


    public String getLogin() {
        return login;
    }
    public String getId() {
        return id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getGravatar_id() {
        return gravatar_id;
    }

    public String getUrl() {
        return url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public String getFollowing_url() {
        return following_url;
    }

    public String getGists_url() {
        return gists_url;
    }

    public String getStarred_url() {
        return starred_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getReceived_events_url() {
        return received_events_url;
    }

    public String getType() {
        return type;
    }

    public Boolean getSite_admin() {
        return site_admin;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setGravatar_id(String gravatar_id) {
        this.gravatar_id = gravatar_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }

    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }

    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSite_admin(Boolean site_admin) {
        this.site_admin = site_admin;
    }

    @Override
    public String toString() {
        return "Owner\n{" +
                "  \nlogin ='" + login + '\'' +
                "  \nid ='" + id + '\'' +
                ", \navatar_url = '" + avatar_url + '\'' +
                ", \ngravatar_id = '" + gravatar_id + '\'' +
                ", \nurl = '" + url + '\'' +
                ", \nhtml_url = '" + html_url + '\'' +
                ", \nfollowers_url = '" + followers_url + '\'' +
                ", \nfollowing_url = '" + following_url + '\'' +
                ", \ngists_url = '" + gists_url + '\'' +
                ", \nstarred_url = '" + starred_url + '\'' +
                ", \nsubscriptions_url = '" + subscriptions_url + '\'' +
                ", \norganizations_url = '" + organizations_url + '\'' +
                ", \nrepos_url = '" + repos_url + '\'' +
                ", \nevents_url = '" + events_url + '\'' +
                ", \nreceived_events_url = '" + received_events_url + '\'' +
                ", \ntype = '" + type + '\'' +
                ", \nsite_admin = " + site_admin +
                '\n' + '}';
    }


}