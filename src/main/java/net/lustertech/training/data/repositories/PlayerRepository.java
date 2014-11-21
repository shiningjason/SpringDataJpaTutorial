package net.lustertech.training.data.repositories;

import net.lustertech.training.data.domains.Player;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerRepository extends PagingAndSortingRepository<Player, Integer> {
}
