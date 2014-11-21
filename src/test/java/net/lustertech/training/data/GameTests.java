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

import static org.hamcrest.Matchers.is;
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

        Iterable<Player> players = playerRepository.findAll();
        for (Player player : players) System.out.println(player);

        System.out.println("＝＝＝＝＝＝＝＝＝＝");

        assertThat(players, Matchers.<Player>iterableWithSize(3));
    }

    // TODO 完成下列的測試案例

    @Test
    public void findPlayer() {
        /* 任務一：取得 ID = 1 的使用者，並檢測玩家名稱是否為 'Jason'。 */

        Player player = playerRepository.findOne(1);
        System.out.println(player);

        assertThat(player, notNullValue());
        assertThat(player.getUsername(), is("Jason"));
    }

    @Test
    public void createPlayer() {
        /* 任務二：儲存一筆新的使用者，並在重新取得玩家清單後，檢測數量是否加一。 */

        Player andy = new Player("Andy", "123", "安迪");
        playerRepository.save(andy);

        Iterable<Player> players = playerRepository.findAll();
        for (Player player : players) System.out.println(player);

        assertThat(players, Matchers.<Player>iterableWithSize(4));
    }

    @Test
    public void updatePlayer() {
        /* 任務三：修改使用者 ID 為 1 的使用者名稱，儲存並重新取得該玩家，檢測名稱是否改變。 */

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
        /* 任務四：刪除 ID 為 1 的使用者，並在重新取得玩家清單後，檢測數量是否減一。 */

        playerRepository.delete(1);

        Iterable<Player> players = playerRepository.findAll();
        for (Player player : players) System.out.println(player);

        assertThat(players, Matchers.<Player>iterableWithSize(2));
    }
}
