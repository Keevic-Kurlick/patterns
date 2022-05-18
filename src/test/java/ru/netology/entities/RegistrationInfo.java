package ru.netology.entities;

import lombok.Data;

@Data
public class RegistrationInfo {
    private final String name;
    private final String phoneNumber;

    public RegistrationInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
