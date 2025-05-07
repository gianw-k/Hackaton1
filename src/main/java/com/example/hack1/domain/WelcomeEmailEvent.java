package com.example.hack1.domain;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class WelcomeEmailEvent extends ApplicationEvent {
    final private String email;
    final private String name;

    public WelcomeEmailEvent(Object source, String email, String name) {
        super(source);
        this.email = email;
        this.name = name;
    }

}
