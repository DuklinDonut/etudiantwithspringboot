package open.opendevup.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Embeddable


public class Etudiant implements Serializable {
	/**
	 * private static final long serialVersionUID = 1L;
	 * 
	 */
	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	
	@Valid
	@Column(name = "NOM", length = 30)
	//sans name
	@NotEmpty
	// @Min(5)
	// @Max(30)
	// @Size(min = 5,max = 30)
	private String nom;
	// @NotEmpty
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	public String etat;
	@NotEmpty
	@Email
	//adresee mail identique
	private String email;

//private byte[] photo;
	private String photo;

//POUR JPA ET POUR MOI
	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}

//POUR MOI
	public Etudiant(String nom, Date dateNaissance, String email, String photo, String etat) {
		super();
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.photo = photo;
		this.etat= etat;
	}
  
	
	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
