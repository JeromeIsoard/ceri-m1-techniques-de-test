package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IPokemonMetadataProviderTest {

    @Mock
    IPokemonMetadataProvider pokemonMetaDataProvider;
    List<PokemonMetadata> pokemonMetadataList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        pokemonMetadataList = new ArrayList<PokemonMetadata>();
        pokemonMetadataList.add(new PokemonMetadata(0,"Bulbizarre",126,126,90));
        pokemonMetadataList.add(new PokemonMetadata(133,"Aquali",186,168,260));
        Mockito.when(pokemonMetaDataProvider.getPokemonMetadata(0)).thenReturn(pokemonMetadataList.get(0));
        Mockito.when(pokemonMetaDataProvider.getPokemonMetadata(133)).thenReturn(pokemonMetadataList.get(1));
    }

    @Test
    public void getPokemonMetadata() {
        for(PokemonMetadata pokemondata : pokemonMetadataList){
            try {
                assertEquals(this.pokemonMetaDataProvider.getPokemonMetadata(pokemondata.getIndex()),pokemondata);
            } catch (PokedexException e) {
                e.printStackTrace();
            }
        }
    }
}