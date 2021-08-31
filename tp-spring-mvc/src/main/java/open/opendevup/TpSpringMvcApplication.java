package open.opendevup;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import open.opendevup.dao.EtudiantRepository;
import open.opendevup.entities.Etudiant;

@SpringBootApplication
public class TpSpringMvcApplication {

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext ctx=SpringApplication.run(TpSpringMvcApplication.class, args);
		EtudiantRepository etudiantRepository=
				ctx.getBean(EtudiantRepository.class);
		DateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		etudiantRepository.save( 
				new Etudiant("fati",df.parse("1988-11-10"),"f@gmail.com",
						"fati.jpg","refusé"));
		
		etudiantRepository.save( 
				new Etudiant("hanane",df.parse("1988-11-10"),"h@gmail.com",
						"hanane.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("bouchra",df.parse("1988-11-10"),"b@gmail.com",
						"bouchra.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("basma",df.parse("1988-11-10"),"b@gmail.com",
						"basma.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("ines",df.parse("1988-11-10"),"i@gmail.com",
						"ines.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("youssef",df.parse("1988-11-10"),"y@gmail.com",
						"youssef.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("ilham",df.parse("1988-11-10"),"i@gmail.com",
						"ilham.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("fati",df.parse("1988-11-10"),"f@gmail.com",
						"fati.jpg","refusé"));
		
		etudiantRepository.save( 
				new Etudiant("hanane",df.parse("1988-11-10"),"h@gmail.com",
						"hanane.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("bouchra",df.parse("1988-11-10"),"b@gmail.com",
						"bouchra.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("basma",df.parse("1988-11-10"),"b@gmail.com",
						"basma.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("ines",df.parse("1988-11-10"),"i@gmail.com",
						"ines.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("youssef",df.parse("1988-11-10"),"y@gmail.com",
						"youssef.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("ilham",df.parse("1988-11-10"),"i@i.com",
						"ilham.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("fati",df.parse("1988-11-10"),"f@f.com",
						"fati.jpg","refusé"));
		
		etudiantRepository.save( 
				new Etudiant("hanane",df.parse("1988-11-10"),"h@h.com",
						"hanane.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("bouchra",df.parse("1988-11-10"),"b@b.com",
						"bouchra.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("basma",df.parse("1988-11-10"),"b@b.com",
						"basma.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("ines",df.parse("1988-11-10"),"i@i.com",
						"ines.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("youssef",df.parse("1988-11-10"),"y@y.com",
						"youssef.jpg","refusé"));
		etudiantRepository.save( 
				new Etudiant("ilham",df.parse("1988-11-10"),"i@i.com",
						"ilham.jpg","refusé"));
		
		//Page<Etudiant> etds=etudiantRepository.findAll( PageRequest.of(0,5));
		Page<Etudiant> etds=etudiantRepository.chercherEtudiant("%a%", PageRequest.of(0,5));


		etds.forEach(e->System.out.println(e.getNom()));
		
		
		
		
	}

}
