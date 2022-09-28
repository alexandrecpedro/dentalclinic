package br.com.dentalclinic.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class DentalClinicUtils {
    private static ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    public static String asJsonString(final Object obj) {
            try {
                return mapper.writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

        public static <T> T objectFromString(Class<T> aClass, String value) {
            try {
                return mapper.readValue(value, aClass);
            } catch (Exception e) {
                throw new RuntimeException();
            }
       }
}
