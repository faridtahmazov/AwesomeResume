package com.company.resumewebapp.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    @PreAuthorize("hasRole('ADMIN')") // bu methodu yalniz admin cagira biler
    public void foo(){
        System.out.println("Foo method");
    }
}
