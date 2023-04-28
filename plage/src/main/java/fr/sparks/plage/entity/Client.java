package fr.sparks.plage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.sparks.plage.annotation.DixHuitAnsOuPlus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@DiscriminatorValue("customer")
public class Client extends Utilisateur{

    private LocalDateTime dateHeureInscription;

    @NotNull(message = "Merci de renseigner votre pays")
    @ManyToOne
    private Pays pays;

    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Reservation> reservations;

    @ManyToOne
    private LienDeParente lienDeParente;

    @NotNull(message = "Merci de préciser une date de naissance")
    @DixHuitAnsOuPlus
    private LocalDate dateNaissance;
}
