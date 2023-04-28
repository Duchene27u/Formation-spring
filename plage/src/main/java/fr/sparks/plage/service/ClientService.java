package fr.sparks.plage.service;

import fr.sparks.plage.dto.ClientDto;
import fr.sparks.plage.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

	Client enregistrerClient(Client client);
	
	Client enregistrerClient(ClientDto clientDto);
	
	// Page est une interface de Spring Data
	Page<Client> recupererClients(Pageable pageable);

	boolean supprimerClient(Long id);

}
