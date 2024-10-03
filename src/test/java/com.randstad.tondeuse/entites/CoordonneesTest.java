package com.randstad.tondeuse.entites;
import static org.fest.assertions.Assertions.assertThat;

import com.randstad.tondeuse.model.Coordonnees;
import org.junit.Test;

public class CoordonneesTest {

	@Test
	public void verifier_surcharge_equals(){
		Coordonnees c1 = new Coordonnees(1, 2);
		Coordonnees c2 = new Coordonnees(1, 2);
		assertThat(c1.equals(c2)).isTrue();
		c2 = new Coordonnees(1, 3);
		assertThat(c1.equals(c2)).isFalse();
	}
	
	@Test
	public void verifier_coordonnees_(){
		Coordonnees coordonneesPelouse = new Coordonnees(5,5);
		Coordonnees c0 = new Coordonnees(-1,1);
		Coordonnees c1 = new Coordonnees(1,1);
		assertThat(coordonneesPelouse.isHorsCoordonnesMax(c0)).isFalse();
		assertThat(coordonneesPelouse.isHorsCoordonnesMax(c1)).isTrue();
	}
}
