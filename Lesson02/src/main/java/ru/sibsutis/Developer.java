package ru.sibsutis;

abstract class Developer extends User implements CSV {

    private String name;
    private String email;
    private String language;

    public Developer(String name, String email, String language) {
        super(name, email);
        this.language = language;
    }

    public Developer(String name, String language) {
        super(name);
        this.language = language;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

}