package com.randstad.tondeuse.traitement;
import static org.fest.assertions.Assertions.assertThat;


import com.randstad.tondeuse.model.Params;
import com.randstad.tondeuse.model.Pelouse;
import com.randstad.tondeuse.service.traitement.FormaterLigne;
import com.randstad.tondeuse.model.Coordonnees;
import org.junit.Test;
public class FormaterLigneTest {

	@Test
	public void formater_ligne_tondeuse() {
		assertThat(FormaterLigne.formaterLigneTondeuse("10 15 N").getCoordonneesTondeuse()).isEqualTo(new Coordonnees(10, 15));
		assertThat(FormaterLigne.formaterLigneTondeuse("10 15 N").getOrientationTondeuse()).isEqualTo(Params.Orientation.NORTH);
	}

	@Test
	public void formater_ligne_pelouse() {
		assertThat(FormaterLigne.formaterLignePelouse("10 15")).isEqualTo(new Pelouse(new Coordonnees(10, 15)));
	}

	@Test
	public void formater_ligne_instruction() {
		assertThat(FormaterLigne.formaterLigneInstruction("DGAD")).hasSize(4)
				.contains(Params.InstructionTondeuse.DROITE)
				.contains(Params.InstructionTondeuse.GAUCHE)
				.contains(Params.InstructionTondeuse.AVANCER);
	}

	@Test
	public void recuperer_orientation() {
		assertThat(FormaterLigne.getOrientation('E')).isEqualTo(Params.Orientation.EAST);
		assertThat(FormaterLigne.getOrientation('N')).isEqualTo(Params.Orientation.NORTH);
		assertThat(FormaterLigne.getOrientation('S')).isEqualTo(Params.Orientation.SOUTH);
		assertThat(FormaterLigne.getOrientation('W')).isEqualTo(Params.Orientation.WEST);
		assertThat(FormaterLigne.getOrientation('a')).isNull();
	}

	@Test
	public void testGetInstruction() {
		assertThat(FormaterLigne.getInstruction('A')).isEqualTo(Params.InstructionTondeuse.AVANCER);
		assertThat(FormaterLigne.getInstruction('D')).isEqualTo(Params.InstructionTondeuse.DROITE);
		assertThat(FormaterLigne.getInstruction('G')).isEqualTo(Params.InstructionTondeuse.GAUCHE);
		assertThat(FormaterLigne.getInstruction(' ')).isNull();
	}

}
