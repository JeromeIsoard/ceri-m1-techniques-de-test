package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadaProvider implements IPokemonMetadataProvider{

    private static PokemonMetadaProvider instance;
    private List<PokemonMetadata> pokemonMetadataList;

    /**
     * Construtor to initiate the main PokemonMetaData list
     * Singleton to have a single provider
     */
    private PokemonMetadaProvider() {
        pokemonMetadataList = new ArrayList<>();
        pokemonMetadataList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonMetadataList.add(new PokemonMetadata(136, "Aquali", 186, 168, 260));
    }

    public static PokemonMetadaProvider getInstance() {
        if (instance == null){
            instance = new PokemonMetadaProvider();
        }
        return instance;
    }

    /**
     * Retrieves and returns the metadata for the pokemon
     * denoted by the given <tt>index</tt>.
     *
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        PokemonMetadata pokemonMetadataToReturn = null;
        for (PokemonMetadata pokemonMetadata: pokemonMetadataList){
            if (pokemonMetadata.getIndex() == index) pokemonMetadataToReturn = pokemonMetadata;
        }
        if (pokemonMetadataToReturn == null) throw new PokedexException("Error invalid index");
        return pokemonMetadataToReturn;
    }

}
