package fr.sparks.plage.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fr.sparks.plage.business.Client;
import fr.sparks.plage.dto.ClientDto;

public interface ClientService {

	Client enregistrerClient(Client client);
	
	Client enregistrerClient(ClientDto clientDto);
	
	// Page est une interface de Spring Data
	Page<Client> recupererClients(Pageable pageable);

	boolean supprimerClient(Long id);

}
