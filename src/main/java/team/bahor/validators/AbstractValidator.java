package team.bahor.validators;

import team.bahor.dto.BaseGenericDto;
import team.bahor.dto.GenericDto;
import team.bahor.exeptions.ValidationException;
import team.bahor.exeptions.course.CategoryNotAvailableException;

import java.io.Serializable;

public abstract class AbstractValidator<CD extends BaseGenericDto, UD extends GenericDto, K extends Serializable> implements BaseGenericValidator {

    public abstract void validateKey(K id) throws ValidationException;

    public abstract void validOnCreate(CD cd) throws ValidationException, CategoryNotAvailableException;

    public abstract void validOnUpdate(UD cd) throws ValidationException;


}

