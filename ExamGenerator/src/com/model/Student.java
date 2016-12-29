package com.model;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = -583708688076110211L;
	private String name;
    private String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}