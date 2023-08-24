package com.example.demolession5.deplookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class StudentServices {

    @Lookup
    public SchoolNotification getSchoolNotification() {
        return null;
    }
}
