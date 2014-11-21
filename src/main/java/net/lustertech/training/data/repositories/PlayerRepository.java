package net.lustertech.training.data.repositories;

import net.lustertech.training.data.domains.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

    public Player findByNickname(String nickname);
}
