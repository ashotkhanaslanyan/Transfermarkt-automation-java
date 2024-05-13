package com.tmkt.tools;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.InputStream;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormValuesParser {
    private final static ObjectMapper mapper = new ObjectMapper();
    private final static String FILE_PATH = "FormValues.json";
    private static JsonNode rootNode;

    static {
        try (InputStream input = FormValuesParser.class.getClassLoader().getResourceAsStream(FILE_PATH)) {
            if (input == null) {
                throw new IllegalArgumentException("File not found: " + FILE_PATH);
            }
            rootNode = mapper.readTree(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNickname() {
        updateJson();
        return getFormValue("Nickname");
    }

    public static String getFirstname() {
        return getFormValue("Firstname");
    }

    public static String getLastname() {
        return getFormValue("Lastname");
    }

    public static String getEmail() {
        updateJson();
        return getFormValue("Email");
    }

    public static String getPassword() {
        return getFormValue("Password");
    }

    private static void updateJson() {
        try {
            if (rootNode == null) {
                try (InputStream input = FormValuesParser.class.getClassLoader().getResourceAsStream(FILE_PATH)) {
                    if (input == null) {
                        throw new IllegalArgumentException("File not found: " + FILE_PATH);
                    }
                    rootNode = mapper.readTree(input);
                }
            }

            String nickname = rootNode.get("Nickname").asText();
            String updatedNickname = incrementNumericValue(nickname);
            ((ObjectNode) rootNode).put("Nickname", updatedNickname);

            String email = rootNode.get("Email").asText();
            String updatedEmail = incrementNumericValueInEmail(email);
            ((ObjectNode) rootNode).put("Email", updatedEmail);

            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/" + FILE_PATH), rootNode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getFormValue(String key) {
        if (rootNode != null) {
            JsonNode valueNode = rootNode.get(key);
            if (valueNode != null) {
                return valueNode.asText();
            }
        }
        return null;
    }

    private static String incrementNumericValue(String text) {
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(text);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group(1));
            matcher.appendReplacement(sb, String.valueOf(number + 1));
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    private static String incrementNumericValueInEmail(String email) {
        String[] parts = email.split("@");
        if (parts.length == 2) {
            parts[0] = incrementNumericValue(parts[0]);
            return parts[0] + "@" + parts[1];
        }
        return email;
    }
}
