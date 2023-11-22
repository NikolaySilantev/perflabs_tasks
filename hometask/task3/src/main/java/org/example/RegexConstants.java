package org.example;

/**
 * Regular expressions for checking numbers are placed in a separate final class.
 */

public final class RegexConstants {

    /**
     * Regular expression for finding invalid characters in Russian registration numbers.
     */
    static final String INVALID_SYMBOL_PATTERN = "[^A-Z||АБВЕИКМНОРСТУХ||\\d]";

    /**
     * Regular expression for checking Russian registration numbers for compliance with the format.
     */
    static final String VALID_FORMAT_PATTERN = "^[A-Z||АВЕИКМНОРСТУХ&&[^FGIJNQRSUVWZ]]{1}\\d{3}[A-Z||АВЕИКМНОРСТУХ&&[^FGIJNQRSUVWZ]]{2}(RUS){0,1}\\d{1,3}";

    /**
     * Regular expression to search for region in Russian registration numbers.
     */
    static final String REGION_CODE_PATTERN = "(\\d{0,2}\\d$)|(\\d{0,2}\\d(?=(RUS$)))";
}
