package team.bahor.validators;

import team.bahor.dto.BaseGenericDto;
import team.bahor.dto.GenericDto;
import team.bahor.exeptions.ValidationException;

import java.io.Serializable;

public abstract class AbstractValidator<CD extends BaseGenericDto, UD extends GenericDto, K extends Serializable> implements BaseGenericValidator {

    public abstract void validateKey(K id) throws
            ValidationException;

    public abstract void validOnCreate(CD cd) throws ValidationException;

    public abstract void validOnUpdate(UD cd) throws ValidationException;


}

