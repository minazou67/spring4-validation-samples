package org.minazou67.samples.spring4.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ItemController {

	@Autowired
	private ItemValidator itemValidator;

	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		binder.addValidators(itemValidator);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {

		final ItemForm form = new ItemForm();
		final List<Item> itemList = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			final Item item = new Item();
			item.setName("Item" + (i + 1));
			item.setPrice(Long.valueOf(1000 * (i + 1)));
			itemList.add(item);
		}
		form.setItemList(itemList);

		model.addAttribute("itemForm", form);
		return "item";
	}

	@RequestMapping(value = "/item/update", method = RequestMethod.POST)
	public String update(@Valid final ItemForm form, final BindingResult bindingResult, final Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("itemForm", form);
			return "item";
		}
		return "item";
	}
}
