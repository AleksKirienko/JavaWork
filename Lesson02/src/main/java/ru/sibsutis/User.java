package ru.sibsutis;

public abstract class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this(name);
        this.email = email;
    }

    public User(String name) {
        this.name = name;
    }

	public void setName(String name) {
        this.name = name;
    }

    protected String getName() {
    	return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    protected String getEmail(){
        return this.email;
    }

    @Override
    public abstract String toString();
}