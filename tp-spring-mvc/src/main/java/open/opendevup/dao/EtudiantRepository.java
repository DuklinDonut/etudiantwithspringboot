package open.opendevup.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;


import open.opendevup.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long > {
	public List<Etudiant> findByNom(String n);

	public Page<Etudiant> findByNom(String n, Pageable pageable);

	@Query("select e from Etudiant e where e.nom like :x")
	public Page<Etudiant> chercherEtudiant(@Param("x") String mc /* mot cle */, Pageable pageable);

	@Query("select e from Etudiant e where e.dateNaissance > :x and e.dateNaissance < :y ")
	public Page<Etudiant> chercherEtudiant(@Param("x") Date d1, @Param("y") Date d2, Pageable pageable);
	
	

}
