package com.axonactive.workshop.customer;

import java.util.List;

import javax.ejb.Stateless;

import com.axonactive.workshop.common.GenericServices;

@Stateless
public class CustomerMapper extends GenericServices<CustomerEntity, CustomerBOM>{

	public CustomerMapper() {
		super(CustomerEntity.class);
	}
	
	public List<CustomerEntity> showAllCustomer() {
		return em.createQuery("select c from CustomerEntity c", CustomerEntity.class).getResultList();
	}
	
	@Override
	public CustomerEntity toEntity(CustomerBOM bom) {
		return new CustomerEntity(bom.getId() == null ? 0 : bom.getId(), bom.getName(), bom.getAddress(), bom.getCountry());
	}

	@Override
	public CustomerBOM toBom(CustomerEntity entity) {
		if(entity != null) {
			return new CustomerBOM(entity.getId(), entity.getName(), entity.getAddress(), entity.getCountry());
		}
		return null;
	}
	
}
