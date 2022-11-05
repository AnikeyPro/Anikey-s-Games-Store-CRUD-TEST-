package ru.anikey.crudtest2.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.anikey.crudtest2.entity.Game;

@Repository
@Transactional
public interface GameRepository extends JpaRepository<Game,Integer> {

        List<Game> findByTitleContainingIgnoreCase(String keyword);


}
