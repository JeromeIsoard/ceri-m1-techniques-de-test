package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory{

    private static PokedexFactory instance;

    /**
     * Constructor
     * Singleton to have only one factory
     */
    private PokedexFactory() {
    }

    public PokedexFactory getInstance(){
        if (instance == null) instance = new PokedexFactory();
        return instance;
    }

    /**
     * Creates a new pokedex instance using the given
     * <tt>metadataProvider</tt> and <tt>pokemonFactory</tt>.
     *
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory   Pokemon factory the created pokedex will use.
     * @return Created pokedex instance.
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
