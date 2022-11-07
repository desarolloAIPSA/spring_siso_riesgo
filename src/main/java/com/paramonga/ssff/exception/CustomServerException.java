package com.paramonga.ssff.exception;


import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@NoArgsConstructor
public class CustomServerException extends RuntimeException {

    public CustomServerException( String message ) {
        super( message ) ;
    }

}
