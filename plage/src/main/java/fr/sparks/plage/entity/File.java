package fr.sparks.plage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
public class File {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private byte numero;
    @NonNull
    @Range(min = 0, max = 50, message = "Le prix journalier doit être compris entre {min} et {max}")
    private double prixJournalier;

    @OneToMany(mappedBy = "file", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Parasol> parasols;
}
