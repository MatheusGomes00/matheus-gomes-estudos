package com.pb.atS7.SpringApi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntryDto {

    @NotBlank(message = "O nome não pode estar em branco")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "O nome deve conter apenas letras")
    private String name;

    @NotNull
    @Min(value = 0, message = "Idade precisa ser um inteiro positivo")
    private Integer age;
}
