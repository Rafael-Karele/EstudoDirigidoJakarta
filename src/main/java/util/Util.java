package util;

import java.util.Locale;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyOrderStrategy;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author rktds
 */
public class Util {

    public static String toJson(Object object) {
        JsonbConfig config = new JsonbConfig()
                .withFormatting(true)
                .withDateFormat("dd/MM/yyyy[ hh:mm:ss]",
                        Locale.forLanguageTag("pt_BR")
                )
                .withPropertyOrderStrategy(
                        PropertyOrderStrategy.LEXICOGRAPHICAL);
        return JsonbBuilder.create(config).toJson(object);
    }
}
