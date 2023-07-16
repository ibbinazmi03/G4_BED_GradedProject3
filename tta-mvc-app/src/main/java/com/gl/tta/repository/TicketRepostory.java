package com.gl.tta.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.tta.model.Ticket;

@Repository
//@RequiredArgsConstruct
public interface TicketRepostory extends JpaRepository<Ticket, Long> {
	
////	private final EntityManager em;
//	
//    @Query( value = "FROM Tickets t WHERE t.title =?1 ", nativeQuery = true)
    public List<Ticket> findByTitle(String keyword);
    public List<Ticket> findByTitleLikeOrShortDescriptionLike(String keyword,String keyword2);
	
}