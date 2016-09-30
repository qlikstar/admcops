package com.citrix.hackathon.ansible;

/**
 * Created by sanketmishra on 9/26/16.
 */
public class Playbook {

    private String playBookName;

    private String playBookPermission;

    private String playBookOwner;

    private String playBookGroup;

    private String playBookSize;

    private String playbookLstModifiedTime;

    public String getPlayBookName() {
        return playBookName;
    }

    public void setPlayBookName(String playBookName) {
        this.playBookName = playBookName;
    }

    public String getPlayBookPermission() {
        return playBookPermission;
    }

    public void setPlayBookPermission(String playBookPermission) {
        this.playBookPermission = playBookPermission;
    }

    public String getPlayBookOwner() {
        return playBookOwner;
    }

    public void setPlayBookOwner(String playBookOwner) {
        this.playBookOwner = playBookOwner;
    }

    public String getPlayBookGroup() {
        return playBookGroup;
    }

    public void setPlayBookGroup(String playBookGroup) {
        this.playBookGroup = playBookGroup;
    }

    public String getPlayBookSize() {
        return playBookSize;
    }

    public void setPlayBookSize(String playBookSize) {
        this.playBookSize = playBookSize;
    }

    public String getPlaybookLstModifiedTime() {
        return playbookLstModifiedTime;
    }

    public void setPlaybookLstModifiedTime(String playbookLstModifiedTime) {
        this.playbookLstModifiedTime = playbookLstModifiedTime;
    }

    public Playbook(String playBookName, String playBookPermission, String playBookOwner, String playBookGroup, String playBookSize, String playbookLstModifiedTime) {
        this.playBookName = playBookName;
        this.playBookPermission = playBookPermission;
        this.playBookOwner = playBookOwner;
        this.playBookGroup = playBookGroup;
        this.playBookSize = playBookSize;
        this.playbookLstModifiedTime = playbookLstModifiedTime;
    }

    public Playbook() {
    }

    @Override
    public String toString() {
        return "Playbook{" +
                "playBookName='" + playBookName + '\'' +
                ", playBookPermission='" + playBookPermission + '\'' +
                ", playBookOwner='" + playBookOwner + '\'' +
                ", playBookGroup='" + playBookGroup + '\'' +
                ", playBookSize='" + playBookSize + '\'' +
                ", playbookLstModifiedTime='" + playbookLstModifiedTime + '\'' +
                '}';
    }
}
