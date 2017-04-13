package com.vlad.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vlad.model.Project;
import com.vlad.model.Utilisateur;
import com.vlad.tickets.dao.UtilisateurDAO;



@Service(value="utilisateurDAO")
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {
	
	@Autowired
	private UtilisateurDAO utilisateurDAO;
	
	@Override
	public void addUtilisateur(Utilisateur utilisateur) {
		utilisateurDAO.addUtilisateur(utilisateur);
		
	}
	
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		utilisateurDAO.updateUtilisateur(utilisateur);
		
	}

	@Override
	public Utilisateur getUtilisateur(int id) {
		return utilisateurDAO.getUtilisateur(id);
		
	}
	
	@Override
	public void deleteUtilisateur(int id) {
		utilisateurDAO.deleteUtilisateur(id);
		
	}
	
	@Override
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurDAO.getUtilisateurs();
		
	}
	

}
