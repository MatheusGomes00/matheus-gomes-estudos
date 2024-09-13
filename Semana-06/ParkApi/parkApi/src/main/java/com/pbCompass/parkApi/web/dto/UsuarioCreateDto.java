package com.pbCompass.parkApi.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioCreateDto{
    /*  regexp -> expressão regular que substitui a padrão, no caso a validação do formato de email
        ^ -> indica que a quantidade de caracteres antes do @ deve ser ilimitada de tudo dentro do [].
        [a-z0-9.+-] -> letras de A a Z, numeros de 0 a 9, . + -
        depois do +@[] indica o que é aceito depois do @
        depois de +\\. indica o que é aceito depois do .
        [a-z]{2,}  -> apenas letras, no mínimo 2, máximo qualquer uma
     */
    @NotBlank  // não deve ser nulo e deve ter pelo menos 1 caracter
    @Email(message = "Formato de email invávlido.", regexp = "^[a-z0-9.+-]+@[a-z0-9.-]+\\.[a-z]{2,}$")
    private String username;

    @NotBlank
    @Size(min = 6, max = 6)
    private String password;
}
