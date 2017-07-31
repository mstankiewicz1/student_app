package pl.akademiakodu.weekend8.validators;

import org.springframework.stereotype.Component;
import pl.akademiakodu.weekend8.entity.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by itml on 11.06.2017.
 */
@Component
public class PasswordsMatcherConstraintValidator implements ConstraintValidator<PasswordMatch, User> {

    private PasswordMatch matcher;

    @Override
    public void initialize(PasswordMatch matcher) {
        this.matcher = matcher;
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext constraintValidatorContext) {

        boolean isValid = user.getPassword().equals(user.getPasswordConfirm());

        if (!isValid) {
            createConstraintViolations(constraintValidatorContext);
        }
        return isValid;
    }

    private void createConstraintViolations(final ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(matcher.message())
                .addNode(matcher.fieldName()).addConstraintViolation();
    }
}