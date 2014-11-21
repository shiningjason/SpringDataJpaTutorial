package net.lustertech.training.data;

import net.lustertech.training.data.domains.Player;
import net.lustertech.training.data.repositories.PlayerRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

        Iterable<Player> players = playerRepository.findAll(new Sort(Sort.Direction.DESC, "id"));

        Integer id = null;
        for (Player player : players) {
            System.out.println(player);

            if (id != null) assertThat(player.getId(), lessThan(id));
            id = player.getId();
        }
    }

    @Test
    public void pagingPlayers() {

        Page<Player> page;
        Pageable pageable = new PageRequest(0, 2);

        do {
            page = playerRepository.findAll(pageable);
            for (Player player : page.getContent()) System.out.println(player);

            pageable = pageable.next();
        } while (page.hasNext());

        assertThat(page.getTotalPages(), is(2));
        assertThat((int) page.getTotalElements(), is(3));
    }

    @Test
    public void findByNickname() {

        Player player = playerRepository.findByNickname("華特");
        System.out.println(player);

        assertThat(player, notNullValue());
    }
}
