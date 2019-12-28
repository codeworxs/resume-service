package com.codeworxs.resume.user;

public enum UserType{
	
    STANDARD(1),
    ADMIN(0);

    private final int id;

    UserType(final int newId) {
        id = newId;
    }

    public int getId() { return id; }
}
