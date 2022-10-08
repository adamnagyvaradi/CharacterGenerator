package com.example.charactergenerator.service;

import com.example.charactergenerator.model.Character;
import com.example.charactergenerator.model.CharacterType;
import com.example.charactergenerator.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SearchService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private SearchRepository searchRepository;

    public List<Character>filterBy(String charactername,CharacterType characterTypes,Byte challengerating){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Character> criteriaQuery = criteriaBuilder.createQuery(Character.class);

        Root<Character> characterRoot=criteriaQuery.from(Character.class);
        List<Predicate> predicates = new ArrayList<>();

        if (!charactername.isBlank()){
            Predicate predicatename = criteriaBuilder.like(characterRoot.get("name"),"%"+ charactername + "%");
            predicates.add(predicatename);
            }
        if(characterTypes != null){
            Predicate predicateType = criteriaBuilder.equal(characterRoot.get("character_type"),characterTypes);
            predicates.add(predicateType);
        }
        if(challengerating!= null){
            Predicate predicaterating = criteriaBuilder.equal(characterRoot.get("challange_rating"),challengerating);
            predicates.add(predicaterating);
        }
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Character>query = entityManager.createQuery(criteriaQuery);

        return query.getResultList();


    }
}
