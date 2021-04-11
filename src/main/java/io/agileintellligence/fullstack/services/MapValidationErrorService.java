package io.agileintellligence.fullstack.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Service
public class MapValidationErrorService {

    public ResponseEntity<?> MapValidationErrorService(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> mp = new HashMap<String, String>();
            for (FieldError error : result.getFieldErrors()) {
                mp.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(mp, HttpStatus.BAD_REQUEST);
        }
        return null;
    }
}
