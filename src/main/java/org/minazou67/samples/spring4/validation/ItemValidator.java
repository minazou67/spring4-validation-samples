package org.minazou67.samples.spring4.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {

	@Override
	public boolean supports(final Class<?> clazz) {
		return ItemForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(final Object target, final Errors errors) {

		final ItemForm form = (ItemForm) target;
		for (int i = 0; i < form.getItemList().size(); i++) {
			final Item item = form.getItemList().get(i);
			// Price
			if (errors.hasFieldErrors("itemList[" + i + "].price")) {
				continue;
			}
			if (item.getPrice() > 5000) {
				errors.rejectValue("itemList[" + i + "].price",
						"validation.item.price.incorrect",
						new Object[] { i + 1 },
						"Price may not be correctly.");
			}
		}
	}
}
