package co.com.lulobank.certificacion.utils;

import co.com.lulobank.certificacion.models.Employe;
import com.google.gson.Gson;
import org.apache.http.HttpHeaders;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class Build {
    /**
     * Método usado para construir el header que se usa en la petición, usando el access token
     *
     * @return Map con los header necesarios para realizar la petición
     */
    @NotNull
    public static Map<String, Object> headerRequest() {
        Map<String, Object> headers = new HashMap<>();
        headers.put(HttpHeaders.CONTENT_TYPE, "application/json");

        return headers;
    }
}
