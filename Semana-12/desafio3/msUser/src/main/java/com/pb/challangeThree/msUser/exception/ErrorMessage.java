package com.pb.challangeThree.msUser.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import java.util.Map;

@NoArgsConstructor
@Getter
@ToString
public class ErrorMessage {

    private String path;

    private String method;

    private int status;

    private String statusText;

    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)  // only includes if the field is not null
    private Map<String, String> errors;

    public ErrorMessage(HttpServletRequest request, HttpStatus status, String message) {
        this.path = request.getRequestURI();
        this.method = request.getMethod();
        this.status = status.value();
        this.statusText = status.getReasonPhrase();
        this.message = message;
    }


}
