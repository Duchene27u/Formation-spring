package fr.sparks.plage.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TypeUtilisateur")
public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UtilisateurSequence")
    @SequenceGenerator(name = "UtilisateurSequence")
    protected Long id;
    @NotBlank
    protected String nom;
    @NotBlank
    protected String prenom;
    @Email(regexp = "^(.+)@(.+)$", message = "L'adresse mail n'est pas au bon format")
    @Column(unique = true, nullable = false)
    protected String email;
    @NotNull
    protected String mdp;
}
