package com.montaury.pokebagarre.metier;


import com.montaury.pokebagarre.fixtures.ConstructeurDePokemon;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

static ConstructeurDePokemon poke;

    @BeforeAll
    static void suiteSetUp() {
        poke = new ConstructeurDePokemon();
    }

    @Test
    void pokemon_j1_gagne_avec_best_attaque() {
        // GIVEN
        poke.avecAttaque(200).avecDefense(200);
        Pokemon pokemon1 = poke.construire();
        poke.avecAttaque(150).avecDefense(100);
        Pokemon pokemon2 = poke.construire();

        // WHEN
        boolean win = pokemon1.estVainqueurContre(pokemon2);

        // THEN
        assertEquals(true, win);
    }

    @Test
    void pokemon_j2_gagne_avec_best_attaque() {
        // GIVEN
        poke.avecAttaque(100).avecDefense(50);
        Pokemon pokemon1 = poke.construire();
        poke.avecAttaque(150).avecDefense(100);
        Pokemon pokemon2 = poke.construire();

        // WHEN
        boolean win = pokemon2.estVainqueurContre(pokemon1);

        // THEN
        assertEquals(true, win);
    }

    @Test
    void pokemon_j1_gagne_avec_best_defense_car_meme_attaque() {
        // GIVEN
        poke.avecAttaque(100).avecDefense(150);
        Pokemon pokemon1 = poke.construire();
        poke.avecAttaque(100).avecDefense(100);
        Pokemon pokemon2 = poke.construire();

        // WHEN
        boolean win = pokemon1.estVainqueurContre(pokemon2);

        // THEN
        assertEquals(true, win);
    }

    @Test
    void pokemon_j2_gagne_avec_best_defense_car_meme_attaque() {
        // GIVEN
        poke.avecAttaque(100).avecDefense(150);
        Pokemon pokemon1 = poke.construire();
        poke.avecAttaque(100).avecDefense(200);
        Pokemon pokemon2 = poke.construire();

        // WHEN
        boolean win = pokemon2.estVainqueurContre(pokemon1);

        // THEN
        assertEquals(true, win);
    }

    @Test
    void pokemon_j1_et_j2_meme_attaque_meme_defense(){
        // GIVEN
        poke.avecAttaque(150).avecDefense(150);
        Pokemon pokemon1 = poke.construire();
        poke.avecAttaque(150).avecDefense(150);
        Pokemon pokemon2 = poke.construire();

        // WHEN
        boolean win = pokemon2.estVainqueurContre(pokemon1);

        // THEN
        assertEquals(true, win);
    }

}