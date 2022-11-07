package com.paramonga.ssff.exception;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@NoArgsConstructor
public class CustomUnsupportedMediaType extends RuntimeException {

    public CustomUnsupportedMediaType( String message ) {
        super( message ) ;
    }

}