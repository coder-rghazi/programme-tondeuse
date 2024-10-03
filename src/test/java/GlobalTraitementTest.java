import static org.fest.assertions.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.randstad.tondeuse.ExceptionTondeuse;


import com.randstad.tondeuse.model.Params;
import com.randstad.tondeuse.service.GlobalTraitement;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GlobalTraitementTest {
	final String CHEMIN_FICHIER = "./src/test/resources/";
	GlobalTraitement instance = new GlobalTraitement();
	protected static List<String> listResultats;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();


	@Test
	public void main_fichier_erreur_fichier_inexistant() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_FICHIER_INEXISTANT);
		File file = new File("fichierinexistant");
		instance.lancerTraitementsTondeuses(file);
	}
	
	@Test
	public void main_fichier_erreur_1_ligne() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_DONNEES_INCORRECTES);
		File file = new File(CHEMIN_FICHIER + "fichier_ligne_1.txt");
		instance.lancerTraitementsTondeuses(file);
	}
	
	@Test
	public void main_fichier_erreur_2_lignes() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_DONNEES_INCORRECTES);
		File file = new File(CHEMIN_FICHIER +  "fichier_ligne_2.txt");
		instance.lancerTraitementsTondeuses(file);
	}
	@Test
	public void main_fichier_erreur_ligne_manquante() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_DONNEES_INCORRECTES);
		File file = new File(CHEMIN_FICHIER + "fichier_ligne_manquante.txt");
		instance.lancerTraitementsTondeuses(file);
	}
	@Test
	public void main_fichier_erreur_fichier_vide() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_DONNEES_INCORRECTES);
		File file = new File(CHEMIN_FICHIER +"fichier_vide.txt");
		instance.lancerTraitementsTondeuses(file);

	}
	
	@Test
	public void main_fichier_erreur_fichier_xebia_ko() throws ExceptionTondeuse, IOException {
		expectedEx.expect(ExceptionTondeuse.class);
		expectedEx.expectMessage(Params.ERREUR_DONNEES_INCORRECTES);
		File file = new File(CHEMIN_FICHIER + "fichier_ko.txt");
		instance.lancerTraitementsTondeuses(file);
	}
	
	@Test
	public void main_fichier_erreur_fichier_xebia() throws ExceptionTondeuse, IOException {
		File file = new File(CHEMIN_FICHIER + "fichier_ok.txt");
		listResultats = instance.lancerTraitementsTondeuses(file);
		assertThat(listResultats).isNotNull();
		assertThat(listResultats).hasSize(2).contains("1 3 N").contains("5 1 E");
		
	}
}