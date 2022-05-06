package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class IPokedexFactoryTest {

    @Mock
    IPokedexFactory pokedexfactory;
    @Mock
    IPokemonMetadataProvider metadataProvider;
    @Mock
    IPokemonFactory pokemonFactory;

    @Before
    public void setUp() throws Exception {
//        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126,126, 90, 613, 64, 4000, 4, 56);
//        Pokemon aquali = new Pokemon(133, "Aquali", 186,168, 260, 2729, 202, 5000, 4, 100);
        // je ne vois pas cmt faire
    }

    @Test
    public void createPokedex() {

    }
}