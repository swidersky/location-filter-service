package com.payback.core.validation;

import com.payback.adapters.externalmodels.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuerySearchValidatorTest {

    public static final String CORRECT_FILTER = "test";
    public static final String INVALID_FILTER = "test2";
    public static final String EMPTY_FILTER = "";
    private final QuerySearchValidator querySearchValidator = new QuerySearchValidator();
    private Place place;

    @BeforeEach
    public void setup(){
        place = new Place();
        place.setName("Test name");
    }

    @Test
    public void whenFilterMeetsConditionsReturnTrue() {
        assertTrue(querySearchValidator.validate(place, CORRECT_FILTER));
    }

    @Test
    public void whenFilterDoesNotMeetConditionsReturnFalse() {
        assertFalse(querySearchValidator.validate(place, INVALID_FILTER));
    }

    @Test
    public void whenFilterIsEmptyReturnTrue() {
        assertTrue(querySearchValidator.validate(place, EMPTY_FILTER));
    }

    @Test
    public void whenFilterIsDefaultButPlaceNameIsNullReturnTrue() {
        place.setName(null);
        assertTrue(querySearchValidator.validate(place, EMPTY_FILTER));
    }

    @Test
    public void whenFilterIsDefaultButPlaceNameIsEmptyReturnTrue() {
        place.setName("");
        assertTrue(querySearchValidator.validate(place, EMPTY_FILTER));
    }

    @Test
    public void whenFilterIsDefinedButPlaceNameIsEmptyReturnTrue() {
        place.setName("");
        assertFalse(querySearchValidator.validate(place, CORRECT_FILTER));
    }

    @Test
    public void whenFilterIsDefinedButPlaceNameIsNullReturnTrue() {
        place.setName(null);
        assertFalse(querySearchValidator.validate(place, CORRECT_FILTER));
    }

    @Test
    public void whenFilterIsDefinedButPlaceIsNullReturnException() {
        place = null;
        assertThrows(
                SearchValidatorException.class,
                () -> querySearchValidator.validate(place, CORRECT_FILTER));
    }

}
