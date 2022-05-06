package fr.univavignon.pokedex.api;

import java.util.Random;

public class PokemonFactory implements IPokemonFactory{

    private PokemonMetadaProvider pokemonMetadaProvider = PokemonMetadaProvider.getInstance();
    private static PokemonFactory instance;

    /**
     * Constructor
     * Singleton to have only one factory
     */
    private PokemonFactory(){

    }

    public static PokemonFactory getInstance(){
        if (instance == null){
            instance = new PokemonFactory();
        }
        return instance;
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
        PokemonMetadata newPokemonMetaData = pokemonMetadaProvider.getPokemonMetadata(index);
        Random random = new Random();
        double iv = random.nextInt(100);
        Pokemon newPokemon = new Pokemon(index, newPokemonMetaData.getName(), newPokemonMetaData.getAttack(),
                                                newPokemonMetaData.getDefense(), newPokemonMetaData.getStamina(),
                                                cp, hp, dust, candy, iv);
        return newPokemon;
    }
}
