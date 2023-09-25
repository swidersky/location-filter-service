package com.payback.core.validation;

import com.payback.adapters.externalmodels.Place;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Component
@Slf4j
@RequiredArgsConstructor
public class QuerySearchValidator {

    public boolean validate(Place place, String filter) throws SearchValidatorException {

        validatePlace(place);

        if(nonNull(filter) && isNotEmpty(filter)) {
            if(place.getName() == null){
                return false;
            }
            if (nonNull(place.getName()) && !place.getName().toLowerCase().contains(filter.toLowerCase())) {
                return false;
            }
        }

        return true;

    }

    private void validatePlace(Place place) {
        if(place == null){
            throw new SearchValidatorException("The place cannot be null");
        }
    }

}
