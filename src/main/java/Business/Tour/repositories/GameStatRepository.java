package Business.Tour.repositories;

import Business.Tour.entities.GameStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface GameStatRepository extends JpaRepository<GameStat, Long> {
    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE\n" +
            "  Game_Stat gstat\n" +
            "set\n" +
            "  nb_Wins = CASE WHEN (\n" +
            "    SELECT\n" +
            "      is_Win\n" +
            "    from\n" +
            "      Game_Score gscore\n" +
            "    WHERE\n" +
            "      gstat.id = gscore.game_Stat_Id\n" +
            "  ) = true THEN nb_Wins + 1 else nb_Wins END,\n" +
            "  nb_Loses = CASE WHEN (\n" +
            "    SELECT\n" +
            "      is_Win\n" +
            "    from\n" +
            "      Game_Score gscore\n" +
            "    WHERE\n" +
            "      gstat.id = gscore.game_Stat_Id\n" +
            "  ) = false THEN nb_Loses + 1 else nb_Loses END,\n" +
            "  average_Duration_Of_Games = average_Duration_of_Games + (\n" +
            "    SELECT\n" +
            "      total_Duration\n" +
            "    from\n" +
            "      Game_Score gscore\n" +
            "    WHERE\n" +
            "      gstat.id = gscore.game_Stat_Id\n" +
            "  ),\n" +
            "  total_Money_Earned = total_Money_Earned + (\n" +
            "    SELECT\n" +
            "      money_Earned\n" +
            "    from\n" +
            "      Game_Score gscore\n" +
            "    WHERE\n" +
            "      gstat.id = gscore.game_Stat_Id\n" +
            "  ),\n" +
            "  nb_Total_Games_Played = nb_Total_Games_Played + 1\n" +
            "WHERE\n" +
            "  id = id\n", nativeQuery = true)
    int updateGameStats(@Param("id") Long id);

    @Query("SELECT t.nbWins FROM GameStat t where t.id = :id")
    Optional<Long> getOneNbWins(@Param("id") Long id);

    @Query("SELECT t.nbLoses from GameStat t where t.id=:id")
    Optional<Long> getOneNbLoses(@Param("id") Long id);

    @Query("SELECT t.nbTotalGamesPlayed from GameStat t where t.id=:id")
    Optional<Long> getOneNbGames(@Param("id") Long id);

    @Query("SELECT t.totalMoneyEarned from GameStat t where t.id=:id")
    Optional<Integer> getOneTotalMoneyEarned(@Param("id") Long id);


}
