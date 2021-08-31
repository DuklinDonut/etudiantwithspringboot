package open.opendevup.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Date;
import java.util.List;



import open.opendevup.entities.Apprenant;


public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
	public List<Apprenant> findByNom(String n);

	public Page<Apprenant> findByNom(String n, Pageable pageable);

	@Query("select p from Apprenant p where p.nom like :x")
	public Page<Apprenant> chercherApprenant(@Param("x") String mc /* mot cle */, Pageable pageable);

	@Query("select p from Etudiant p where p.dateNaissance > :x and p.dateNaissance < :y ")
	public Page<Apprenant> chercherApprenant(@Param("x") Date d1, @Param("y") Date d2, Pageable pageable);



}
