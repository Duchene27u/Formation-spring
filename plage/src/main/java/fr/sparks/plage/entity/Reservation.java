package fr.sparks.plage.entity;

import fr.sparks.plage.annotation.DateDebutAvantDateFin;
import fr.sparks.plage.annotation.ReservationBetweenDates;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@DateDebutAvantDateFin
@ReservationBetweenDates
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @FutureOrPresent
    private LocalDate dateDebut;
    @Future
    private LocalDate dateFin;
    @Column(name = "montant_a_regler_en_eur")
    private double montantAReglerEnEuros;
    @Lob
    private String remarques;
    //@CreditCardNumber
    private String numeroCarte;
    @Range(min = 1,max = 12, message = "Doit être compris entre {min} et {max}")
    private int moisExpiration;
    private int anneeExpiration;
    private String cryptogramme;

    @ManyToOne
    private Client client;

    @ManyToMany
    private List<Parasol> parasols;

    @OneToOne
    private Statut statut;

    @ManyToOne
    private Concessionnaire concessionnaire;

}
