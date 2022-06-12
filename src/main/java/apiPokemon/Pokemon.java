package apiPokemon;

import java.util.Collection;

public class Pokemon {
  private int id;
  private String name;
  private int base_experience;
  private int height;
  private boolean is_default;
  private int order;
  private int weight;
  private Collection<ElementoAbility> abilities;
  private Collection<Dato> forms;
  private Collection<GameIndex> game_indices;
  private Collection<Held_item> held_items;
  private String location_area_encounters;
  private Collection<Move> moves;
  private Dato species;
  private VersionGroup version_group;
  private Version version;
  private Collection<Stat> stats;
  private Collection<Type> types;
  private Collection<PastType> past_types;
}
