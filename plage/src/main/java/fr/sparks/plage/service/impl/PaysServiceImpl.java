package fr.sparks.plage.service.impl;

import fr.sparks.plage.dao.PaysDao;
import fr.sparks.plage.dto.PaysDto;
import fr.sparks.plage.entity.Pays;
import fr.sparks.plage.exception.PaysInexistantException;
import fr.sparks.plage.mapper.PaysMapper;
import fr.sparks.plage.service.PaysService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PaysServiceImpl implements PaysService {

	private final PaysDao paysDao;
	private final PaysMapper paysMapper;

	@Override
	public Pays enregistrerPays(String code, String nom) {
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
		Pays pays = paysDao.findByCode(code);
		if (pays != null) {
			pays.setNom(nouveauNom);
			return paysDao.save(pays);
		} else {
			throw new PaysInexistantException("Pays inexistant");
		}
	}

	@Override
	public boolean supprimerPays(String code) {
		Pays pays = paysDao.findById(code).orElse(null);
		if (pays == null) {
			return false;
		}
		paysDao.delete(pays);
		return true;
	}

}
