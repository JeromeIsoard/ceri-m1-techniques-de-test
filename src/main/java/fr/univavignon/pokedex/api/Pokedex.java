package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex{

    private List<Pokemon> pokemonList;
    private PokemonFactory pokemonFactory;
    private PokemonMetadaProvider pokemonMetadaProvider;

    /**
     * Constructor
     * @param pokemonMetadaProvider
     * @param pokemonFactory
     */
    public Pokedex(IPokemonMetadataProvider pokemonMetadaProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadaProvider = (PokemonMetadaProvider) pokemonMetadaProvider;
        this.pokemonFactory = (PokemonFactory) pokemonFactory;
        pokemonList = new ArrayList<Pokemon>();
    }

    /**
     * Returns the number of pokemon this pokedex contains.
     *
     * @return Number of pokemon in this pokedex.
     */
    @Override
    public int size() {
        return pokemonList.size();
    }

    /**
     * Adds the given <tt>pokemon</tt> to this pokedex and returns
     * it unique index.
     *
     * @param pokemon Pokemon to add to this pokedex.
     * @return Index of this pokemon relative to this pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemonList.add(pokemon);
        return pokemonList.indexOf(pokemon);
    }

    /**
     * Locates the pokemon identified by the given <tt>id</tt>.
     *
     * @param id Unique pokedex relative identifier.
     * @return Pokemon denoted by the given identifier.
     * @throws PokedexException If the given <tt>index</tt> is not valid.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return pokemonList.get(id);
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     *
     * @return Unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    /**
     * Returns an unmodifiable list of all pokemons this pokedex contains.
     * The list view will be sorted using the given <tt>order</tt>.
     *
     * @param order Comparator instance used for sorting the created view.
     * @return Sorted unmodifiable list of all pokemons.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        return null;
    }

    /**
     * Creates a pokemon instance computing it IVs.
     *
     * @param index Pokemon index.
     * @param cp    Pokemon CP.
     * @param hp    Pokemon HP.
     * @param dust  Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return Created pokemon instance.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        Pokemon newPokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        return newPokemon;
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
        PokemonMetadata pokemonMetadata = pokemonMetadaProvider.getPokemonMetadata(index);
        return pokemonMetadata;
    }
}
