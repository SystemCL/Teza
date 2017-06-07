package com.vlad.tickets.dao;

import java.util.List;

import com.vlad.model.UserRole;
import com.vlad.model.Utilisateur;


public interface UtilisateurDAO {
	
	public void addUtilisateur(Utilisateur utilisateur);
	public void updateUtilisateur(Utilisateur utilisateur);
	public Utilisateur getUtilisateur(int id);
	public void deleteUtilisateur(int id);
	public List<Utilisateur> getUtilisateurs();
}
