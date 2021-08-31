package open.opendevup.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.plaf.multi.MultiButtonUI;
import javax.validation.Valid;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.MediaType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import open.opendevup.dao.ApprenantRepository;
import open.opendevup.dao.EtudiantRepository;
import open.opendevup.entities.Apprenant;
import open.opendevup.entities.Etudiant;

@Controller

@RequestMapping(value="/Apprenant")
public class ApprenantController {
	@Autowired
	private ApprenantRepository apprenantRepository;
	private EtudiantRepository etudiantRepository;
    
	@Value("${dir.images}")
	private String imageDir;
	
	@RequestMapping(value="/Index")
	public String Index(Model model, 
			@RequestParam(name="page",defaultValue="0")int p,
			@RequestParam(name="motCle",defaultValue="")String mc) {
		Page<Apprenant> pageApprenants=apprenantRepository.
				chercherApprenant(/* "%"+ */mc+"%",PageRequest.of(p , 20));
		int pagesCount=pageApprenants.getTotalPages();
		int[] pages=new int[pagesCount];
		for(int i=0;i<pagesCount;i++) pages[i]=i;
		model.addAttribute("pages",pages);
		model.addAttribute("pageApprenants",pageApprenants);
		model.addAttribute("pageCourante",p);
		model.addAttribute("motCle", mc);
		
		
		return "apprenants"; 
	}
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String formApprenant(Model model) {
		model.addAttribute("apprenant",new Apprenant());
		return "FormPourEtudiant";
	}
	
	@RequestMapping(value="/SaveApprenant",method=RequestMethod.POST)
	public String save(@Valid Apprenant ap,@Valid Etudiant et ,
			BindingResult bindingResult,
			@RequestParam(name="picture")MultipartFile file) throws Exception {
		if(bindingResult.hasErrors()) {
			return "FormPourEtudiant";
		}
		if(!(file.isEmpty())) { ap.setPhotoApprenant(file.getOriginalFilename());}
		apprenantRepository.save(ap);
		
		if(!(file.isEmpty())) {
			System.out.println("-----------------------------");
			System.out.println(file.getOriginalFilename());
			ap.setPhotoApprenant(file.getOriginalFilename());
			//file.transferTo(new File(imageDir+file.getOriginalFilename()));
			file.transferTo(new File("C:/Users/FATIMA EZZAHRA MAJID/sco/"+ap.getIdApprenant()));
		}
		
		
		return "redirect:Index";
	}
	
	@RequestMapping(value="/getPhoto",
			produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long idApprenant) throws Exception {
		File f=new File("C:/Users/FATIMA EZZAHRA MAJID/sco/"+idApprenant);
		return IOUtils.toByteArray(new FileInputStream(f));
		
	}

	
	  @RequestMapping(value="/edit") public String edit(Long id,Model model) {
	  Apprenant ap =apprenantRepository.getOne(id);
	  model.addAttribute("apprenant",ap); return "EditApprenant"; }
	 
	
	/*
	 * @RequestMapping (value="/isEtat",method=RequestMethod.POST) public boolean
	 * update(@Valid Apprenant ap, BindingResult bindingResult) {
	 * 
	 * if(ap.isEtat()==false) { ap.setEtat(true); } return ap.isEtat(); }
	 */
	
	

		@RequestMapping(value="/UpdateApprenant",method=RequestMethod.POST)
		public String update(@Valid Apprenant ap,
				BindingResult bindingResult,
				@RequestParam(name="picture")MultipartFile file) throws Exception {
			if(bindingResult.hasErrors()) {
				return "EditApprenant";
			}
			if(!(file.isEmpty())) { ap.setPhotoApprenant(file.getOriginalFilename());}
			apprenantRepository.save(ap);
			
			
			if(!(file.isEmpty())) {
				System.out.println("-----------------------------");
				System.out.println(file.getOriginalFilename());
				ap.setPhotoApprenant(file.getOriginalFilename());
				//file.transferTo(new File(imageDir+file.getOriginalFilename()));
				file.transferTo(new File("C:/Users/FATIMA EZZAHRA MAJID/sco/"+ap.getIdApprenant()));
			}
			
	  
	  return "redirect:Index"; }
	 

	
}