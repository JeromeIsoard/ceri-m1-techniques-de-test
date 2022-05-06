package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class IPokemonFactoryTest {

    @Mock
    IPokemonFactory pokemonfactory;
    Pokemon pokemon;
    int index;
    int cp;
    int hp;
    int dust;
    int candy;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.pokemon = new Pokemon(0, "Bulbizarre", 126,126, 90, 613, 64, 4000, 4, 56);
        this.index = 0;
        this.cp = 613;
        this.hp = 64;
        this.dust = 4000;
        this.candy = 4;

        Mockito.when(pokemonfactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(pokemon);
    }

    @Test
    public void createPokemon() {
        assertEquals(this.pokemonfactory.createPokemon(index, cp, hp, dust, candy),this.pokemon);
    }
}