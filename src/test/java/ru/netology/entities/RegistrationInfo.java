package ru.netology.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class GeneratorByName {
    private final String name;
    private final String phoneNumber;
}
