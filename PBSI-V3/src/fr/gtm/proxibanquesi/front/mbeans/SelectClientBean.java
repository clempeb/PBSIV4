package fr.gtm.proxibanquesi.front.mbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.service.IClientService;

/**
 * Managed Bean charg� de la s�lection d'un client dans la liste.
 * 
 * @author Alex
 *
 */
@ManagedBean(name = "clientBean")
@ViewScoped
public class SelectClientBean implements Serializable {

	// Serial ID
	/**
	 * Serial ID.
	 */
	private static final long serialVersionUID = 1L;

	// Bean attributes
	/**
	 * Propri�t� stockant le client s�lectionn�.
	 */
	private Client selectedClient;

	// Service injection
	// @Inject
	// IClientService serv;

	// Constructor
	//
	// public SelectClientBean() {
	// }

	// Bean lifecycle log
	// @PostConstruct
	// public void creationBean() {
	// System.out.println("Cr�ation SelectClientBean: " + selectedClient);
	// }
	// @PreDestroy
	// public void destructionBean() {
	// System.out.println("Destruction SelectClientBean");
	// }

	// Getters & Setters
	/**
	 * Getter de la propri�t� selectedClient.
	 * 
	 * @return La propri�t� selectedClient.
	 */
	public Client getSelectedClient() {
		return selectedClient;
	}

	/**
	 * Setter de la propri�t� selectedClient.
	 * 
	 * @param selectedClient
	 *            Le client � affecter � la propri�t�.
	 */
	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
		System.out.println(selectedClient);
	}
}
