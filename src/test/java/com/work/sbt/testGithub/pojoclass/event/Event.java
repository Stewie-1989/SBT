package com.work.sbt.testGithub.pojoclass.event;;

public class Event
{

    private String id;
    private String type;
    private Actor actor;
    private Repo repo;
    private Payload payload;
    private Boolean Public;
    private String created_at;

    public Event() {
    }

    public Event(String id, String type, Actor actor, Repo repo, Payload payload, Boolean aPublic, String created_at) {
        this.id = id;
        this.type = type;
        this.actor = actor;
        this.repo = repo;
        this.payload = payload;
        Public = aPublic;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Actor getActor() {
        return actor;
    }

    public Repo getRepo() {
        return repo;
    }

    public Payload getPayload() {
        return payload;
    }

    public Boolean getPublic() {
        return Public;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setRepo(Repo repo) {
        this.repo = repo;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public void setPublic(Boolean aPublic) {
        Public = aPublic;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Event\n{" +
                "\nid = '" + id + '\'' +
                ", \ntype = '" + type + '\'' +
                ", \nactor = " + actor.toString() +
                ", \nrepo = " + repo.toString() +
                ", \npayload = " + payload.toString() +
                ", \nPublic = " + Public +
                ", \ncreated_at = '" + created_at + '\'' +
                '\n'+'}';
    }
}

