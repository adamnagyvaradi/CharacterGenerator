package com.example.charactergenerator.service;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.*;
import com.example.charactergenerator.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncounterService {
    private CharacterService characterService;
    private ArmorService armorService;
    private MeleeWeaponService meleeWeaponService;
    private RangedWeaponService rangedWeaponService;
    private long lastId = 0;
    private Encounter encounter = new Encounter();

    @Autowired
    public void setCharacterService(CharacterService characterService) {
        this.characterService = characterService;
    }

    @Autowired
    public void setArmorService(ArmorService armorService) {
        this.armorService = armorService;
    }

    @Autowired
    public void setMeleeWeaponService(MeleeWeaponService meleeWeaponService) {
        this.meleeWeaponService = meleeWeaponService;
    }

    @Autowired
    public void setRangedWeaponService(RangedWeaponService rangedWeaponService) {
        this.rangedWeaponService = rangedWeaponService;
    }

    public void addCharacter(Character character){
        character.setId(++lastId);
        encounter.addCharacter(character);
    }

    public void addCharacter(long id){
        Character character = characterService.findById(id);
        addCharacter(character);
    }

    public List<Character> getAllCharacter(){
        return encounter.getCharacters();
    }

    public Character findCharacterById(Long id){
        if (id == null){
            return getAllCharacter().get(0);
        }

        return encounter.findById(id);
    }

    public void removeCharacterById(long id){
        encounter.removeCharacterById(id);
    }

    public void updateCharacter(CharacterDto characterDto){
        Character character = findCharacterById(characterDto.getId());

        character.setName(characterDto.getName());
        character.setHitPoints(characterDto.getHitPoints());
        character.setArmorClass(characterDto.getArmorClass());
        character.setSpeed(characterDto.getSpeed());
        character.setChallengeRating(characterDto.getChallengeRating());
        character.setAttributeValue(AttributeType.STR, characterDto.getStrength());
        character.setAttributeValue(AttributeType.DEX, characterDto.getDexterity());
        character.setAttributeValue(AttributeType.CON, characterDto.getConstitution());
        character.setAttributeValue(AttributeType.INT, characterDto.getIntelligence());
        character.setAttributeValue(AttributeType.WIS, characterDto.getWisdom());
        character.setAttributeValue(AttributeType.CHA, characterDto.getCharisma());

        String casterLevel = characterDto.getCasterLevel();
        if (!casterLevel.equals("non-caster")){
            character.setCasterLevel(Integer.parseInt(casterLevel));
        }else{
            character.setCasterLevel(null);
        }

        String armorId = characterDto.getArmor();
        if (armorId != null && !armorId.equals("no-armor-selected")){
            Armor armor = armorService.findById(armorId);
            character.equipArmor(armor);
        } else {
            character.setArmor(null);
        }

        String meleeWeaponId = characterDto.getMeleeWeapon();
        if (meleeWeaponId != null && !meleeWeaponId.equals("no-melee-weapon-selected")){
            MeleeWeapon meleeWeapon = meleeWeaponService.findById(meleeWeaponId);
            character.equipMeleeWeapon(meleeWeapon);
        } else {
            character.setMeleeWeapon(null);
        }

        String rangedWeaponId = characterDto.getRangedWeapon();
        if (rangedWeaponId != null && !rangedWeaponId.equals("no-ranged-weapon-selected")){
            RangedWeapon rangedWeapon = rangedWeaponService.findById(rangedWeaponId);
            character.equipRangedWeapon(rangedWeapon);
        } else {
            character.setRangedWeapon(null);
        }
    }

    public void saveEncounter(){
        encounter.setEditable(false);
    }

    public boolean isEncounterEditable() {
        return encounter.isEditable();
    }
}
