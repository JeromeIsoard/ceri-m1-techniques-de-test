package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{

    private static PokemonTrainerFactory instance;

    /**
     * Constructor
     * Singleton to have only one factory
     */
    private PokemonTrainerFactory() {
    }

    public PokemonTrainerFactory getInstance(){
        if (instance == null) instance = new PokemonTrainerFactory();
        return instance;
    }

    /**
     * Creates and returns a PokemonTrainer instance.
     *
     * @param name           Name of the created trainer.
     * @param team           Team of the created trainer.
     * @param pokedexFactory Factory to use for creating associated pokedex instance.
     * @return Created trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        Pokedex trainerPokedex = new Pokedex(PokemonMetadaProvider.getInstance(),PokemonFactory.getInstance());
        return new PokemonTrainer(name, team, trainerPokedex);
    }
}
