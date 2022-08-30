package com.mitra.minhasfinancas.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table ( name = "usuario", schema = "financas")
// Data is used to generate getters, setters, hashCode, equals, toString and constructors
@Data
// Builder is similar to a constructor, useful in some situations
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    // Atrributes + Mapping
    @Id
    @Column(name = "id")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;
}
