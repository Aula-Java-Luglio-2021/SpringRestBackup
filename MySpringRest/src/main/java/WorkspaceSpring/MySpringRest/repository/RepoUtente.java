package WorkspaceSpring.MySpringRest.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import WorkspaceSpring.MySpringRest.model.Utente;

public interface RepoUtente extends JpaRepository <Utente, Integer> {
	public Utente findById(int id);
	public Utente findBycodiceFisc(String codiceFisc);
	public List<Utente> findByNomeAndCognome(String nome, String cognome);
	@Query("from Utente where nome=?1 and cognome=?2")
	public Utente findJPLnomeANDcognome(String nome, String cognome); //JPL=Java Persistance Language
	@Query("from Utente where nome like :iniziale%")
	public List<Utente> findJPLnomeIniziale(@Param("iniziale")String iniziale);
	@Query("from Utente where nome like %:intermedio%")
	public List<Utente> findJPLnomeIntermedio(@Param("intermedio")String intermedio);
	@Query("from Utente where nome like %:finale")
	public List<Utente> findJPLnomeFinale(@Param("finale")String finale);
}
