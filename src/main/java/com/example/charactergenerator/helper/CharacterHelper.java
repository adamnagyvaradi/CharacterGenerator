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
                new Character("Aboleth",17, 135,"18d10+36","10",10,
                        21,9,15,18,15,18,CharacterType.ABERRATION, Set.of(SkillType.HISTORY, SkillType.PERCEPTION)),
                new Character("Acolyte",10, 9,"2d8","30",0,
                        10,10,10,10,14,11,CharacterType.HUMANOID,Set.of(SkillType.MEDICINE, SkillType.RELIGION),1),
                new Character("Air Elemental",15, 90, "d10", "0", 4,
                        14,20,14,6,10,6,CharacterType.ELEMENTAL,new HashSet<>()),
                new Character("Allosaurus",13, 51, "d10", "60", 2,
                        19,13,17,2,12,5,CharacterType.BEAST,Set.of(SkillType.PERCEPTION)),
                new Character("Animated Armor",18, 33, "d10", "25", 4,
                        14,11,13,1,3,1,CharacterType.CONSTRUCT,new HashSet<>()),
                new Character("Ankheg",14, 39, "d10", "30", 10,
                        17, 11, 13, 1, 13, 6,CharacterType.MONSTROSITY, new HashSet<>()),
                new Character("Ankylosaurus",15, 68, "d10", "30", 16,
                        19,11,15,2,12,5,CharacterType.BEAST, new HashSet<>()),
                new Character("Hobgoblin", 10, 7, "d10", "8", 4, 4, 4, 8,
                        11, 4, 4, CharacterType.HUMANOID, new HashSet<>()),
                new Character("Giant Skeleton", 10, 7, "d10", "8", 4, 4, 4,  8,
                        11, 4, 4, CharacterType.UNDEAD, new HashSet<>()),
                new Character("Aarakocra", 10, 7, "d10", "8", 4, 4, 4, 8,
                        11, 4, 4, CharacterType.ABERRATION, new HashSet<>()),
                new Character("Bandit", 10, 7, "d10", "8", 4, 4, 4, 8,
                        11, 4, 4, CharacterType.HUMANOID,new HashSet<>()),
                new Character("Bandit Captain", 10, 7, "d10", "8", 4, 4, 4, 8,
                        11, 4, 4, CharacterType.HUMANOID, new HashSet<>())
                        .equipArmor(getArmorByID(3L)).equipMeleeWeapon(getMeleeWeaponByID(3L)).equipRangedWeapon(getRangedWeaponByID(3L)),
                new Character("Drow Inquisitor", 10, 7, "d10", "8", 4, 4, 4, 8,
                        11, 4, 4,  CharacterType.HUMANOID, new HashSet<>()),
                new Character("Grimlock", 11, 11, "d10", "30", 2, 16, 12, 12,
                        9, 8, 6, CharacterType.BEAST, new HashSet<>()),
                new Character("Merfolk", 11, 11, "d10", "10", 2, 10, 13, 12,
                        11, 11, 12, CharacterType.HUMANOID, new HashSet<>()),
                new Character("Tribal Warrior", 12, 11, "d10", "30", 2, 13, 11,
                        12, 8, 11, 8, CharacterType.HUMANOID, new HashSet<>())
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
