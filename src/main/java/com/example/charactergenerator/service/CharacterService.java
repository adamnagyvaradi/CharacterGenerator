package com.example.charactergenerator.service;

import com.example.charactergenerator.dto.CharacterDto;
import com.example.charactergenerator.model.AttributeType;
import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.CharacterType;
import com.example.charactergenerator.repository.CharacterRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
@Service
public class CharacterService {

    private CharacterRepository characterRepository;
    @PersistenceContext
    private EntityManager entityManager;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository= characterRepository;
    }

    public Character findByName(String characterName) {
        return characterRepository.findCharactersByName(characterName).orElseThrow();
    }

    public List<Character> findAllByNameContains(String keyword){
        return characterRepository.findAllByNameContains(keyword);
    }

    public Character findById(long id){
        return characterRepository.findById(id).orElseThrow();
    }

    public List<Character>getAllCharacter(){return (List<Character>) characterRepository.findAll();}

    public void save(Character character) {characterRepository.save(character);}

    public void update(Character character, CharacterDto characterDto) {
        character.setName(characterDto.getName());
        character.setAttributeValue(AttributeType.STR, characterDto.getStrength());
        character.setAttributeValue(AttributeType.DEX, characterDto.getDexterity());
        character.setAttributeValue(AttributeType.CON, characterDto.getConstitution());
        character.setAttributeValue(AttributeType.INT, characterDto.getIntelligence());
        character.setAttributeValue(AttributeType.WIS, characterDto.getWisdom());
        character.setAttributeValue(AttributeType.CHA, characterDto.getCharisma());

        save(character);
    }

    public List<Character> findAll() {
        return (List<Character>) characterRepository.findAll();
    }

    public List<Character>filterBy(String characterName,String characterTypes,Byte challengeRating){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Character> criteriaQuery = criteriaBuilder.createQuery(Character.class);

        Root<Character> characterRoot=criteriaQuery.from(Character.class);
        List<Predicate> predicates = new ArrayList<>();

        if (!characterName.isBlank()){
            Predicate predicateName = criteriaBuilder.like(characterRoot.get("name"),"%"+ characterName + "%");
            predicates.add(predicateName);
        }
        if(characterTypes != null && !characterTypes.equals("AllTypes")){
            CharacterType characterType = CharacterType.valueOf(characterTypes);
            Predicate predicateType = criteriaBuilder.equal(characterRoot.get("characterType"),characterType);
            predicates.add(predicateType);
        }
        if(challengeRating!= null){
            Predicate predicaterating = criteriaBuilder.equal(characterRoot.get("challengeRating"),challengeRating);
            predicates.add(predicaterating);
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Character> query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();


    }
}
