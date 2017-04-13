package com.vlad.tickets.service;

import java.util.List;

import com.vlad.model.Project;
import com.vlad.model.Utilisateur;

public interface UtilisateurService {
	public void addUtilisateur(Utilisateur utilisateur);
	public void updateUtilisateur(Utilisateur utilisateur);
	public Utilisateur getUtilisateur(int id);
	public void deleteUtilisateur(int id);
	public List<Utilisateur> getUtilisateurs();

}
