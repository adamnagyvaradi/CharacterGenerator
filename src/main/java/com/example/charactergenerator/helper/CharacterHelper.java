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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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
                new Character("Ancien Green Dragon", 21, 385, "22d20+154", "40 ft., fly 80 ft., swim 40 ft.", 22,
                        27, 12, 25, 20, 17, 19, CharacterType.DRAGON,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT, SkillType.PERCEPTION, SkillType.PERSUASION, SkillType.STEALTH)),
                new Character("Ancient Red Dragon", 22, 546, "28d20+252", "40 ft., climb 40 ft., fly 80 ft.", 24,
                        30, 10, 29, 18, 15, 23, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Ancient Silver Dragon", 22, 487, "25d20+225","40 ft., fly 80 ft.", 23,
                        30, 10, 29, 18, 15, 23, CharacterType.DRAGON,
                        Set.of(SkillType.ARCANA, SkillType.HISTORY, SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Ancient White Dragon", 20, 333, "18d20 + 144", "40 ft., burrow 40 ft., fly 80 ft., swim 40 ft.", 20,
                        26, 10, 26, 10, 13, 14, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Androsphinx", 17, 199, "19d10+95", "40 ft., fly 60 ft.", 17,
                        22, 10, 20, 16, 18, 23, CharacterType.MONSTROSITY,
                        Set.of(SkillType.ARCANA, SkillType.PERCEPTION, SkillType.RELIGION)),
                new Character("Animated Armor", 18, 33, "6d8+6", "25 ft.", 1,
                        14, 11, 13, 1, 3, 1, CharacterType.CONSTRUCT, Set.of()),
                new Character("Ankheg", 14, 39, "6d10+6", "30 ft., burrow 10 ft.", 2,
                        17, 11, 13, 1, 13, 6, CharacterType.MONSTROSITY, Set.of()),
                new Character("Ankylosaurus", 15, 68, "8d12+16", "30 ft.", 3,
                        19, 11, 15, 2, 12, 5, CharacterType.BEAST, Set.of()),
                new Character("Ape", 12, 19, "3d8+6", "30 ft., climb 30 ft.", 1,
                        16,14,14,6,12,7, CharacterType.BEAST, Set.of()),
                new Character("Archmage", 12, 99, "18d8+18", "30 ft.", 12,
                        10, 14, 12, 20, 15, 16, CharacterType.HUMANOID,
                        Set.of(SkillType.ARCANA, SkillType.HISTORY), 18),
                new Character("Assassin", 13, 78, "12d8+24", "30 ft.", 8,
                        11, 16, 14, 13, 11, 10, CharacterType.HUMANOID,
                        Set.of(SkillType.ACROBATICS, SkillType.DECEPTION, SkillType.PERCEPTION, SkillType.STEALTH)).
                        equipArmor(getArmorByID(3L)).equipMeleeWeapon(getMeleeWeaponByID(17L)).equipRangedWeapon(getRangedWeaponByID(1L)),
                new Character("Awakened Shrub", 9, 10, "3d6", "20 ft.", 0,
                        3, 8, 11, 10, 10, 6, CharacterType.PLANT, Set.of()),
                new Character("Awakened Tree", 13, 59, "7d12+14", "20 ft.", 2,
                        19, 6, 15, 10, 10, 7, CharacterType.PLANT, Set.of()),
                new Character("Axe Beak", 11, 19, "3d10+3", "50 ft.", 0,
                        14, 12, 12, 2, 10, 5, CharacterType.BEAST, Set.of()),
                new Character("Azer", 17, 39, "6d8+12", "30 ft.", 2,
                        17, 12, 15, 12, 13, 10, CharacterType.ELEMENTAL, Set.of()),
                new Character("Baboon", 12, 3, "1d6", "30 ft., climb 30 ft.", 0,
                        8, 14, 11, 4, 12, 6, CharacterType.BEAST, Set.of()),
                new Character("Badger", 10, 3, "1d4+1", "20 ft., burrow 5 ft.", 0,
                        4, 11, 12, 2, 12, 5, CharacterType.BEAST, Set.of()),
                new Character("Balor", 19, 262, "21d12+126", "40 ft., fly 80 ft.", 19,
                        26, 15, 22, 20, 16, 22, CharacterType.FIEND, Set.of()),
                new Character("Bandit", 11, 11, "2d8+2", "30 ft.", 0,
                        11, 12, 12, 10, 10, 10, CharacterType.HUMANOID, Set.of()).
                        equipArmor(getArmorByID(2L)).equipMeleeWeapon(getMeleeWeaponByID(16L)).equipRangedWeapon(getRangedWeaponByID(1L)),
                new Character("Bandit Captain", 13, 65, "10d8+20", "30 ft.", 2,
                        15, 16, 14, 14, 11, 14, CharacterType.HUMANOID,
                        Set.of(SkillType.ATHLETICS, SkillType.DECEPTION)).
                        equipArmor(getArmorByID(3L)).equipMeleeWeapon(getMeleeWeaponByID(16L)),
                new Character("Banshee", 12, 58, "13d8", "0 ft., fly 40 ft. (hover)", 4,
                        1, 14, 10, 12, 11, 17, CharacterType.UNDEAD, Set.of()),
                new Character("Barbed Devil", 15, 110, "13d8+52", "30 ft.", 5,
                        16, 17, 18, 12, 14, 14, CharacterType.FIEND,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT, SkillType.PERCEPTION)),
                new Character("Basilisk", 15, 52, "8d8+16", "20 ft.", 3,
                        16, 8, 15, 2, 8, 7, CharacterType.MONSTROSITY, Set.of()),
                new Character("Bat", 12, 1, "1d4-1", "5 ft., fly 30 ft.", 0,
                        2, 15, 8, 2, 12, 4, CharacterType.BEAST, Set.of()),
                new Character("Bearded Devil", 13, 52, "8d8+16", "30 ft.", 3,
                        16, 15, 15, 9, 11, 11, CharacterType.FIEND, Set.of()),
                new Character("Behir", 17, 168, "16d12+64", "50 ft., climb 40 ft.", 11,
                        23, 16, 18, 7, 14, 12, CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Berserker", 11, 67, "9d8+27", "30 ft.", 2,
                        16, 12, 17, 9, 11, 9, CharacterType.HUMANOID, Set.of()).
                        equipArmor(getArmorByID(2L)).equipMeleeWeapon(getMeleeWeaponByID(12L)),
                new Character("Black Bear", 11, 19, "3d8+6", "40 ft., climb 30 ft.", 1,
                        15, 10, 14, 2, 12, 7, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Black Dragon Wyrmling", 17, 33, "6d8+6", "30 ft., fly 60 ft., swim 30 ft.", 2,
                        15, 14, 13, 10, 11, 13, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Black Pudding", 7, 85, "10d10+30", "20 ft., climb 20 ft.", 4,
                        16, 5, 16, 1, 6, 1, CharacterType.OOZE, Set.of()),
                new Character("Blink Dog", 13, 22, "4d8+4", "40 ft.", 0,
                        12, 17, 12, 10, 13, 11, CharacterType.FEY,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Blood Hawk", 12, 7, "2d6", "10 ft., fly 60 ft.", 0,
                        6, 14, 10, 3, 14, 5, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Blue Dragon Wyrmling", 17, 52, "8d8+16", "30 ft., burrow 15 ft., fly 60 ft.", 3,
                        17, 10, 15, 12, 11, 15, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Boar", 11, 11, "2d8+2", "40 ft.", 0,
                        13, 11, 12, 2, 9, 5, CharacterType.BEAST, Set.of()),
                new Character("Bone Devil", 19, 142, "15d10+60", "40 ft., fly 40 ft.", 9,
                        18, 16, 18, 13, 14, 16, CharacterType.FIEND,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT)),
                new Character("Brass Dragon Wyrmling", 16, 16, "3d8+3", "30 ft., burrow 15 ft., fly 60 ft.", 1,
                        15, 10, 13, 10, 11, 13, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Bronze Dragon Wyrmling", 17, 32, "5d8+10", "30 ft., fly 60 ft., swim 30 ft.", 2,
                        17, 10, 15, 12, 11, 15, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Brown Bear", 11, 34, "4d10+12", "40 ft., climb 30 ft.", 1,
                        19, 10, 16, 2, 13, 7, CharacterType.BEAST, Set.of(SkillType.PERCEPTION)),
                new Character("Bugbear", 12, 27, "5d8+5", "30 ft.", 1,
                        15, 14, 13, 8, 11, 9, CharacterType.HUMANOID,
                        Set.of(SkillType.STEALTH, SkillType.SURVIVAL)).
                        equipArmor(getArmorByID(4L)).equipMeleeWeapon(getMeleeWeaponByID(5L)),
                new Character("Bulette", 17, 94, "9d10+45", "40 ft., burrow 40 ft.", 5,
                        19, 11, 21, 2, 10, 5, CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Camel", 9, 15, "2d10+4", "50 ft.", 0,
                        16, 8, 14, 2, 8, 5, CharacterType.BEAST, Set.of()),
                new Character("Cat", 12, 2, "1d4", "40 ft., climb 30 ft.", 0,
                        3, 15, 10, 3, 12, 7, CharacterType.BEAST, Set.of()),
                new Character("Centaur", 12, 45, "6d10+12", "50 ft.", 2,
                        18, 14, 14, 9, 13, 11, CharacterType.MONSTROSITY,
                        Set.of(SkillType.ATHLETICS, SkillType.PERCEPTION, SkillType.SURVIVAL)),
                new Character("Chain Devil", 16, 85, "10d8+40", "30 ft.", 8,
                        18, 15, 18, 11, 12, 14, CharacterType.FIEND,Set.of()),
                new Character("Chimera", 14, 114, "12d10+48", "30 ft., fly 60 ft.", 6,
                        19, 11, 19, 3, 14, 10, CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Chuul", 16, 93, "11d10+33", "30 ft., swim 30 ft.", 4,
                        19, 10, 16, 5, 11, 5, CharacterType.ABERRATION,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Clay Golem", 14, 133, "14d10+56", "20 ft.", 9,
                        20, 9, 18, 3, 8, 1, CharacterType.CONSTRUCT, Set.of()),
                new Character("Cloaker", 14, 78, "12d10+12", "10 ft., fly 40 ft.", 8,
                        17, 15, 12, 13, 12, 14, CharacterType.ABERRATION, Set.of(SkillType.STEALTH)),
                new Character("Cloud Giant", 14, 200, "16d12+96", "40 ft.", 9,
                        27, 10, 22, 12, 16, 16, CharacterType.GIANT,
                        Set.of(SkillType.INSIGHT, SkillType.PERCEPTION)),
                new Character("Cockatrice", 11, 27, "6d6+6", "20 ft., fly 40 ft.", 1,
                        6, 12, 12, 2, 13, 5, CharacterType.MONSTROSITY, Set.of()),
                new Character("Commoner", 10, 4, "1d8", "30 ft.", 0,
                        10, 10, 10, 10, 10, 10, CharacterType.HUMANOID, Set.of()).
                        equipMeleeWeapon(getMeleeWeaponByID(1L)),
                new Character("Constrictor Snake", 12, 13, "2d10+2", "30 ft., swim 30 ft.", 0,
                        15, 14, 12, 1, 10, 3, CharacterType.BEAST, Set.of()),
                new Character("Copper Dragon Wyrmling", 16, 22, "4d8+4", "30 ft., climb 30 ft., fly 60 ft.", 1,
                        15, 12, 13, 14, 11, 13, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Coatl", 19, 97, "13d8+39", "30 ft., fly 90 ft.", 4,
                        16, 20, 17, 18, 20, 18, CharacterType.CELESTIAL, Set.of()),
                new Character("Crab", 11, 2, "1d4", "20 ft., swim 20 ft.", 0,
                        2, 11, 10, 1, 8, 2, CharacterType.BEAST,
                        Set.of(SkillType.STEALTH)),
                new Character("Crocodile", 12, 19, "3d10+3", "20 ft., swim 30 ft.", 1,
                        15, 10, 13, 2, 10, 5, CharacterType.BEAST,
                        Set.of(SkillType.STEALTH)),
                new Character("Cult Fanatic", 11, 33, "6d8+6", "30 ft.", 2,
                        11, 14, 12, 10, 13, 14, CharacterType.HUMANOID,
                        Set.of(SkillType.DECEPTION,SkillType.PERSUASION, SkillType.RELIGION),4).
                        equipArmor(getArmorByID(2L)).equipMeleeWeapon(getMeleeWeaponByID(2L)),
                new Character("Cultist", 10, 9, "2d8", "30 ft.", 0,
                        11, 12, 10, 10, 11, 10, CharacterType.HUMANOID,
                        Set.of(SkillType.DECEPTION, SkillType.RELIGION)).
                        equipArmor(getArmorByID(2L)).equipMeleeWeapon(getMeleeWeaponByID(16L)),
                new Character("Cyclops", 14, 138, "12d12+60", "30 ft.", 6,
                        22, 11, 20, 8, 6, 10, CharacterType.GIANT, Set.of()).
                        equipMeleeWeapon(getMeleeWeaponByID(3L)),
                new Character("Darkmantle", 11, 22, "5d6+5", "10 ft., fly 30 ft.", 1,
                        16, 12, 13, 2, 10, 5, CharacterType.MONSTROSITY,
                        Set.of(SkillType.STEALTH)),

                //ide jön Áron része

                new Character("Grimlock", 11, 11, "2d8+2", "30 ft.", 0,
                        16, 12, 12, 9, 8, 6, CharacterType.HUMANOID,
                        Set.of(SkillType.ATHLETICS, SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Guard", 11, 11, "2d8+2", "30 ft.", 0,
                        13, 12, 12, 10, 11, 10, CharacterType.HUMANOID,
                        Set.of(SkillType.PERCEPTION)).equipArmor(getArmorByID(5L)).equipMeleeWeapon(getMeleeWeaponByID(10L)),
                new Character("Guardian Naga", 18, 127, "15d10+45", "40 ft.", 10,
                        19, 18, 16, 16, 19, 18, CharacterType.MONSTROSITY,
                        Set.of(), 10),
                new Character("Gynosphinx", 17, 136, "16d10+48", "40 ft., fly 60 ft.", 11,
                        18, 15, 16, 18, 18, 18, CharacterType.MONSTROSITY,
                        Set.of(SkillType.ARCANA, SkillType.HISTORY, SkillType.PERCEPTION, SkillType.RELIGION), 9),
                new Character("Half-Red Dragon Veteran", 11, 65, "10d8+20", "30 ft.", 5,
                        16, 13, 14, 10, 11, 10, CharacterType.HUMANOID,
                        Set.of(SkillType.ATHLETICS, SkillType.PERCEPTION))
                        .equipArmor(getArmorByID(12L)).equipRangedWeapon(getRangedWeaponByID(7L)).equipMeleeWeapon(getMeleeWeaponByID(14L)),
                new Character("Harpy", 11, 38, "7d8+7", "20 ft., fly 40 ft.", 1,
                        12, 13, 12, 7, 10, 13, CharacterType.MONSTROSITY,
                        Set.of()),
                new Character("Hawk", 13, 1, "1d4", "10 ft., fly 60 ft.", 0,
                        5, 16, 8, 2, 14, 6, CharacterType.BEAST,
                        Set.of()),
                new Character("Hell Hound", 15, 45, "7d8+14", "50 ft.", 3,
                        17, 12, 14, 6, 13, 6, CharacterType.FIEND,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Hezrou", 16, 136, "13d10+65", "30 ft.", 8,
                        19, 17, 20, 5, 12, 13, CharacterType.FIEND,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Hill Giant", 13, 105, "10d12+40", "40 ft.", 5,
                        21, 8, 19, 5, 9, 6, CharacterType.GIANT,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Hippogriff", 11, 19, "3d10+3", "40 ft., fly 60 ft.", 1,
                        17, 13, 13, 2, 12, 8, CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Hobgoblin", 11, 11, "2d8+2", "30 ft.", 1,
                        13, 12, 12, 10, 10, 9, CharacterType.HUMANOID,
                        Set.of()),
                new Character("Homunculus", 13, 5, "2d4", "20 ft., fly 40 ft.", 0,
                        4, 15, 11, 10, 10, 7, CharacterType.CONSTRUCT,
                        Set.of()),
                new Character("Horned Devil", 18, 178, "17d10+85", "20 ft., fly 60 ft.", 11,
                        22, 17, 21, 12, 16, 17, CharacterType.FIEND,
                        Set.of()),
                new Character("Hunter Shark", 12, 45, "6d10+12", "0 ft., swim 60 ft.", 2,
                        18, 13, 15, 1, 10, 4, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Hydra", 15, 172, "15d12+75", "30 ft., swim 30 ft.", 8,
                        20, 12, 20, 2, 10, 7, CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Hyena", 11, 5, "1d8+1", "50 ft.", 0,
                        11, 13, 12, 2, 12, 5, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Ice Devil", 18, 180, "19d10+76", "40 ft.", 14,
                        21, 14, 18, 18, 15, 18, CharacterType.FIEND,
                        Set.of()),
                new Character("Ice Mephit", 11, 21, "6d6", "30 ft., fly 30 ft.", 1,
                        7, 13, 10, 9, 11, 12, CharacterType.ELEMENTAL,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Imp", 13, 10, "3d4+3", "20 ft., fly 40 ft.", 1,
                        6, 17, 13, 11, 12, 14, CharacterType.FIEND,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Incubus", 15, 66, "12d8+12", "30 ft., fly 60 ft.", 4,
                        8, 17, 13, 15, 12, 20, CharacterType.FIEND,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT, SkillType.PERCEPTION, SkillType.PERSUASION, SkillType.STEALTH)),
                new Character("Invisible Stalker", 14, 104, "16d8+32", "50 ft., fly 50 ft. (hover)", 6,
                        16, 19, 14, 10, 15, 11, CharacterType.ELEMENTAL,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Iron Golem", 20, 210, "20d10+100", "30 ft.", 16,
                        24, 9, 20, 3, 11, 1, CharacterType.CONSTRUCT,
                        Set.of()),
                new Character("Jackal", 12, 3, "1d6", "40 ft.", 0,
                        8, 15, 11, 3, 12, 6, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Killer Whale", 12, 90, "12d12+12", "0 ft., swim 60 ft.", 3,
                        19, 10, 13, 3, 12, 7, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Knight", 10, 52, "8d8+6", "30 ft.", 3,
                        16, 11, 14, 11, 11, 15, CharacterType.HUMANOID,
                        Set.of())
                        .equipMeleeWeapon(getMeleeWeaponByID(13L)).equipArmor(getArmorByID(12L)).equipRangedWeapon(getRangedWeaponByID(7L)),
                new Character("Kobold", 12, 5, "2d6", "30 ft.", 0,
                        7, 15, 9, 8, 7, 8, CharacterType.HUMANOID,
                        Set.of()).equipRangedWeapon(getRangedWeaponByID(4L)).equipMeleeWeapon(getMeleeWeaponByID(2L)),
                new Character("Kraken", 18, 472, "27d20+189", "20 ft., swim 60 ft.", 23,
                        30, 11, 25, 22, 18, 20, CharacterType.MONSTROSITY,
                        Set.of()),
                new Character("Lamia", 13, 97, "13d10+26", "30 ft.", 4,
                        16, 13, 15, 14, 15, 16, CharacterType.MONSTROSITY,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT, SkillType.STEALTH)),
                new Character("Lemure", 7, 13, "3d8", "15 ft.", 0,
                        10, 5, 11, 1, 11, 3, CharacterType.FIEND,
                        Set.of()),
                new Character("Lich", 17, 135, "18d8+54", "30 ft.", 21,
                        11, 16, 16, 20, 14, 16, CharacterType.UNDEAD,
                        Set.of(SkillType.ARCANA, SkillType.HISTORY, SkillType.INSIGHT, SkillType.PERCEPTION),18),
                new Character("Lion", 12, 26, "4d10+4", "50 ft.", 1,
                        17, 15, 13, 3, 12, 8, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Lizard", 10, 2, "1d4", "20 ft., climb 20 ft.", 0,
                        2, 11, 10, 1, 8, 3, CharacterType.BEAST,
                        Set.of()),
                new Character("Lizardfolk", 10, 22, "4d8+4", "30 ft., swim 30 ft.", 0,
                        15, 10, 13, 7, 12, 7, CharacterType.HUMANOID,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH, SkillType.SURVIVAL))
                        .equipMeleeWeapon(getMeleeWeaponByID(3L)).equipRangedWeapon(getRangedWeaponByID(5L)),
                new Character("Mage", 12, 40, "9d8", "30 ft.", 6,
                        9, 14, 11, 17, 12, 11, CharacterType.HUMANOID,
                        Set.of(SkillType.ARCANA, SkillType.HISTORY), 9),
                new Character("Magma Mephit", 11, 22, "5d6+5", "30 ft., fly 30 ft.", 1,
                        8, 12, 12, 7, 10, 10, CharacterType.ELEMENTAL,
                        Set.of()),
                new Character("Magmin", 14, 9, "2d6+2", "30 ft.", 1,
                        7, 15, 12, 8, 11, 10, CharacterType.ELEMENTAL,
                        Set.of()),
                new Character("Mammoth", 13, 126, "11d12+5", "40 ft.", 6,
                        24, 9, 21, 3, 11, 6, CharacterType.BEAST,
                        Set.of()),
                new Character("Manticore", 14, 68, "8d10+24", "30 ft., fly 50 ft.", 3,
                        17, 16, 17, 7, 12, 8, CharacterType.MONSTROSITY,
                        Set.of()),
                new Character("Marilith", 18, 189, "18d10+90", "40 ft.", 16,
                        18, 20, 20, 18, 16, 20, CharacterType.FIEND,
                        Set.of()),
                new Character("Mastiff", 12, 5, "1d8+1", "40 ft.", 0,
                        13, 14, 12, 3, 12, 7, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Medusa", 15, 127, "17d8+51", "30 ft.", 6,
                        10, 15, 16, 12, 13, 15, CharacterType.MONSTROSITY,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT, SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Merfolk", 11, 11, "2d8+2", "10 ft., swim 40 ft.", 0,
                        10, 13, 12, 11, 11, 12, CharacterType.HUMANOID,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Merrow", 13, 45, "6d10+12", "10 ft., swim 40 ft.", 2,
                        18, 10, 15, 8, 10, 9, CharacterType.MONSTROSITY,
                        Set.of()),
                new Character("Mimic", 12, 58, "9d8+18", "15 ft.", 2,
                        17, 12, 15, 5, 13, 8, CharacterType.MONSTROSITY,
                        Set.of(SkillType.STEALTH)),
                new Character("Minotaur", 14, 76, "9d10+27", "40 ft.", 3,
                        18, 11, 16, 6, 16, 9, CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Minotaur Skeleton", 12, 67, "9d10+18", "40 ft.", 2,
                        18, 11, 16, 6, 8, 5, CharacterType.UNDEAD,
                        Set.of()),
                new Character("Mule", 10, 11, "2d8+2", "40 ft.", 0,
                        14, 10, 13, 2, 10, 5, CharacterType.BEAST,
                        Set.of()),
                new Character("Mummy", 11, 58, "9d8+18", "20 ft.", 3,
                        16, 8, 15, 6, 10, 12, CharacterType.UNDEAD,
                        Set.of()),
                new Character("Mummy Lord", 17, 97, "13d8+39", "20 ft.", 15,
                        18, 10, 17, 11, 18, 16, CharacterType.UNDEAD,
                        Set.of(SkillType.HISTORY, SkillType.RELIGION), 10),
                new Character("Nalfeshnee", 18, 184, "16d10+96", "20 ft., fly 30 ft.", 13,
                        21, 10, 22, 19, 12, 15, CharacterType.FIEND,
                        Set.of()),
                new Character("Night Hag", 17, 112, "15d8+45", "30 ft.", 15,
                        18, 15, 16, 16, 14, 16, CharacterType.FIEND,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT, SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Nightmare", 13, 68, "8d10+24", "60 ft., fly 90 ft.", 3,
                        18, 15, 16, 10, 13, 15, CharacterType.FIEND,
                        Set.of()),
                new Character("Noble", 11, 9, "2d8", "30 ft.", 0,
                        11, 12, 10, 12, 14, 16, CharacterType.HUMANOID,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT, SkillType.PERCEPTION)).equipArmor(getArmorByID(12L)).equipMeleeWeapon(getMeleeWeaponByID(16L)),
                new Character("Nothic", 15, 45, "6d8+18", "30 ft.", 2,
                        14, 16, 16, 13, 10, 8, CharacterType.ABERRATION,
                        Set.of(SkillType.ARCANA, SkillType.INSIGHT, SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Ochre Jelly", 8, 45, "6d10+12", "10 ft., climb 10 ft.", 2,
                        15, 6, 14, 2, 6, 1, CharacterType.OOZE,
                        Set.of()),
                new Character("Octopus", 12, 3, "1d6", "5 ft., swim 30 ft.", 0,
                        4, 15, 11, 3, 10, 4, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Ogre", 11, 59, "7d10+21", "40 ft.", 2,
                        19, 8, 16, 5, 7, 7, CharacterType.GIANT,
                        Set.of()),
                new Character("Ogre Zombie", 8, 85, "9d10+36", "30 ft.", 2,
                        19, 6, 18, 3, 6, 5, CharacterType.UNDEAD,
                        Set.of()),
                new Character("Oni", 16, 110, "13d10+39", "30 ft., fly 30 ft.", 7,
                        19, 11, 16, 14, 12, 15, CharacterType.GIANT,
                        Set.of(SkillType.ARCANA, SkillType.DECEPTION, SkillType.PERCEPTION)),
                new Character("Orc", 11, 15, "2d8+6", "30 ft.", 1,
                        16, 12, 16, 7, 11, 10, CharacterType.HUMANOID,
                        Set.of(SkillType.INSIGHT))
                        .equipArmor(getArmorByID(4L)).equipMeleeWeapon(getMeleeWeaponByID(12L)).equipRangedWeapon(getRangedWeaponByID(3L)),
                new Character("Otyugh", 14, 114, "12d10+48", "30 ft.", 5,
                        16, 11, 19, 6, 13, 6, CharacterType.ABERRATION,
                        Set.of()),
                new Character("Owl", 11, 1, "1d4", "5 ft., fly 60 ft.", 0,
                        3, 13, 8, 2, 12, 7, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Owlbear", 13, 59, "7d10+21", "40 ft.", 3,
                        20, 12, 17, 3, 12, 7, CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Panther", 12, 13, "3d8", "50 ft., climb 40 ft.", 0,
                        14, 15, 10, 3, 14, 7, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Pegasus", 12, 59, "7d10+21", "60 ft., fly 90 ft.", 2,
                        18, 15, 16, 10, 15, 13, CharacterType.CONSTRUCT,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Phase Spider", 13, 32, "5d10+5", "30 ft., climb 30 ft.", 3,
                        15, 15, 12, 6, 10, 6, CharacterType.MONSTROSITY,
                        Set.of(SkillType.STEALTH)),
                new Character("Pit Fiend", 19, 300, "24d10+168", "30 ft., fly 60 ft.", 20,
                        26, 14, 24, 22, 18, 24, CharacterType.FIEND,
                        Set.of()),
                new Character("Planetar", 19, 200, "16d10+112", "40 ft., fly 120 ft.", 16,
                        24, 20, 24, 19, 22, 25, CharacterType.CONSTRUCT,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Plesiosaurus", 13, 68, "8d10+24", "20 ft., swim 40 ft.", 2,
                        18, 15, 16, 2, 12, 5, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Poisonous Snake", 13, 2, "1d4", "30 ft., swim 30 ft.", 0,
                        2, 16, 11, 1, 10, 3, CharacterType.BEAST,
                        Set.of()),
                new Character("Polar Bear", 12, 42, "5d10", "40 ft., swim 30 ft.", 2,
                        20, 10, 16, 2, 13, 7, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Pony", 10, 11, "2d8+2", "40 ft.", 0,
                        15, 10, 13, 2, 11, 7, CharacterType.BEAST,
                        Set.of()),
                new Character("Priest", 10, 27, "5d8+5", "30 ft.", 2,
                        10, 10, 12, 13, 16, 13, CharacterType.HUMANOID,
                        Set.of(SkillType.MEDICINE, SkillType.PERCEPTION, SkillType.RELIGION),5)
                        .equipArmor(getArmorByID(5L)).equipMeleeWeapon(getMeleeWeaponByID(7L)),
                new Character("Pseudodragon", 13, 7, "2d4+2", "15 ft., fly 60 ft.", 0,
                        6, 15, 13, 10, 12, 10, CharacterType.DRAGON,
                        Set.of(SkillType.PERCEPTION, SkillType.STEALTH)),
                new Character("Pteranodon", 13, 13, "3d8", "10 ft., fly 60 ft.", 0,
                        12, 15, 10, 2, 9, 5, CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Purple Worm", 18, 247, "15d20+90", "50 ft., burrow 30 ft.", 15,
                        28, 7, 22, 1, 8, 4, CharacterType.MONSTROSITY,
                        Set.of()),
                new Character("Quasit", 13, 7, "3d4", "40 ft.", 1,
                        5, 17, 10, 7, 10, 10, CharacterType.FIEND,
                        Set.of(SkillType.STEALTH)),
                new Character("Quipper", 13, 1, "1d4", "0 ft., swim 40 ft.", 0,
                        2, 16, 9, 1, 7, 2, CharacterType.BEAST,
                        Set.of()),
                new Character("Rakshasa", 16, 110, "13d8", "40 ft.", 13,
                        14, 17, 18, 13, 16, 20, CharacterType.FIEND,
                        Set.of(SkillType.DECEPTION, SkillType.INSIGHT))
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
