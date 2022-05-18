package ru.netology.entities;

import lombok.Data;

@Data
public class RegistrationData {
    private final String name;
    private final String phoneNumber;

    public RegistrationData(String name, String phoneNumber) {
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
