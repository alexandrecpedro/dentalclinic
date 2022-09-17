package br.com.dentalclinic.exception;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails {
    /** Attributes **/
    private String title;
    private String message;
    private LocalDateTime timestamp;
    private int status;
}
