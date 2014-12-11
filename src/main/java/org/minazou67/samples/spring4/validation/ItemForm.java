package org.minazou67.samples.spring4.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ItemForm {

	@NotNull
	@Valid
	private List<Item> itemList = new ArrayList<>();

	public List<Item> getItemList() {
	    return itemList;
	}

	public void setItemList(List<Item> itemList) {
	    this.itemList = itemList;
	}
}
