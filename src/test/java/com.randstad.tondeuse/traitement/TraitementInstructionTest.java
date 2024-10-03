package com.randstad.tondeuse.traitement;

import static org.fest.assertions.Assertions.assertThat;
import com.randstad.tondeuse.ExceptionTondeuse;
import com.randstad.tondeuse.model.Coordonnees;
import com.randstad.tondeuse.model.Params.InstructionTondeuse;
import com.randstad.tondeuse.model.Params.Orientation;
import com.randstad.tondeuse.model.PositionTondeuse;

import com.randstad.tondeuse.service.traitement.TraitementInstruction;
import org.junit.Test;


public class TraitementInstructionTest {

	@Test
	public void coordonnees_x_y_south_instruction_Tourner_Droite() throws ExceptionTondeuse {
		Coordonnees coordonnesMax = new Coordonnees(5, 5);
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.SOUTH);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.WEST);
	}
	
	
	@Test
	public void pivoter_a_droite() throws ExceptionTondeuse{
		
		Orientation orientationSuivante = TraitementInstruction.pivoterDroite(Orientation.EAST);
		assertThat(orientationSuivante).isEqualTo(Orientation.SOUTH);
		
		orientationSuivante = TraitementInstruction.pivoterDroite(Orientation.WEST);
		assertThat(orientationSuivante).isEqualTo(Orientation.NORTH);
		
		orientationSuivante = TraitementInstruction.pivoterDroite(Orientation.NORTH);
		assertThat(orientationSuivante).isEqualTo(Orientation.EAST);
		
		orientationSuivante = TraitementInstruction.pivoterDroite(Orientation.SOUTH);
		assertThat(orientationSuivante).isEqualTo(Orientation.WEST);
	}
	
	@Test
	public void pivoter_a_gauche() throws ExceptionTondeuse{
		Orientation orientationSuivante = TraitementInstruction.pivoterGauche(Orientation.EAST);
		assertThat(orientationSuivante).isEqualTo(Orientation.NORTH);
		
		orientationSuivante = TraitementInstruction.pivoterGauche(Orientation.WEST);
		assertThat(orientationSuivante).isEqualTo(Orientation.SOUTH);
		
		orientationSuivante = TraitementInstruction.pivoterGauche(Orientation.NORTH);
		assertThat(orientationSuivante).isEqualTo(Orientation.WEST);
		
		orientationSuivante = TraitementInstruction.pivoterGauche(Orientation.SOUTH);
		assertThat(orientationSuivante).isEqualTo(Orientation.EAST);
	}

}
