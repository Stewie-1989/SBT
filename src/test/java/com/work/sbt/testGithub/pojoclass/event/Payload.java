package com.work.sbt.testGithub.pojoclass.event;;

public class Payload
{
    private String ref;
    private String ref_type;
    private String master_branch;
    private String description;
    private String pusher_type;


    public Payload() {
    }

    public Payload(String ref, String ref_type, String master_branch, String description, String pusher_type) {
        this.ref = ref;
        this.ref_type = ref_type;
        this.master_branch = master_branch;
        this.description = description;
        this.pusher_type = pusher_type;
    }

    public String getRef() {
        return ref;
    }

    public String getRef_type() {
        return ref_type;
    }

    public String getMaster_branch() {
        return master_branch;
    }

    public String getDescription() {
        return description;
    }

    public String getPusher_type() {
        return pusher_type;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setRef_type(String ref_type) {
        this.ref_type = ref_type;
    }

    public void setMaster_branch(String master_branch) {
        this.master_branch = master_branch;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPusher_type(String pusher_type) {
        this.pusher_type = pusher_type;
    }

    @Override
    public String toString() {
        return "Payload\n{" +
                "\nref='" + ref + '\'' +
                ", \nref_type='" + ref_type + '\'' +
                ", \nmaster_branch='" + master_branch + '\'' +
                ", \ndescription='" + description + '\'' +
                ", \npusher_type='" + pusher_type + '\'' +
                '\n'+'}';
    }
}
