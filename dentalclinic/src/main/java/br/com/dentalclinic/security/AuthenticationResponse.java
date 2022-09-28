package br.com.dentalclinic.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthenticationResponse {
    /** Attribute **/
    private final String jwt;
}
