package fr.sparks.plage.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.sparks.plage.business.Pays;
import fr.sparks.plage.dao.PaysDao;
import fr.sparks.plage.dto.PaysDto;
import fr.sparks.plage.exception.PaysExistantException;
import fr.sparks.plage.exception.PaysInexistantException;
import fr.sparks.plage.mapper.PaysMapper;
import fr.sparks.plage.service.PaysService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaysServiceImpl implements PaysService {

	private final PaysDao paysDao;
	private final PaysMapper paysMapper;

	@Override
	public Pays ajouterPays(PaysDto paysDto) {
		if (paysDao.findById(paysDto.getCode()).isPresent()) {
			throw new PaysExistantException("Ce pays est déjà présent en base");
		}
		return enregistrerPays(paysDto);
	}

	@Override
	public Pays ajouterPays(String code, String nom) {
		return enregistrerPays(new Pays(code, nom));
	}
	
	@Override
	public Pays enregistrerPays(Pays pays) {
		return paysDao.save(pays);
	}
	
	@Override
	public Pays enregistrerPays(PaysDto paysDto) {
		Pays pays = paysMapper.toEntity(paysDto);
		return enregistrerPays(pays);
	}

	@Override
	public List<Pays> recupererPays() {
		return paysDao.findAll();
	}

	@Override
	public Pays recupererPays(String code) {
		return paysDao.findByCode(code);
	}

	@Override
	public Pays mettreAJour(String code, String nouveauNom) {
		Pays pays = paysDao.findById(code).orElseThrow(() -> new PaysInexistantException("Pays inexistant"));
		pays.setNom(nouveauNom);
		return paysDao.save(pays);
	}

	@Override
	public boolean supprimerPays(String code) {
		Pays pays = paysDao.findById(code).orElseThrow(() -> new PaysInexistantException("Pays inexistant"));
		paysDao.delete(pays);
		return true;
	}

}
