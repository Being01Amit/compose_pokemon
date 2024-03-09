package com.android.pokedex.remote.responses

import com.google.gson.annotations.SerializedName


data class PokemonResponse(
    @SerializedName("abilities")
    var abilities: List<Ability>,
    @SerializedName("base_experience")
    var baseExperience: Int,
    @SerializedName("forms")
    var forms: List<Form>,
    @SerializedName("game_indices")
    var gameIndices: List<GameIndice>,
    @SerializedName("height")
    var height: Int,
    @SerializedName("held_items")
    var heldItems: List<HeldItem>,
    @SerializedName("id")
    var id: Int,
    @SerializedName("is_default")
    var isDefault: Boolean,
    @SerializedName("location_area_encounters")
    var locationAreaEncounters: String,
    @SerializedName("moves")
    var moves: List<Move>,
    @SerializedName("name")
    var name: String,
    @SerializedName("order")
    var order: Int,
    @SerializedName("past_abilities")
    var pastAbilities: List<Any>,
    @SerializedName("past_types")
    var pastTypes: List<Any>,
    @SerializedName("species")
    var species: Species,
    @SerializedName("sprites")
    var sprites: Sprites,
    @SerializedName("stats")
    var stats: List<Stat>,
    @SerializedName("types")
    var types: List<Type>,
    @SerializedName("weight")
    var weight: Int
)

data class Ability(
    @SerializedName("ability")
    var ability: AbilityX,
    @SerializedName("is_hidden")
    var isHidden: Boolean,
    @SerializedName("slot")
    var slot: Int
)

data class Form(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

data class GameIndice(
    @SerializedName("game_index")
    var gameIndex: Int,
    @SerializedName("version")
    var version: Version
)

data class HeldItem(
    @SerializedName("item")
    var item: Item,
    @SerializedName("version_details")
    var versionDetails: List<VersionDetail>
)

data class Move(
    @SerializedName("move")
    var move: MoveX,
    @SerializedName("version_group_details")
    var versionGroupDetails: List<VersionGroupDetail>
)

data class Species(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

data class Sprites(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String,
    @SerializedName("other")
    var other: Other,
    @SerializedName("versions")
    var versions: Versions
)

data class Stat(
    @SerializedName("base_stat")
    var baseStat: Int,
    @SerializedName("effort")
    var effort: Int,
    @SerializedName("stat")
    var stat: StatX
)

data class Type(
    @SerializedName("slot")
    var slot: Int,
    @SerializedName("type")
    var type: TypeX
)

data class AbilityX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

data class Version(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

data class Item(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

data class VersionDetail(
    @SerializedName("rarity")
    var rarity: Int,
    @SerializedName("version")
    var version: Version
)

data class MoveX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

data class VersionGroupDetail(
    @SerializedName("level_learned_at")
    var levelLearnedAt: Int,
    @SerializedName("move_learn_method")
    var moveLearnMethod: MoveLearnMethod,
    @SerializedName("version_group")
    var versionGroup: VersionGroup
)

data class MoveLearnMethod(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

data class VersionGroup(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

data class Other(
    @SerializedName("dream_world")
    var dreamWorld: DreamWorld,
    @SerializedName("home")
    var home: Home,
    @SerializedName("official-artwork")
    var officialArtwork: OfficialArtwork,
    @SerializedName("showdown")
    var showdown: Showdown
)

data class Versions(
    @SerializedName("generation-i")
    var generationI: GenerationI,
    @SerializedName("generation-ii")
    var generationIi: GenerationIi,
    @SerializedName("generation-iii")
    var generationIii: GenerationIii,
    @SerializedName("generation-iv")
    var generationIv: GenerationIv,
    @SerializedName("generation-v")
    var generationV: GenerationV,
    @SerializedName("generation-vi")
    var generationVi: GenerationVi,
    @SerializedName("generation-vii")
    var generationVii: GenerationVii,
    @SerializedName("generation-viii")
    var generationViii: GenerationViii
)

data class DreamWorld(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any
)

data class Home(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String
)

data class OfficialArtwork(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)

data class Showdown(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: Any,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String
)

data class GenerationI(
    @SerializedName("red-blue")
    var redBlue: RedBlue,
    @SerializedName("yellow")
    var yellow: Yellow
)

data class GenerationIi(
    @SerializedName("crystal")
    var crystal: Crystal,
    @SerializedName("gold")
    var gold: Gold,
    @SerializedName("silver")
    var silver: Silver
)

data class GenerationIii(
    @SerializedName("emerald")
    var emerald: Emerald,
    @SerializedName("firered-leafgreen")
    var fireredLeafgreen: FireredLeafgreen,
    @SerializedName("ruby-sapphire")
    var rubySapphire: RubySapphire
)

data class GenerationIv(
    @SerializedName("diamond-pearl")
    var diamondPearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    var heartgoldSoulsilver: HeartgoldSoulsilver,
    @SerializedName("platinum")
    var platinum: Platinum
)

data class GenerationV(
    @SerializedName("black-white")
    var blackWhite: BlackWhite
)

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    var omegarubyAlphasapphire: OmegarubyAlphasapphire,
    @SerializedName("x-y")
    var xY: XY
)

data class GenerationVii(
    @SerializedName("icons")
    var icons: Icons,
    @SerializedName("ultra-sun-ultra-moon")
    var ultraSunUltraMoon: UltraSunUltraMoon
)

data class GenerationViii(
    @SerializedName("icons")
    var icons: IconsX
)

data class RedBlue(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_gray")
    var backGray: String,
    @SerializedName("back_transparent")
    var backTransparent: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_gray")
    var frontGray: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)

data class Yellow(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_gray")
    var backGray: String,
    @SerializedName("back_transparent")
    var backTransparent: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_gray")
    var frontGray: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)

data class Crystal(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_transparent")
    var backShinyTransparent: String,
    @SerializedName("back_transparent")
    var backTransparent: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_transparent")
    var frontShinyTransparent: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)

data class Gold(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)

data class Silver(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_transparent")
    var frontTransparent: String
)

data class Emerald(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)

data class FireredLeafgreen(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)

data class RubySapphire(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_shiny")
    var frontShiny: String
)

data class DiamondPearl(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String
)

data class HeartgoldSoulsilver(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String
)

data class Platinum(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String
)

data class BlackWhite(
    @SerializedName("animated")
    var animated: Animated,
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String
)

data class Animated(
    @SerializedName("back_default")
    var backDefault: String,
    @SerializedName("back_female")
    var backFemale: String,
    @SerializedName("back_shiny")
    var backShiny: String,
    @SerializedName("back_shiny_female")
    var backShinyFemale: String,
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String
)

data class OmegarubyAlphasapphire(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String
)

data class XY(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String
)

data class Icons(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: Any
)

data class UltraSunUltraMoon(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String,
    @SerializedName("front_shiny")
    var frontShiny: String,
    @SerializedName("front_shiny_female")
    var frontShinyFemale: String
)

data class IconsX(
    @SerializedName("front_default")
    var frontDefault: String,
    @SerializedName("front_female")
    var frontFemale: String
)

data class StatX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)

data class TypeX(
    @SerializedName("name")
    var name: String,
    @SerializedName("url")
    var url: String
)