package com.gl.tta.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.gl.tta.model.Ticket;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class TicketSearchRepo {
	
	private EntityManager em;
	
	public List<Ticket> findAllByKeywordInTitleorShortDiscription(String keyword){

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		
		CriteriaQuery<Ticket> criteriaQuery = criteriaBuilder.createQuery(Ticket.class);
		
		Root<Ticket> root = criteriaQuery.from(Ticket.class);
		
		Predicate titlePredicate = criteriaBuilder.like(root.get("title"), "%"+keyword+"%");
		Predicate shortDesciptionPredicate = criteriaBuilder.like(root.get("shortDescription"), "%"+keyword+"%");
		Predicate orPredicate = criteriaBuilder.or(titlePredicate,shortDesciptionPredicate);
		criteriaQuery.where(titlePredicate);
		
		TypedQuery<Ticket> query = em.createQuery(criteriaQuery);
		return query.getResultList();
	}
}
