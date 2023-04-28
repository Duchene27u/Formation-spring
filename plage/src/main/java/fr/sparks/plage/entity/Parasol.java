package fr.sparks.plage.entity;

import fr.sparks.plage.annotation.ParasolUniqueReservationSimultanement;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class Parasol {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private byte numEmplacement;

    @ManyToOne
    @NotNull
    @NonNull
    private File file;

    @ManyToMany(mappedBy = "parasols")
    private List<Reservation> reservations;

}
