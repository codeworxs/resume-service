package com.codeworxs.resume.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter @Setter
@Primary
@Scope("singleton")
public class PropertyConfig {
  

}

