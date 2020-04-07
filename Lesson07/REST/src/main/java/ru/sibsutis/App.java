package ru.sibsutis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//POJO (Plain Old Java Object)
class User {

    public User() {
    }

    public User(Integer id, String fio, String phone) {
        this.id = id;
        this.fio = fio;
        this.phone = phone;
    }

    private Integer id;
    private String fio;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

public class App {
    static public void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User(1, "Ivan", "900");
        String str = mapper.writeValueAsString(user);
        System.out.println(str);

        User user2 = mapper.readValue(str, User.class);
        System.out.println(user2.getFio());
    }
}
