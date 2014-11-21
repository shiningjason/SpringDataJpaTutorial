package net.lustertech.training.data.repositories;

import net.lustertech.training.data.domains.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
