package com.randstad.tondeuse.traitement;

import static org.fest.assertions.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import com.randstad.tondeuse.ExceptionTondeuse;
import com.randstad.tondeuse.model.Coordonnees;
import com.randstad.tondeuse.model.Params;
import com.randstad.tondeuse.model.Params.InstructionTondeuse;
import com.randstad.tondeuse.model.Params.Orientation;
import com.randstad.tondeuse.model.Pelouse;
import com.randstad.tondeuse.model.PositionTondeuse;

import com.randstad.tondeuse.service.traitement.TraitementInstruction;
import com.randstad.tondeuse.service.traitement.TraitementTondeuse;
import org.junit.Test;


public class TraitementTondeuseTest {
	Coordonnees coordonnesMax = new Coordonnees(5, 5);
	
	@Test
	public void executer_instruction_aucune_instruction() throws ExceptionTondeuse{
		int x = 0;
		int y = 0;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		
		TraitementTondeuse traitemetT = new TraitementTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(new ArrayList<Params.InstructionTondeuse>());
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("0 0 N");
	}
	
	@Test
	public void executer_instruction_unitaire() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<Params.InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.AVANCER);
		int x = 1;
		int y = 1;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		TraitementTondeuse traitemetT = new TraitementTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("1 2 N");
	}
	
	@Test
	public void executer_instruction_plusieurs() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<Params.InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		int x = 3;
		int y = 2;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		TraitementTondeuse traitemetT = new TraitementTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("2 1 S");
	}
	
	@Test
	public void executer_instruction_cas_reel_1() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<Params.InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.GAUCHE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.AVANCER);
		int x = 1;
		int y = 2;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.NORTH);
		TraitementTondeuse traitemetT = new TraitementTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("1 3 N");
	}
	@Test
	public void executer_instruction_cas_reel_2() throws ExceptionTondeuse{
		List<InstructionTondeuse> listInstruction = new ArrayList<Params.InstructionTondeuse>();
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.DROITE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.DROITE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		listInstruction.add(InstructionTondeuse.DROITE);
		listInstruction.add(InstructionTondeuse.DROITE);
		listInstruction.add(InstructionTondeuse.AVANCER);
		int x = 3;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees, Orientation.EAST);
		TraitementTondeuse traitemetT = new TraitementTondeuse();
		traitemetT.setPelouse(new Pelouse(coordonnesMax));
		traitemetT.setPositionTondeuse(positionTondeuse);
		traitemetT.setListeInstruction(listInstruction);
		traitemetT.executerInstructions();
		assertThat(traitemetT.toString()).isEqualTo("5 1 E");
	}
	
	
	@Test
	public void coordonnees_x_y_north_instruction_avancer() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.NORTH);
		TraitementInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y+1));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
	}
	
	@Test
	public void coordonnees_x_y_East_instruction_avancer() throws ExceptionTondeuse {
		int x = 0;
		int y = 0;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.EAST);
		TraitementInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x+1, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void coordonnees_x_y_South_instruction_avancer() throws ExceptionTondeuse {
		int x = 5;
		int y = 5;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.SOUTH);
		TraitementInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y-1));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void coordonnees_x_y_West_instruction_avancer() throws ExceptionTondeuse {
		int x = 5;
		int y = 5;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.WEST);
		TraitementInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.AVANCER, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x-1, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.WEST);
	}
	@Test
	public void coordonnees_x_y_West_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.WEST);
		TraitementInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}
	
	@Test
	public void coordonnees_x_y_east_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.EAST);
		TraitementInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
	}

	@Test
	public void coordonnees_x_y_west_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.WEST);
		TraitementInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}
	@Test
	public void coordonnees_x_y_south_instruction_Tourner_gauche() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.SOUTH);
		TraitementInstruction.executerInstruction(positionTondeuse, Params.InstructionTondeuse.GAUCHE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void coordonnees_x_y_north_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.NORTH);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.EAST);
	}
	
	@Test
	public void coordonnees_x_y_east_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.EAST);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.SOUTH);
	}

	@Test
	public void coordonnees_x_y_west_instruction_Tourner_Droite() throws ExceptionTondeuse {
		int x = 2;
		int y = 3;
		Coordonnees coordonnees = new Coordonnees(x, y);
		PositionTondeuse positionTondeuse = new PositionTondeuse(coordonnees,Orientation.WEST);
		TraitementInstruction.executerInstruction(positionTondeuse, InstructionTondeuse.DROITE, coordonnesMax);
		assertThat(positionTondeuse.getCoordonneesTondeuse()).isEqualTo(new Coordonnees(x, y));
		assertThat(positionTondeuse.getOrientationTondeuse()).isEqualTo(Orientation.NORTH);
	}

}