package org.minazou67.samples.spring4.validation;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Item {

	@NotEmpty
	private String name = null;

	@NotNull
	private Long price = null;

	public String getName() {
	    return name;
	}

	public void setName(String name) {
	    this.name = name;
	}

	public Long getPrice() {
	    return price;
	}

	public void setPrice(Long price) {
	    this.price = price;
	}
}
