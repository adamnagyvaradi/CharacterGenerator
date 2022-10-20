package com.example.charactergenerator.helper;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.*;
import com.example.charactergenerator.service.ArmorService;
import com.example.charactergenerator.service.CharacterService;
import com.example.charactergenerator.service.MeleeWeaponService;
import com.example.charactergenerator.service.RangedWeaponService;
import com.sun.source.doctree.SeeTree;
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
                new Character("Death Dog",12,39,"6d8+12", "40 ft.,",1,
                        15,14,14,3,13,6,CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION,SkillType.STEALTH)),
                new Character("Deep Gnome",12,16,"3d6+6,","20 ft",1,
                        15,14,14,12,10,9,CharacterType.HUMANOID,
                        Set.of(SkillType.INVESTIGATION,SkillType.PERCEPTION,SkillType.STEALTH)).equipArmor(getArmorByID(5l)),
                new Character("Deer",13,4,"1d8","50ft",0,
                        11,16,11,2,14,5,CharacterType.BEAST,
                        Set.of()),
                new Character("Deva",14,136,"16d8+64","30 ft., fly 90 ft.",10,
                        18,18,18,17,20,20,CharacterType.CELESTIAL,
                        Set.of(SkillType.INSIGHT,SkillType.PERCEPTION)).equipMeleeWeapon(getMeleeWeaponByID(7l)),
                new Character("Dire Wolf",14,37,"5d10+10","50ft",1,
                        17,15,15,3,12,7,CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION,SkillType.STEALTH)),
                new Character("Diseased Giant Rat",12,7,"2d6","30 ft.",0,
                        7,15,11,2,10,4,CharacterType.BEAST,
                        Set.of()),
                new Character("Djinni",17,161,"14d10+84","30 ft., fly 90 ft.",11,
                        21,15,22,15,16,20,CharacterType.ELEMENTAL,
                        Set.of()).equipMeleeWeapon(getMeleeWeaponByID((16l))),
                new Character("Doppelganger",14,52,"8d8+16","30 ft.",3,
                        11,18,14,11,12,14,CharacterType.MONSTROSITY,
                        Set.of(SkillType.DECEPTION,SkillType.INSIGHT)),
                new Character("Draft Horse",10,19,"3d10+3","40ft.",0,
                        18,10,12,2,11,7,CharacterType.BEAST,
                        Set.of()),
                new Character("Dragon Turtle",20,341,"22d20+110","20 ft., swim 40 ft.",17,
                        25,10,20,10,12,12,CharacterType.DRAGON,
                        Set.of()),
                new Character("Dretch",11,18,"4d6+4","20 ft.",0,
                        11,11,12,5,8,3,CharacterType.FIEND,
                        Set.of()),
                new Character("Drider",19,123,"13d10+52","30 ft., climb 30 ft.",6,
                        16,16,18,13,14,12,CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION,SkillType.STEALTH)),
                new Character("Drow",12,13,"3d8","30 ft",0,
                        10,14,10,11,11,12,CharacterType.HUMANOID,
                        Set.of(SkillType.PERCEPTION,SkillType.STEALTH)).equipArmor(getArmorByID((5l))).equipRangedWeapon(getRangedWeaponByID((6l))),
                new Character("Druid",11,27,"5d8","30 ft.",2,
                        10,12,13,12,15,11,CharacterType.HUMANOID,
                        Set.of(SkillType.MEDICINE,SkillType.NATURE,SkillType.PERCEPTION)),
                new Character("Dryad",11,22,"5d8,","30 ft.",1,
                        10,12,11,14,15,18,CharacterType.FEY,
                        Set.of(SkillType.PERCEPTION,SkillType.STEALTH)).equipMeleeWeapon(getMeleeWeaponByID((1l))),
                new Character("Duergar",12,26,"4d8+8","25 ft.",1,
                        14,11,14,11,10,9,CharacterType.HUMANOID,
                        Set.of()).equipMeleeWeapon(getMeleeWeaponByID((5l))).equipArmor(getArmorByID((6l))),
                new Character("Dust Devil",15,90,"12d10+24,","50 ft.",5,
                        14,20,14,1,10,1,CharacterType.ELEMENTAL,
                        Set.of()),
                new Character("Dust Mephit",12,17,"5d6","30 ft., fly 30 ft.",1,
                        5,14,10,9,11,10,CharacterType.ELEMENTAL,
                        Set.of(SkillType.PERCEPTION,SkillType.STEALTH)),
                new Character("Eagle",12,3,"1d6","10 ft., fly 60 ft.",0,
                        6,15,10,2,14,7,CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Earth Elemental",17,126,"12d10+60","30 ft., burrow 30 ft.",5,
                        20,8,20,5,10,5,CharacterType.ELEMENTAL,
                        Set.of()),
                new Character("Efreeti",17,200,"16d10+112","40 ft., fly 60 ft.",11,
                        22,12,24,16,15,16,CharacterType.ELEMENTAL,
                        Set.of()),
                new Character("Elephant",12,76,"8d12+24","40 ft.",4,
                        22,9,17,3,11,6,CharacterType.BEAST,
                        Set.of()),
                new Character("Elk",10,13,"2d10+2","50 ft.",0,
                        16,10,12,2,10,6,CharacterType.BEAST,
                        Set.of()),
                new Character("Erinyes",13,153,"18d8+72","30 ft., fly 60 ft.",12,
                        18,16,18,14,14,18,CharacterType.FIEND,
                        Set.of()).equipArmor(getArmorByID((12l))).equipRangedWeapon(getRangedWeaponByID((8l))),
                new Character("Ettercap",13,44,"8d8+8","30 ft., climb 30 ft.",2,
                        14,15,13,7,12,8,CharacterType.MONSTROSITY,
                        Set.of(SkillType.PERCEPTION,SkillType.SURVIVAL,SkillType.STEALTH)),
                new Character("Ettin",12,85,"10d10+30","40 ft.",4,
                        21,8,17,6,10,8,CharacterType.GIANT,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Fire Elemental",13,102,"12d10+36","50 ft.",5,
                        10,17,16,6,10,7,CharacterType.ELEMENTAL,
                        Set.of()),
                new Character("Fire Giant",9,162,"13d12+78","30 ft.",9,
                        25,9,23,10,14,13,CharacterType.GIANT,
                        Set.of(SkillType.ATHLETICS,SkillType.PERCEPTION)),
                new Character("Flameskull",13,40,"9d4+18","0 ft., fly 40 ft. (hover)",4,
                        1,17,14,16,10,11,CharacterType.UNDEAD,
                        Set.of(SkillType.ARCANA,SkillType.PERCEPTION)),
                new Character("Flesh Golem",9,93,"11d8+44","30 ft.",5,
                        19,9,18,6,10,5,CharacterType.CONSTRUCT,
                        Set.of()),
                new Character("Flying Snake",14,5,"2d4","30 ft., fly 60 ft., swim 30 ft.",0,
                        4,18,11,2,12,5,CharacterType.BEAST,
                        Set.of()),
                new Character("Flying Sword",17,17,"5d6","0 ft., fly 50 ft. (hover)",0,
                        12,15,11,1,5,1,CharacterType.CONSTRUCT,
                        Set.of()).equipMeleeWeapon(getMeleeWeaponByID((14l))),
                new Character("Frog",11,1,"1d4-1","20 ft., swim 20 ft.",0,
                        1,13,8,1,8,3,CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION,SkillType.STEALTH)),
                new Character("Frost Giant",15,138,"12d12+60","40 ft.",8,
                        23,9,21,9,10,12,CharacterType.GIANT,
                        Set.of(SkillType.ATHLETICS,SkillType.PERCEPTION)),
                new Character("Gargoyle",15,52,"7d8+21","30 ft., fly 60 ft.",2,
                        15,11,16,6,11,7,CharacterType.ELEMENTAL,
                        Set.of()),
                new Character("Gelatinous Cube",6,84,"8d10+40","15 ft.",2,
                        14,3,20,1,6,1,CharacterType.OOZE,
                        Set.of()),
                new Character("Ghast",13,36,"8d8","30ft",2,
                        16,17,10,11,10,8,CharacterType.UNDEAD,
                        Set.of()),
                new Character("Ghost",11,45,"10d8","0 ft., fly 40 ft. (hover",4,
                        7,13,10,10,12,17,CharacterType.UNDEAD,
                        Set.of()),
                new Character("Ghoul",12,22,"5d8","30ft.",1,
                        13,15,10,7,10,6,CharacterType.UNDEAD,
                        Set.of()),
                new Character("Giant Ape",12,157,"15d12+60","40 ft., climb 40 ft.",7,
                        23,14,18,7,12,7,CharacterType.BEAST,
                        Set.of(SkillType.ATHLETICS,SkillType.PERCEPTION)),
                new Character("Giant Badger",10,13,"2d8+4","30 ft., burrow 10 ft.",0,
                        13,10,15,2,12,5,CharacterType.BEAST,
                        Set.of()),
                new Character("Giant Rat",13,22,"4d10","10 ft., fly 60 ft.",0,
                        15,16,11,2,12,6,CharacterType.BEAST,
                        Set.of()),
                new Character("Giant Boar",12,42,"5d10+15","40 ft.",2,
                        17,10,16,2,7,5,CharacterType.BEAST,
                        Set.of()),
                new Character("Giant Centipede",13,4,"1d6+1","30 ft., climb 30 ft.",0,
                        5,14,12,1,7,3,CharacterType.BEAST,
                        Set.of()),
                new Character("Giant Constrictor Snake",12,60,"8d12+8","30 ft., swim 30 ft.",2,
                19,14,12,1,10,3,CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Giant Crab",15,13,"3d8","30 ft., swim 30 ft.",0,
                        13,15,11,1,9,3,CharacterType.BEAST,
                        Set.of(SkillType.STEALTH)),
                new Character("Giant Crocodile",14,85,"9d12+27","30 ft., swim 50 ft.",5,
                        21,9,17,2,10,7,CharacterType.BEAST,
                        Set.of(SkillType.STEALTH)),
                new Character("Giant Eagle",13,26,"4d10+4","10 ft., fly 80 ft.",1,
                        16,17,13,8,14,10,CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Giant Elk",14,42,"5d12+10","60 ft.",2,
                        19,16,14,7,14,10,CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION)),
                new Character("Giant Fire Beetle",13,4,"1d6+1","30 ft.",0,
                        8,10,12,1,7,3,CharacterType.BEAST,
                        Set.of()),
                new Character("Giant Frog",11,18,"4d8","30 ft., swim 30 ft.",0,
                        12,13,11,2,10,3,CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION,SkillType.STEALTH)),
                new Character("Giant Goat",11,19,"3d10+3","40 ft.",1,
                        17,11,12,3,12,6,CharacterType.BEAST,
                        Set.of()),
                new Character("Giant Hyena",12,45,"6d10+12","50 ft.",1,
                        16,14,14,2,12,7,CharacterType.BEAST,
                        Set.of(SkillType.PERCEPTION))
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
