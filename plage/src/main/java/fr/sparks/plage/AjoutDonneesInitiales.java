package fr.sparks.plage;

import com.github.javafaker.Faker;
import fr.sparks.plage.dao.ClientDao;
import fr.sparks.plage.dao.ConcessionnaireDao;
import fr.sparks.plage.dao.FileDao;
import fr.sparks.plage.dao.LienDeParenteDao;
import fr.sparks.plage.dao.ParasolDao;
import fr.sparks.plage.dao.PaysDao;
import fr.sparks.plage.dao.StatutDao;
import fr.sparks.plage.entity.Client;
import fr.sparks.plage.entity.Concessionnaire;
import fr.sparks.plage.entity.File;
import fr.sparks.plage.entity.LienDeParente;
import fr.sparks.plage.entity.Parasol;
import fr.sparks.plage.entity.Pays;
import fr.sparks.plage.entity.Statut;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

    private final FileDao fileDao;
    private final ParasolDao parasolDao;
    private final PaysDao paysDao;
    private final LienDeParenteDao lienDeParenteDao;
    private final ConcessionnaireDao concessionnaireDao;
    private final StatutDao statutDao;
    private final ClientDao clientDao;
    private static final Random random = new Random();
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        ajouterFiles();
        ajouterParasols();
        ajouterPays();
        ajouterLiensDeParente();
        ajouterClients(500);
        ajouterConcessionnaire();
        ajouterStatuts();

        //TODO: Demande de page
        Pageable pageable = PageRequest.of(0, 5);
        Page<Client> page= clientDao.findAll(pageable);
        System.out.println(page.getNumber());
        System.out.println(page.getPageable().next());
    }

    private void ajouterStatuts() {
        if (statutDao.count() == 0) {
            statutDao.saveAll(Arrays.asList(new Statut("en attente de traitement"), new Statut("acceptée"),
                    new Statut("refusée")));
        }
    }

    private void ajouterFiles() {
        // On teste si des files sont dÃ©jÃ  en base
        if (fileDao.count() == 0) {
            // il n'y a pas encore de files en base, on ajoute 8 files
            double prixJournalier = 20;
            for (byte i = 1; i <= 8; i++) {
                fileDao.save(new File(i, prixJournalier));
                prixJournalier -= 2;
            }
        }
    }

    private void ajouterParasols() {
        if (parasolDao.count() == 0) {
            List<File> files = fileDao.findAll();
            for (File file : files) {
                for (byte i = 0; i <= 7; i++) {
                    parasolDao.save(new Parasol(i, file));
                }
            }
        }
    }

    private void ajouterPays() {
        if (paysDao.count() == 0) {
            paysDao.saveAll(Arrays.asList(new Pays("FR", "France"), new Pays("IT", "Italie"),
                    new Pays("GB", "Royaume-Uni"), new Pays("PT", "Portugal")));
        }
    }

    private void ajouterLiensDeParente() {
        if (lienDeParenteDao.count() == 0) {
            lienDeParenteDao.save(new LienDeParente("Aucun", 1f));
            lienDeParenteDao.save(new LienDeParente("Frère/Soeur", 0.5f));
            lienDeParenteDao.save(new LienDeParente("Cousin/Cousine", 0.75f));
        }
    }

    private void ajouterClients(int nbClientsAAjouter) {
        if (clientDao.count() == 0) {

            // Partie dÃ©clarative
            List<Pays> pays = paysDao.findAll();
            LienDeParente lienDeParenteAucun = lienDeParenteDao.findAll().get(0);
            Map<String, Client> map = new HashMap<>();
            Calendar calendar = Calendar.getInstance();
            Faker faker = new Faker(Locale.FRENCH);

            // Partie traitement
            while (map.size() != nbClientsAAjouter) {
                Client client = Client.builder()
                        .nom(faker.name().lastName())
                        .prenom(faker.name().firstName())
                        .pays(pays.get(random.nextInt(pays.size())))
                        .email(faker.internet().emailAddress())
                        .lienDeParente(lienDeParenteAucun)
                        .mdp(passwordEncoder.encode(String.valueOf(random.nextInt(99999999) + 10000000)))
                        .dateNaissance(LocalDate.of(2000,1,1))
                        .build();

                calendar.set(2020, 1, 1);
                Date dateDebut = calendar.getTime();
                calendar = Calendar.getInstance();
                Date dateFin = calendar.getTime();
                Date dateAleatoire = faker.date().between(dateDebut, dateFin);
                calendar.setTime(dateAleatoire);
                LocalDateTime dateHeureInscription = dateAleatoire.toInstant().atZone(ZoneId.systemDefault())
                        .toLocalDateTime();
                client.setDateHeureInscription(dateHeureInscription);
                map.put(client.getEmail(), client);
            }
            clientDao.saveAll(map.values());
            System.out.print("nb de clients ajoutés:" + map.size() + "\n");

        }

    }

    private void ajouterConcessionnaire() {
        if (concessionnaireDao.count() == 0) {
            Concessionnaire concessionnaire = new Concessionnaire();
            concessionnaire.setNom("ROSSI");
            concessionnaire.setPrenom("Giuseppe");
            concessionnaire.setEmail("peppe@sparks.fr");
            concessionnaire.setMdp("12345678");
            concessionnaire.setNumTelephone("+3912345678");
            concessionnaireDao.save(concessionnaire);
        }
    }
}
