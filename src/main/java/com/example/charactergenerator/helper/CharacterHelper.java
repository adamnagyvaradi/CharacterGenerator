package com.example.charactergenerator.helper;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.*;
import com.example.charactergenerator.service.ArmorService;
import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.service.MeleeWeaponService;
import com.example.charactergenerator.service.RangedWeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class    CharacterHelper implements ApplicationRunner {
    private CharacterService characterService;

    private ArmorService armorService;

    private MeleeWeaponService meleeWeaponService;

    private RangedWeaponService rangedWeaponService;

    @Autowired
    public void setArmorRepository(ArmorService armorService) {
        this.armorService = armorService;
    }

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Autowired
    public void setMeleeWeaponService(MeleeWeaponService meleeWeaponService){
        this.meleeWeaponService = meleeWeaponService;
    }

    @Autowired
    public void setRangedWeaponService(RangedWeaponService rangedWeaponService) {
        this.rangedWeaponService = rangedWeaponService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        saveMelee();
        saveRanged();
        saveArmors();
        saveCharacters();
    }

    private void saveCharacters(){
        getCharacters().forEach(character -> characterService.save(character));
    }

    private void saveArmors(){
        armorService.saveAll(getAllArmors());
    }

    private void saveMelee(){
        meleeWeaponService.saveAll(getMeleeWeapons());
    }

    private void saveRanged(){
        rangedWeaponService.saveAll(getRangedWeapons());
    }

    public Armor getArmorByName(String name){
        for (Armor armor : getAllArmors()) {
            if (armor.getName().equals(name)) {
                return armor;
            }
        }
        throw new IllegalArgumentException();
    }

    public Armor getArmorByID(Long id){
        for (Armor armor : getAllArmors()) {
            if (armor.getId() == id) {
                return armor;
            }
        }
        throw new IllegalArgumentException();
    }

    public MeleeWeapon getMeleeWeaponByID(Long id){
        for (MeleeWeapon meleeWeapon : getMeleeWeapons()){
            if (meleeWeapon.getId() == id){
                return meleeWeapon;
            }
        }
        throw new IllegalArgumentException();
    }

    public RangedWeapon getRangedWeaponByID(Long id){
        for (RangedWeapon rangedWeapon : getRangedWeapons()){
            if (rangedWeapon.getId() == id){
                return rangedWeapon;
            }
        }
        throw new IllegalArgumentException();
    }

    private List<Character> getCharacters(){
        return new ArrayList<>(Arrays.asList(
                new Character("Aboleth", 17, 135, "18d10+36", "10 ft., swim 40 ft.", 10,
                        21, 9, 15, 18, 15, 18,CharacterType.ABERRATION,
                        Set.of(SkillType.HISTORY, SkillType.PERCEPTION)),
                new Character("Acolyte", 10, 9, "2d8", "30 ft.", 0,
                        10, 10, 10, 10, 14, 11, CharacterType.HUMANOID,
                        Set.of(SkillType.MEDICINE,SkillType.RELIGION), 1),
                new Character("Adult Black Dragon", 19, 195, "17d12+85", "40 ft., fly 80 ft., swim 40 ft.", 14,
                        23, 14, 21, 14, 13, 17, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Adult Blue Dragon", 19, 225, "18d12+108", "40 ft., burrow 30 ft., fly 80 ft.", 16,
                        25, 10, 23, 16, 15, 19, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Adult Brass Dragon", 18, 172, "15d12+75", "40 ft., burrow 30 ft., fly 80 ft.", 13,
                        23, 10, 21, 14, 13, 17, CharacterType.DRAGON,
                        Set.of(SkillType.HISTORY, SkillType.PERCEPTION, SkillType.PERSUASION, SkillType.STEALTH)),
                new Character("Adult Bronze Dragon", 19, 212, "17d12+102", "40 ft., fly 80 ft., swim 40 ft.", 15,
                        25, 10, 23, 16, 15, 19,CharacterType.DRAGON,
                        Set.of(SkillType.INSIGHT, SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Adult Copper Dragon", 18, 184, "16d12+80", "40 ft., climb 40 ft., fly 80 ft.", 14,
                        23, 12, 21, 18, 15, 17, CharacterType.DRAGON,
                        Set.of(SkillType.DECEPTION, SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Adult Gold Dragon", 19, 256, "19d12+133", "40 ft., fly 80 ft., swim 40 ft.", 17,
                        27, 14, 25, 16, 15, 24, CharacterType.DRAGON,
                        Set.of(SkillType.INSIGHT, SkillType.PERCEPTION, SkillType.PERSUASION, SkillType.STEALTH)),
                new Character("Adult Green Dragon", 19, 207, "18d12+90", "40 ft., fly 80 ft., swim 40 ft.", 15,
                        23, 12, 21, 18, 15, 17, CharacterType.DRAGON,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT, SkillType.PERCEPTION, SkillType.PERSUASION, SkillType.STEALTH)),
                new Character("Adult Red Dragon", 19, 256, "19d12+133", "40 ft., climb 40 ft., fly 80 ft.", 17,
                        27, 10, 25, 16, 13, 21, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Adult Silver Dragon", 19, 243, "18d12+126", "40 ft., fly 80 ft.", 16,
                        27, 10, 25, 16, 13, 21, CharacterType.DRAGON,
                        Set.of(SkillType.ARCANA, SkillType.HISTORY, SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Adult White Dragon", 18, 200, "16d12+96", "40 ft., burrow 30 ft., fly 80 ft., swim 40 ft.", 13,
                        22, 10, 22, 8, 12, 12, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Air Elemental", 15, 90, "12d10+24", "0 ft., fly 90 ft. (hover)", 5,
                        14, 20, 14, 6, 10, 6, CharacterType.ELEMENTAL, Set.of()),
                new Character("Allosaurus", 13, 51, "6d10+18", "60 ft.", 2,
                        19, 13, 17, 2, 12, 5, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Ancient Black Dragon", 22, 367,"21d20+147", "40 ft., fly 80 ft., swim 40 ft.", 21,
                        27, 14, 25, 16, 15, 19, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Ancient Blue Dragon", 22, 481, "26d20+208", "40 ft., burrow 40 ft., fly 80 ft.", 23,
                        29, 10, 27, 18, 17, 21, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Ancient Brass Dragon", 20, 297, "17d20+119", "40 ft., burrow 40 ft., fly 80 ft.", 20,
                        27, 10, 25, 16, 15, 19, CharacterType.DRAGON,
                        Set.of(SkillType.HISTORY, SkillType.PERCEPTION, SkillType.PERSUASION, SkillType.STEALTH)),
                new Character("Ancient Bronze Dragon", 22, 444, "24d20+192", "40 ft., fly 80 ft., swim 40 ft.", 22,
                        29, 10, 27, 18, 17, 21, CharacterType.DRAGON,
                        Set.of(SkillType.INSIGHT, SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Ancient Copper Dragon", 21, 350, "20d20+140", "40 ft., climb 40 ft., fly 80 ft.", 21,
                        27, 12, 25, 20, 17, 19, CharacterType.DRAGON,
                        Set.of(SkillType.DECEPTION, SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Ancient Gold Dragon", 22, 546, "28d20+252", "40 ft., fly 80 ft., swim 40 ft.", 24,
                        30, 14, 29, 18, 17, 28, CharacterType.DRAGON,
                        Set.of(SkillType.INSIGHT, SkillType.PERCEPTION, SkillType.PERSUASION, SkillType.STEALTH)),
                new Character("Rat", 10,1,"1d4 - 1", "20 ft.", 0,
                        2, 11, 9, 2, 10, 4, CharacterType.BEAST,
                        Set.of()),
                new Character("Raven", 12, 1, "1d4 - 1", "10 ft., fly 50 ft.", 0,
                        2, 14, 8, 2, 12, 6, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Red Dragon Wyrmling", 17, 75, "10d8 + 30", "30 ft., climb 30 ft., fly 60 ft.",
                        4, 19, 10, 17, 12, 11, 15, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Reef Shark", 12, 22, "4d8 + 4", "0 ft., swim 40 ft.", 1,
                        14, 13, 13, 1, 10, 4, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Remorhaz", 17, 195, "17d12 + 85", "30 ft., burrow 20 ft.", 11,
                        24, 13, 21, 4, 10, 5, CharacterType.MONSTROSITY,
                        Set.of()),
                new Character("Rhinoceros", 11, 45, "6d10 + 12", "40 ft.", 2,
                        21, 8, 15, 2, 12, 6, CharacterType.BEAST,
                        Set.of()),
                new Character("Riding Horse", 10, 13, "2d10 + 2", "60 ft.", 0,
                        16, 10, 12, 2, 11, 7, CharacterType.BEAST,
                        Set.of()),
                new Character("Roc", 15, 248, "16d20 + 80", "20 ft., fly 120 ft.", 11,
                        28, 10, 20, 3, 10, 9, CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Roper", 20, 93, "11d10 + 33", "10 ft., climb 10 ft." , 5,
                        81, 8, 17, 7, 16, 6, CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Rug of Smothering", 12, 33, "6d10", "10 ft", 2,
                        17, 14, 10, 1, 3, 1, CharacterType.CONSTRUCT,
                        Set.of()),
                new Character("Rust Monster", 14, 27, "5d8 + 5", "40 ft.", 1,
                        13, 12, 13, 2,13, 6, CharacterType.MONSTROSITY,
                        Set.of()),
                new Character("Saber-Toothed Tiger", 12, 52, "7d10 + 14", "40 ft.", 2,
                        18, 14, 15, 3, 12, 8, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Sahuagin", 12, 22, "4d8 + 4", "30 ft., swim 40 ft.", 1,
                        13, 11, 12, 12, 13, 9, CharacterType.HUMANOID,
                        Set.of(SkillType.PERCEPTION)).equipMeleeWeapon(getMeleeWeaponByID((10l))),
                new Character("Salamander", 15, 90, "12d10 + 24", "Speed 30 ft.", 5,
                        18, 14, 15, 11, 10, 12, CharacterType.ELEMENTAL,
                        Set.of()),
                new Character("Satyr", 14, 31, "7d8", "40 ft.", 1,
                        12, 16, 11, 12, 10, 14, CharacterType.FEY,
                        Set.of(SkillType.PERCEPTION, SkillType.PERFORMANCE,SkillType.STEALTH)),
                new Character("Scorpion", 11, 1, "1d4 - 1", "10 ft.", 0,
                        2, 11, 8, 1, 8, 2, CharacterType.BEAST,
                        Set.of()),
                new Character("Scout", 13, 16, "3d8 + 3", "30 ft.", 1,
                        11, 14, 12, 11, 13, 11, CharacterType.HUMANOID,
                        Set.of(SkillType.NATURE, SkillType.PERCEPTION, SkillType.STEALTH, SkillType.SURVIVAL))
                        .equipMeleeWeapon(getMeleeWeaponByID((17l))).equipRangedWeapon(getRangedWeaponByID((3l))).equipArmor(getArmorByID((2l))),
                new Character("Sea Hag", 14, 52, "7d8 + 21", "30 ft., swim 40 ft.", 2,
                        16, 13, 16, 12, 12, 13, CharacterType.FEY,
                        Set.of()),
                new Character("Sea Horse", 11, 1, "1d4 - 1", "0 ft., swim 20 ft.", 0,
                        1, 12, 8, 1, 10, 2, CharacterType.BEAST,
                        Set.of()),
                new Character("Shadow", 12, 16, "3d8 + 3", "40 ft.", 1,
                        6, 14, 13, 6, 10, 8, CharacterType.UNDEAD,
                        Set.of(SkillType.STEALTH)),
                new Character("Shambling Mound", 15, 136, "16d10 + 48", "20 ft., swim 20 ft.", 5,
                        18, 8, 16, 5, 10, 5,CharacterType.PLANT,
                        Set.of(SkillType.STEALTH)),
                new Character("Shield Guardian", 17, 142, "15d10 + 60", "30 ft.", 7,
                        18, 8, 18, 7, 10, 3, CharacterType.CONSTRUCT,
                        Set.of()),
                new Character("Shrieker", 5, 13, "3d8", "0 ft.", 0,
                        1, 1, 10, 1, 3, 1, CharacterType.PLANT, Set.of()),
                new Character("Silver Dragon Wyrmling", 17, 45, "6d8 + 18", "30 ft., fly 60 ft.", 2,
                        19, 10, 17, 12, 11, 15, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Skeleton", 13, 13, "2d8 + 4", "30 ft.", 0,
                        10, 14, 15, 6, 8, 5, CharacterType.UNDEAD,
                        Set.of()),
                new Character("Solar", 21, 243, "18d10 + 144", "50 ft., fly 150 ft.", 21,
                        26, 22, 26, 25, 25, 30, CharacterType.CELESTIAL,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Spectator", 14, 39, "6d8 + 12", "0 ft., fly 30 ft. (hover)", 3,
                        8, 14, 14, 13, 14, 11, CharacterType.ABERRATION,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Specter", 12, 22, "5d8", "0 ft., fly 50 ft. (hover)", 1,
                        1, 14, 11, 10, 10, 11, CharacterType.UNDEAD,
                        Set.of()),
                new Character("Spider", 12, 1, "1d4 - 1", "20 ft., climb 20 ft.", 0,
                        2, 14, 8, 1, 10, 2, CharacterType.BEAST,
                        Set.of(SkillType.STEALTH)),
                new Character("Spirit Naga", 15, 75, "10d10 + 20", "40 ft.", 8,
                        18, 17, 14, 16, 15, 16, CharacterType.MONSTROSITY,
                        Set.of()),
                new Character("Sprite", 15, 2, "1d4", "10 ft., fly 40 ft.", 0,
                        3, 18, 10, 14, 13, 11, CharacterType.FEY,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Spy", 12, 27, "6d8", "30ft.", 1 ,
                        10, 15, 10, 12, 14, 16, CharacterType.HUMANOID,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT, SkillType.INVESTIGATION, SkillType.PERCEPTION, SkillType.PERSUASION,SkillType.SLEIGHT_OF_HAND, SkillType.STEALTH))
                        .equipMeleeWeapon(getMeleeWeaponByID((17l))).equipRangedWeapon(getRangedWeaponByID((1l))),
                new Character("Steam Mephit", 10, 21, "6d6", "30 ft., fly 30ft.", 0,
                        5, 11, 10, 11, 10, 12, CharacterType.ELEMENTAL,
                        Set.of()),
                new Character("Stirge", 14, 2, "1d4", "10 ft., fly 40 ft.", 0,
                        4, 16, 11, 2, 8, 6, CharacterType.BEAST,
                        Set.of()),
                new Character("Stone Giant", 17, 126, "11d12 + 55", "40 ft.", 7,
                        23, 15, 20, 10, 12, 9, CharacterType.GIANT,
                        Set.of(SkillType.ATHLETICS, SkillType.PERCEPTION)),
                new Character("Stone Golem", 17, 178, "7d10 + 85", "30 ft.", 10,
                        22, 9, 20, 3, 11, 1, CharacterType.CONSTRUCT,
                        Set.of()),
                new Character("Storm Giant", 16, 230, "20d12 + 100", "50 ft., swim 50 ft.", 13,
                        29, 14, 20, 16, 18, 18, CharacterType.GIANT,
                        Set.of(SkillType.ARCANA, SkillType.ATHLETICS, SkillType.HISTORY, SkillType.PERCEPTION)),
                new Character("Succubus", 15, 66, "12d8 + 12", "30 ft., fly 60 ft.", 4,
                        8, 17, 13, 15, 12, 20, CharacterType.FIEND,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT,SkillType.PERCEPTION, SkillType.PERSUASION, SkillType.STEALTH)),
                new Character("Swarm of Bats", 12, 22, "5d8", "0 ft., fly 30 ft.", 0,
                        5, 15, 10, 2, 12, 4, CharacterType.BEAST,
                        Set.of()),
                new Character("Swarm of Insects", 12, 22, "5d8", "20 ft., climb 20 ft.", 1,
                        3, 13, 10, 1, 7, 1, CharacterType.BEAST,
                        Set.of())



        ));
    }

    public List<Armor> getAllArmors() {

        return new ArrayList<>(Arrays.asList(
                new Armor(1,"Padded", ArmorType.LIGHT, (byte) 11),
                new Armor(2,"Leather", ArmorType.LIGHT, (byte) 11),
                new Armor(3, "Studded leather", ArmorType.LIGHT, (byte) 12),
                new Armor(4,"Hide", ArmorType.MEDIUM, (byte) 12),
                new Armor(5,"Chain shirt", ArmorType.MEDIUM, (byte) 13),
                new Armor(6,"Scale mail", ArmorType.MEDIUM, (byte) 14),
                new Armor(7,"Breastplate", ArmorType.MEDIUM, (byte) 14),
                new Armor(8,"Half plate", ArmorType.MEDIUM, (byte) 15),
                new Armor(9,"Ring mail", ArmorType.HEAVY, (byte) 14),
                new Armor(10,"Chain mail", ArmorType.HEAVY, (byte) 16),
                new Armor(11,"Splint", ArmorType.HEAVY, (byte) 17),
                new Armor(12,"Plate", ArmorType.HEAVY, (byte) 18)));
    }

    public List<MeleeWeapon> getMeleeWeapons() {

        return new ArrayList<>(Arrays.asList(
                new MeleeWeapon(1, "Club", "1d4 bludgeoning"),
                new MeleeWeapon(2, "Dagger", "1d4 piercing"),
                new MeleeWeapon(3, "Greatclub", "1d8 bludgeoning"),
                new MeleeWeapon(4, "Handaxe", "1d6 slashing"),
                new MeleeWeapon(5, "Javelin", "1d6 piercing"),
                new MeleeWeapon(6, "Light hammer", "1d4 bludgeoning"),
                new MeleeWeapon(7, "Mace", "1d4 bludgeoning"),
                new MeleeWeapon(8, "Quarterstaff", "1d6 bludgeoning"),
                new MeleeWeapon(9, "Sickle", "1d4 slashing"),
                new MeleeWeapon(10, "Spear", "1d6 piercing"),
                new MeleeWeapon(11, "Battleaxe", "1d8 slashing"),
                new MeleeWeapon(12, "Greataxe", "1d12 slashing"),
                new MeleeWeapon(13, "Greatsword", "2d6 slashing"),
                new MeleeWeapon(14, "Longsword", "1d8 slashing"),
                new MeleeWeapon(15, "Pike", "1d10 piercing"),
                new MeleeWeapon(16, "Scimitar", "1d6 slashing"),
                new MeleeWeapon(17, "Shortsword", "1d6 piercing"),
                new MeleeWeapon(18, "Warhammer", "1d8 bludgeoning")
        ));
    }

    public List<RangedWeapon> getRangedWeapons() {
        return new ArrayList<>(Arrays.asList(
                new RangedWeapon(1, "Crossbow, light", "1d8 piercing"),
                new RangedWeapon(2, "Dart", "1d4 piercing"),
                new RangedWeapon(3, "Shortbow", "1d6 piercing"),
                new RangedWeapon(4, "Sling", "1d4 bludgeoning"),
                new RangedWeapon(5, "Blowgun", "1 piercing"),
                new RangedWeapon(6, "Crossbow, hand", "1d6 piercing"),
                new RangedWeapon(7, "Crossbow, heavy", "1d10 piercing"),
                new RangedWeapon(8, "Longbow", "1d8 piercing"),
                new RangedWeapon(9, "Net", "-")
        ));
    }

}
