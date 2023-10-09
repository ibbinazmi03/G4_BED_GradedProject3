package com.gl.tta.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.tta.model.Ticket;

@Repository

public interface TicketRepostory extends JpaRepository<Ticket, Long> {

	public List<Ticket> findByTitle(String keyword);

	public List<Ticket> findByTitleLikeOrShortDescriptionLike(String keyword, String keyword2);

	public List<Ticket> findByTitleLike(String keyword);

	public List<Ticket> findByTitleIgnoreCaseContainingOrShortDescriptionIgnoreCaseContaining(String keyword,
			String keyword2);

}
