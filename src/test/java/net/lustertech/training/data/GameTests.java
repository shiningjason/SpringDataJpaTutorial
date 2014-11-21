package net.lustertech.training.data;

import net.lustertech.training.data.repositories.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.notNullValue;
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
         * 任務一：將玩家資料對應到 Domain Model 上，並建立玩家的 Repository。
         *
         * Hints：
         * 1. 建立 Player Model
         * public class Player {...}
         *
         * 2. 建立 Player Repository
         * public interface PlayerRepository extends Repository<Player, Integer> {...}
         */
        assertThat(playerRepository, notNullValue());

        System.out.println("＝＝＝＝＝＝＝＝＝＝");
    }
}
