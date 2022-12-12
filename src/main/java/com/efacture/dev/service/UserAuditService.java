package com.efacture.dev.service;

import java.util.Date;
import java.util.List;
import com.efacture.dev.model.UserAudite;

public interface UserAuditService {
	public UserAudite ajoutAuditUser(UserAudite user);
	public List <UserAudite> listAudit();
    public List<UserAudite> rechercheByLogin(String login);
    public List<UserAudite> rechercheByDateBetween(Date firstDate,Date lastDate);
    public List<UserAudite> rechercheByDate(Date firstDate);
    public List<UserAudite> rechercheAdit(Date firstDate,Date lastDate,String login,String nom,String statut);
    public List<UserAudite> rechercheAudit(String login,String nom,String role,String statut);
	List<UserAudite> rechercheNodate(String login, String nom, String statut);

}
