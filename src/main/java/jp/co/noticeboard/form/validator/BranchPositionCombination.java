package jp.co.noticeboard.form.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import jp.co.noticeboard.form.validator.BranchPositionCombination.BranchPositionCombinationValidator;

@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BranchPositionCombinationValidator.class)
public @interface BranchPositionCombination {
	String message() default "部署と役職の組み合わせが不正です";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String branchId();

	String positionId();

	class BranchPositionCombinationValidator implements ConstraintValidator<BranchPositionCombination, Object> {
		private String branchIdProperty;
		private String positionIdProperty;
		private String message;

		@Override
		public void initialize(BranchPositionCombination annotation) {
			branchIdProperty = annotation.branchId();
			positionIdProperty = annotation.positionId();
			message = annotation.message();
		}

		@Override
		public boolean isValid(Object value, ConstraintValidatorContext context) {
			// 各フィールドから値を取得する
			BeanWrapper beanWrapper = new BeanWrapperImpl(value);
			Integer branchId = (Integer) beanWrapper.getPropertyValue(branchIdProperty);
			Integer positionId = (Integer) beanWrapper.getPropertyValue(positionIdProperty);

			// 支店IDと役職IDの組み合わせが不正な場合はエラーメッセージを表示する
			if ((1 == branchId && !(1 == positionId || 2 == positionId))
					|| (1 != branchId && !(3 == positionId || 4 == positionId))) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(message).addPropertyNode(branchIdProperty)
						.addConstraintViolation();
				return false;
			}
			return true;
		}
	}
}
