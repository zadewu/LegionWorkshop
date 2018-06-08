package com.axonactive.workshop.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericServices<E, B> {
	private final Class<E> entityClass;
	@PersistenceContext(name = "workshop")
	protected EntityManager em;

	public GenericServices(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public abstract E toEntity(B bom);

	public abstract B toBom(E entity);
	
	public List<E> toEntity(List<B> boms) {
		if(boms == null) {
			return Collections.emptyList();
		}
		List<E> entities = new ArrayList<>();
		boms.stream().map(each -> toEntity(each)).filter(Objects::nonNull).forEach(entity -> entities.add(entity));
		return entities;
	}
	
	public List<B> toBoms(List<E> entities) {
		if(entities == null) {
			return Collections.emptyList();
		}
		List<B> boms = new ArrayList<>();
		entities.stream().map(each -> toBom(each)).filter(Objects::nonNull).forEach(bom -> boms.add(bom));
		return boms;
	}
}
