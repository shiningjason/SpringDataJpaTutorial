package net.lustertech.training.data;

import net.lustertech.training.data.domains.Player;
import net.lustertech.training.data.repositories.PlayerRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.*;
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

        Iterable<Player> players = playerRepository.findAll();
        for (Player player : players) System.out.println(player);

        System.out.println("＝＝＝＝＝＝＝＝＝＝");

        assertThat(players, Matchers.<Player>iterableWithSize(3));
    }

    @Test
    public void findPlayer() {

        Player player = playerRepository.findOne(1);
        System.out.println(player);

        assertThat(player, notNullValue());
        assertThat(player.getUsername(), is("Jason"));
    }

    @Test
    public void createPlayer() {

        Player andy = new Player("Andy", "123", "安迪");
        playerRepository.save(andy);

        Iterable<Player> players = playerRepository.findAll();
        for (Player player : players) System.out.println(player);

        assertThat(players, Matchers.<Player>iterableWithSize(4));
    }

    @Test
    public void updatePlayer() {

        String newNickname = "小甜甜";

        Player player1 = playerRepository.findOne(1);
        player1.setNickname(newNickname);
        playerRepository.save(player1);

        player1 = playerRepository.findOne(1);
        System.out.println(player1);

        assertThat(player1.getNickname(), is(newNickname));
    }

    @Test
    public void deletePlayer() {

        playerRepository.delete(1);

        Iterable<Player> players = playerRepository.findAll();
        for (Player player : players) System.out.println(player);

        assertThat(players, Matchers.<Player>iterableWithSize(2));
    }

    @Test
    public void orderPlayersByIdDesc() {

        // TODO 將玩家依 ID 降冪進行排序
        /*
         * 任務：完成降冪排序，並測試結果是否為正確。
         *
         * Hints：
         * 1. Repository 繼承 PagingAndSortingRepository
         * 2. 使用 repository.findAll(Sort sort) 取得清單
         */

        Iterable<Player> players = playerRepository.findAll(new Sort(Sort.Direction.DESC, "id"));

        Integer id = null;
        for (Player player : players) {
            System.out.println(player);

            if (id != null) assertThat(player.getId(), lessThan(id));
            id = player.getId();
        }
    }
}
