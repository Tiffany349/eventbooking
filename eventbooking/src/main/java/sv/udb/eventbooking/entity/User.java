package sv.udb.eventbooking.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;

    @NotBlank(message = "El username es obligatorio")
    @Column(nullable = false, unique = true)
    private String username;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false)
    private String firstname;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(nullable = false)
    private String lastname;

    @Min(value = 1, message = "La edad debe ser mayor a 0")
    private Integer age;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 4, message = "La contraseña debe tener al menos 4 caracteres")
    @Column(nullable = false)
    private String password;
<<<<<<< HEAD

    // NUEVO CAMPO
    @Column(nullable = false)
    private String role;
=======
>>>>>>> ce25f670b89a25dd008aea6d4aae2b8058309c49
}