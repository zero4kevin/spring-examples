package com.zero4kevin.spring.examples.jms.models;

import java.io.Serializable;

/**
 * Created by kevin on 7/1/18.
 */
public class Hunter implements Serializable{
    private String name;
    private Skills skill;
    private Ranks rank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skills getSkill() {
        return skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    public Ranks getRank() {
        return rank;
    }

    public void setRank(Ranks rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Hunter{" +
                "name='" + name + '\'' +
                ", skill=" + skill +
                ", rank=" + rank +
                '}';
    }
}
