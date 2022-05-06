package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class IPokemonTrainerFactoryTest {

    @Mock
    IPokemonTrainerFactory pokemonTrainerFactory;
    @Mock
    IPokedex pokedex;
    @Mock
    IPokedexFactory pokedexFactory;
    PokemonTrainer pokemonTrainer;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        pokemonTrainer = new PokemonTrainer("Jerome", Team.VALOR, pokedex);
        Mockito.when(this.pokemonTrainerFactory.createTrainer("Jerome", Team.VALOR, (IPokedexFactory) pokedex)).thenReturn(pokemonTrainer);
    }

    @Test
    public void createTrainer() {
        assertEquals(this.pokemonTrainerFactory.createTrainer("Jerome", Team.VALOR, pokedexFactory),this.pokemonTrainer);
    }
}