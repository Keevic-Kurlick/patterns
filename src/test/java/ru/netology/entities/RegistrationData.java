package ru.netology.entities;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class RegistrationData {
    String name;
    String phoneNumber;
    String city;
}
