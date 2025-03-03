package com.dreamjournal.Dream_journal_api.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T>{
    private int status;
    private String message;
    private T data;

    public static <T> ResponseStructure<T> factory(HttpStatus status, String message, T data){
        ResponseStructure<T> response=new ResponseStructure<T>();
        response.status =status.value();
        response.message =message;
        response.data=data;
        return response;
    }
}
