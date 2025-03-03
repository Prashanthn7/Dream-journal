package com.dreamjournal.Dream_journal_api.util;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class FieldErrorResponse extends SimpleErrorResponse{

    private List<CustomFieldError> errors;

    public static CustomFieldError createFieldError(String message,Object rejectedValue,String field){
        CustomFieldError error = new CustomFieldError();
        error.message = message;
        error.field = field;
        error.rejectedValue = rejectedValue;
        return error;
    }

    @Getter
    public static class CustomFieldError{
        private String message;
        private Object rejectedValue;
        private String field;

    }
}
