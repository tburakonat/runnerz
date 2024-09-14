package com.tburakonat.runnerz.user;

public record Address(
        String street,
        String suite,
        String city,
        String zipCode,
        Geo geo
) {
}
