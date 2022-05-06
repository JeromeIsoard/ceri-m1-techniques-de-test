package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IPokedexTest {

    @Mock
    IPokedex pokedex;
    List<Pokemon> pokemonsList;
    int size;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126,126, 90, 613, 64, 4000, 4, 56);
        Pokemon aquali = new Pokemon(133, "Aquali", 186,168, 260, 2729, 202, 5000, 4, 100);
        pokemonsList = new ArrayList<Pokemon>();
        pokemonsList.add(bulbizarre);
        pokemonsList.add(aquali);
        size = pokemonsList.size();
        Mockito.when(pokedex.getPokemonList()).thenReturn(pokemonsList);
        Mockito.when(pokedex.addPokemon(bulbizarre)).thenReturn(0);
        Mockito.when(pokedex.addPokemon(aquali)).thenReturn(133);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(bulbizarre);
        Mockito.when(pokedex.getPokemon(1)).thenReturn(aquali);
        Mockito.when(pokedex.getPokemonList()).thenReturn(pokemonsList);

    }

    @Test
    public void size() {
        assertEquals(pokedex.getPokemonList().size() , this.size);
    }

    @Test
    public void addPokemon() {
        for(int i = 0; i < this.pokemonsList.size() ; i++){
            assertEquals(this.pokedex.addPokemon(this.pokemonsList.get(i)),this.pokemonsList.get(i).getIndex());
        }
    }

    @Test
    public void getPokemon() {
        for(int i = 0; i < this.pokemonsList.size() ; i++){
            try {
                assertEquals(this.pokedex.getPokemon(i).getIndex(),this.pokemonsList.get(i).getIndex());
            } catch (PokedexException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void getPokemons() {
        assertEquals(pokedex.getPokemonList(),pokemonsList);
    }

    @Test
    public void testGetPokemons() {

    }
}