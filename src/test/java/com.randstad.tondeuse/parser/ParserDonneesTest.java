package com.randstad.tondeuse.parser;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class ParserDonneesTest {
	
	@Test
	public void parse_tondeuse(){
		assertThat(ParserDonnees.parseTondeuse("")).isFalse();
		assertThat(ParserDonnees.parseTondeuse("1 2 3")).isFalse();
		assertThat(ParserDonnees.parseTondeuse("12N")).isFalse();
		assertThat(ParserDonnees.parseTondeuse("1 2 N")).isTrue();
		assertThat(ParserDonnees.parseTondeuse("1 2 S")).isTrue();
	}
	
	@Test
	public void parse_liste_instruction(){
		assertThat(ParserDonnees.parseListInstruction("")).isFalse();
		assertThat(ParserDonnees.parseListInstruction(" ")).isFalse();
		assertThat(ParserDonnees.parseListInstruction("D G")).isFalse();
		assertThat(ParserDonnees.parseListInstruction("GGAAAGADDAN")).isFalse();
		assertThat(ParserDonnees.parseListInstruction("GGAAAG ADDAN")).isFalse();
		assertThat(ParserDonnees.parseListInstruction("DGA")).isTrue();
		assertThat(ParserDonnees.parseListInstruction("GGAAAGADDA")).isTrue();
	}
	
	@Test
	public void parse_pelouse(){
		assertThat(ParserDonnees.parsePelouse("")).isFalse();
		assertThat(ParserDonnees.parsePelouse("1 2 3")).isFalse();
		assertThat(ParserDonnees.parsePelouse("123")).isFalse();
		assertThat(ParserDonnees.parsePelouse("1 2 ")).isFalse();
		assertThat(ParserDonnees.parsePelouse("1 2")).isTrue();
		assertThat(ParserDonnees.parsePelouse("1 N")).isFalse();
	}

}
