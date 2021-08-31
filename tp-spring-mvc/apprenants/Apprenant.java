package open.opendevup.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import org.springframework.format.annotation.DateTimeFormat;

/*import org.springframework.data.annotation.Id;
*/



@Entity
@Embeddable

public class Apprenant implements Serializable {
	@Id
	@GeneratedValue
	private Long idApprenant;

	@Valid
	@Column(name = "NOM", length = 30)
	@NotEmpty
	private String nom;
	@Valid
	@Column(name = "PRENOM", length = 30)
	private String prenom;
	private String photoApprenant;
	private String numerotel;
	private boolean etat;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	
	@NotEmpty
	@Email
	private String email;

	
	public Apprenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdApprenant() {
		return idApprenant;
	}
	public void setIdApprenant(Long idApprenant) {
		this.idApprenant = idApprenant;
	}
	public Apprenant(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}
	public Apprenant(String nom, Date dateNaissance, String email, String photoApprenant) {
		super();
		this.nom = nom;
		this.setDateNaissance(dateNaissance);
		this.setEmail(email);
		this.photoApprenant = photoApprenant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPhotoApprenant() {
		return photoApprenant;
	}
	public void setPhotoApprenant(String photoApprenant) {
		this.photoApprenant = photoApprenant;
	}
	public String getNumerotel() {
		return numerotel;
	}
	public void setNumerotel(String numerotel) {
		this.numerotel = numerotel;
	}
	public Long getidApprenant() {
		return idApprenant;
	}

	public void setidApprenant(Long idApprenant) {
		this.idApprenant = idApprenant;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	
}
