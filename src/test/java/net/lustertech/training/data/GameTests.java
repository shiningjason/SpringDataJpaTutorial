package net.lustertech.training.data;

import net.lustertech.training.data.domains.Player;
import net.lustertech.training.data.repositories.PlayerRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@SpringApplicationConfiguration(classes = ApplicationConfig.class)
public class GameTests {

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void getAllPlayers() {

        System.out.println("＝＝＝玩家清單＝＝＝");

        // TODO 印出所有玩家資料，並檢測玩家數量是否與資料庫中的筆數相等
        /*
         * 任務二：從資料庫中取出玩家清單，並印出來。
         *
         * Hints：
         * 1. 繼承 CrudRepository
         * public interface PlayerRepository extends CrudRepository<Player, Integer> {...}
         * 2. 使用 repository.findAll() 取得資料
         */

        Iterable<Player> players = playerRepository.findAll();
        for (Player player : players) System.out.println(player);

        System.out.println("＝＝＝＝＝＝＝＝＝＝");

        assertThat(players, Matchers.<Player>iterableWithSize(3));
    }
}
