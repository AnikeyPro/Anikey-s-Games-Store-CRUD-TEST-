package ru.anikey.crudtest2.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.anikey.crudtest2.entity.Game;

@Repository
@Transactional
public interface GameRepository extends JpaRepository<Game,Integer> {

        List<Game> findByTitleContainingIgnoreCase(String keyword);

        // @Query("UPDATE Game t SET t.published = :published WHERE t.id = :id")
        //@Modifying
        //public void updatePublishedStatus(Integer id, boolean published);

}
