package com.example.charactergenerator.repository;



import com.example.charactergenerator.model.Character;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SearchRepository extends JpaRepository<Character,Long> {
    @Query(value = "select c FROM characters c where characters.name like %:keyword% ")
    //@Query("SELECT characters FROM characters WHERE characters.name LIKE %?1%")
    List<Character> findByKeyword(@Param("keyword") String keyword);

}

