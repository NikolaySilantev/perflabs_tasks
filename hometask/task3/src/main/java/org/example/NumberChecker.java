package org.example;

import org.example.RegexConstants.*;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.RegexConstants.*;

/**
 * A class containing methods for checking registration numbers.
 */

public class NumberChecker {

    /**
     * All Russian regions are stored in a hash map.
     */

    private static HashMap<Integer, String> RU_REGIONS = new HashMap<>();

    static {
        RU_REGIONS.put(1, "Республика Адыгея (Адыгея)");
        RU_REGIONS.put(2, "Республика Башкортостан");
        RU_REGIONS.put(102, "Республика Башкортостан");
        RU_REGIONS.put(702, "Республика Башкортостан");
        RU_REGIONS.put(3, "Республика Бурятия");
        RU_REGIONS.put(4, "Республика Алтай");
        RU_REGIONS.put(5, "Республика Дагестан");
        RU_REGIONS.put(6, "Республика Ингушетия");
        RU_REGIONS.put(7, "Кабардино-Балкарская Республика");
        RU_REGIONS.put(8, "Республика Калмыкия");
        RU_REGIONS.put(9, "Карачаево-Черкесская Республика");
        RU_REGIONS.put(10, "Республика Карелия");
        RU_REGIONS.put(11, "Республика Коми");
        RU_REGIONS.put(12, "Республика Марий Эл");
        RU_REGIONS.put(13, "Республика Мордовия");
        RU_REGIONS.put(14, "Республика Саха (Якутия)");
        RU_REGIONS.put(15, "Республика Северная Осетия — Алания");
        RU_REGIONS.put(16, "Республика Татарстан (Татарстан)");
        RU_REGIONS.put(116, "Республика Татарстан (Татарстан)");
        RU_REGIONS.put(716, "Республика Татарстан (Татарстан)");
        RU_REGIONS.put(17, "Республика Тыва");
        RU_REGIONS.put(18, "Удмуртская Республика");
        RU_REGIONS.put(19, "Республика Хакасия");
        RU_REGIONS.put(21, "Чувашская Республика — Чувашия");
        RU_REGIONS.put(121, "Чувашская Республика — Чувашия");
        RU_REGIONS.put(22, "Алтайский край");
        RU_REGIONS.put(23, "Краснодарский край");
        RU_REGIONS.put(93, "Краснодарский край");
        RU_REGIONS.put(123, "Краснодарский край");
        RU_REGIONS.put(193, "Краснодарский край");
        RU_REGIONS.put(24, "Красноярский край");
        RU_REGIONS.put(124, "Красноярский край");
        RU_REGIONS.put(25, "Приморский край");
        RU_REGIONS.put(125, "Приморский край");
        RU_REGIONS.put(26, "Ставропольский край");
        RU_REGIONS.put(126, "Ставропольский край");
        RU_REGIONS.put(27, "Хабаровский край");
        RU_REGIONS.put(28, "Амурская область");
        RU_REGIONS.put(29, "Архангельская область");
        RU_REGIONS.put(30, "Астраханская область");
        RU_REGIONS.put(31, "Белгородская область");
        RU_REGIONS.put(32, "Брянская область");
        RU_REGIONS.put(33, "Владимирская область");
        RU_REGIONS.put(34, "Волгоградская область");
        RU_REGIONS.put(134, "Волгоградская область");
        RU_REGIONS.put(35, "Вологодская область");
        RU_REGIONS.put(36, "Воронежская область");
        RU_REGIONS.put(136, "Воронежская область");
        RU_REGIONS.put(37, "Ивановская область");
        RU_REGIONS.put(38, "Иркутская область");
        RU_REGIONS.put(138, "Иркутская область");
        RU_REGIONS.put(39, "Калининградская область");
        RU_REGIONS.put(40, "Калужская область");
        RU_REGIONS.put(41, "Камчатский край");
        RU_REGIONS.put(42, "Кемеровская область");
        RU_REGIONS.put(142, "Кемеровская область");
        RU_REGIONS.put(43, "Кировская область");
        RU_REGIONS.put(44, "Костромская область");
        RU_REGIONS.put(45, "Курганская область");
        RU_REGIONS.put(46, "Курская область");
        RU_REGIONS.put(47, "Ленинградская область");
        RU_REGIONS.put(147, "Ленинградская область");
        RU_REGIONS.put(48, "Липецкая область");
        RU_REGIONS.put(49, "Магаданская область");
        RU_REGIONS.put(50, "Московская область");
        RU_REGIONS.put(90, "Московская область");
        RU_REGIONS.put(150, "Московская область");
        RU_REGIONS.put(190, "Московская область");
        RU_REGIONS.put(750, "Московская область");
        RU_REGIONS.put(790, "Московская область");
        RU_REGIONS.put(51, "Мурманская область");
        RU_REGIONS.put(52, "Нижегородская область");
        RU_REGIONS.put(152, "Нижегородская область");
        RU_REGIONS.put(53, "Новгородская область");
        RU_REGIONS.put(154, "Новосибирская область");
        RU_REGIONS.put(154, "Новосибирская область");
        RU_REGIONS.put(55, "Омская область");
        RU_REGIONS.put(56, "Оренбургская область");
        RU_REGIONS.put(156, "Оренбургская область");
        RU_REGIONS.put(57, "Орловская область");
        RU_REGIONS.put(58, "Пензенская область");
        RU_REGIONS.put(59, "Пермский край");
        RU_REGIONS.put(159, "Пермский край");
        RU_REGIONS.put(60, "Псковская область");
        RU_REGIONS.put(61, "Ростовская область");
        RU_REGIONS.put(161, "Ростовская область");
        RU_REGIONS.put(761, "Ростовская область");
        RU_REGIONS.put(62, "Рязанская область");
        RU_REGIONS.put(63, "Самарская область");
        RU_REGIONS.put(163, "Самарская область");
        RU_REGIONS.put(763, "Самарская область");
        RU_REGIONS.put(64, "Саратовская область");
        RU_REGIONS.put(164, "Саратовская область");
        RU_REGIONS.put(65, "Сахалинская область");
        RU_REGIONS.put(66, "Свердловская область");
        RU_REGIONS.put(96, "Свердловская область");
        RU_REGIONS.put(196, "Свердловская область");
        RU_REGIONS.put(67, "Смоленская область");
        RU_REGIONS.put(68, "Тамбовская область");
        RU_REGIONS.put(69, "Тверская область");
        RU_REGIONS.put(70, "Томская область");
        RU_REGIONS.put(71, "Тульская область");
        RU_REGIONS.put(72, "Тюменская область");
        RU_REGIONS.put(73, "Ульяновская область");
        RU_REGIONS.put(173, "Ульяновская область");
        RU_REGIONS.put(74, "Челябинская область");
        RU_REGIONS.put(174, "Челябинская область");
        RU_REGIONS.put(75, "Забайкальский край");
        RU_REGIONS.put(76, "Ярославская область");
        RU_REGIONS.put(77, "Москва");
        RU_REGIONS.put(97, "Москва");
        RU_REGIONS.put(99, "Москва");
        RU_REGIONS.put(177, "Москва");
        RU_REGIONS.put(197, "Москва");
        RU_REGIONS.put(199, "Москва");
        RU_REGIONS.put(777, "Москва");
        RU_REGIONS.put(797, "Москва");
        RU_REGIONS.put(799, "Москва");
        RU_REGIONS.put(78, "Санкт-Петербург");
        RU_REGIONS.put(98, "Санкт-Петербург");
        RU_REGIONS.put(178, "Санкт-Петербург");
        RU_REGIONS.put(198, "Санкт-Петербург");
        RU_REGIONS.put(79, "Еврейская автономная область");
        RU_REGIONS.put(80, "ДНР");
        RU_REGIONS.put(81, "ЛНР");
        RU_REGIONS.put(82, "Республика Крым");
        RU_REGIONS.put(83, "Ненецкий автономный округ");
        RU_REGIONS.put(84, "Херсонская область");
        RU_REGIONS.put(85, "Запорожская область");
        RU_REGIONS.put(86, "Ханты-Мансийский автономный округ — Югра");
        RU_REGIONS.put(186, "Ханты-Мансийский автономный округ — Югра");
        RU_REGIONS.put(87, "Чукотский автономный округ");
        RU_REGIONS.put(88, "Зарубежные территории, обслуживаемые МВД РФ");
        RU_REGIONS.put(94, "Зарубежные территории, обслуживаемые МВД РФ");
        RU_REGIONS.put(89, "Ямало-Ненецкий автономный округ");
        RU_REGIONS.put(92, "Севастополь");
        RU_REGIONS.put(95, "Чеченская республика");
    }

    private static final String INVALID_SYMBOLS_ERROR = " - недопустимые символы в номере!";
    private static final String NO_SUCH_REGION_ERROR = " - такого региона не существует!";
    private static final String DEFAULT_ERROR = " - недопустимый формат. Допустимые форматы: X000XX000, X000XX000RUS, X000XXRUS000";

    private static Pattern pattern;
    private static Matcher matcher;

    // Regular expressions are designed to process uppercase strings without spaces
    public static String preprocessNumber(String number) {
        return number.replaceAll("\\s+", "").toUpperCase();
    }

    /**
     * Use only after preprocess method.
     * Acceptable number formats: X000XX000, X000XX000RUS, X000XXRUS000
     */
    public static Boolean formatCheck(String number) {
        pattern = Pattern.compile(VALID_FORMAT_PATTERN);
        matcher = pattern.matcher(number);
        if (matcher.find()) return true;
        else return false;
    }

    /**
     * Use only after preprocess method.
     * If the user enters invalid characters, he will be notified about this.
     * If the problem is related to a small number of characters or other format violation,
     * a format violation message will be displayed.
     */
    public static String findInvalidSymbols(String number) {
        pattern = Pattern.compile(INVALID_SYMBOL_PATTERN);
        matcher = pattern.matcher(number);
        String result = "";
        while (matcher.find()) {
            result += matcher.group() + " ";
        }
        if (!result.isBlank()) return number + " " + result + INVALID_SYMBOLS_ERROR;
        else return number + DEFAULT_ERROR;
    }

    /**
     * Use only after preprocess method.
     * If the region does not exist, the user will receive a corresponding message.
     */
    public static String findRegion(String number) {
        pattern = Pattern.compile(REGION_CODE_PATTERN);
        matcher = pattern.matcher(number);
        String result = "";
        if (matcher.find()) result = RU_REGIONS.get(Integer.valueOf(matcher.group()));
        // This is provided in case the hash map does not contain the required region.
        if (result == null) return number + " " + matcher.group() + NO_SUCH_REGION_ERROR;
        // This is provided in case it was not possible to select a region from the number.
        if (result.isBlank()) return number + " " + NO_SUCH_REGION_ERROR;
        return number + " - регион " + result;
    }
}
