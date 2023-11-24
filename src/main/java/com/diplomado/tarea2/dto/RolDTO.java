package com.diplomado.tarea2.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RolDTO {
    private  Integer id;
    @NotBlank(message = "El nombre es requerido")
    private String name;

}