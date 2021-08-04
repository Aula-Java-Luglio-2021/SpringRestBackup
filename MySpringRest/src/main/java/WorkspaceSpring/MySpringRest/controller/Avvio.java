package WorkspaceSpring.MySpringRest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import WorkspaceSpring.MySpringRest.model.Utente;
import WorkspaceSpring.MySpringRest.repository.RepoUtente;

@RestController
@RequestMapping("/utente")
public class Avvio {
	@Autowired
	RepoUtente ru; //Ho iniettato un oggetto(istanziato da Spring) di classe anonima che implementa un interfaccia RepoUtente
	
	@RequestMapping(value="inserimento", method=RequestMethod.POST)
	public String inserimento(Utente u) {//Applico il databinding(Ovvero Spring passa un oggetto creato da lui già riempito con i valori 
										//provenienti da un form
		ru.save(u);
		return "Inserimento riuscito";
	}
	@RequestMapping(value="modifica", method=RequestMethod.POST)
	public String modifica(Utente u) {
		ru.save(u);
		return "Modifica riuscito";
	}
	@RequestMapping(value="rimuovi", method=RequestMethod.GET)
	public String rimuovi(Integer id) {
		ru.deleteById(id);
		return "Rimozione riuscita";
	}
	@RequestMapping(value="leggi", method=RequestMethod.GET)
	public String leggi(int id) {
		return ru.findById(id).toString();
	}
	@RequestMapping(value="searchall", method=RequestMethod.GET)
	public List<Utente> leggitutto() {
		return ru.findAll();
	}
	@RequestMapping(value="puppolo", method=RequestMethod.POST)
	public List<Utente> leggiMod(String nome, String cognome){
		List <Utente> lista = new ArrayList<Utente>();
		lista.addAll(ru.findByNomeAndCognome(nome, cognome));
		return lista;	
	}
	@RequestMapping(value="searchnomeiniz", method=RequestMethod.POST)
	public List<Utente> getUtente1(String iniziale) {
		return ru.findJPLnomeIniziale(iniziale);
	}
	@RequestMapping(value="searchnomeinter", method=RequestMethod.POST)
	public List<Utente> getUtente2(String inter) {
		return ru.findJPLnomeIntermedio(inter);
	}
	@RequestMapping(value="searchnomefina", method=RequestMethod.POST)
	public List<Utente> getUtente3(String finale) {
		return ru.findJPLnomeFinale(finale);
	}
}
