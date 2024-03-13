import java.util.*;

public class PhoneBook {
    TreeMap<String, String> phoneBookStringTreeMaps = new TreeMap<>();

    public void addContact(String phone, String name) {

        String nameRegex = "[а-яА-Я]{4}";
        String phoneRegex = "[0-9]{11,99}";
        if (name.isEmpty() || phone.isEmpty()) {
            return;
        }
        if (!phone.matches(nameRegex) && !name.matches(phoneRegex)) {
            phoneBookStringTreeMaps.put(phone, name);
        }
    }

    public String getContactByPhone(String phone) {
        if (phoneBookStringTreeMaps.containsKey(phone)) {
            String name = phoneBookStringTreeMaps.get(phone);
            return name + " - " + phone;
        } else {
            return "";
        }
    }

    public Set<String> getContactByName(String name) {
        Set<String> contacts = new TreeSet<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, String> entry : phoneBookStringTreeMaps.entrySet()) {
            String entryName = entry.getValue();
            String entryPhone = entry.getKey();

            if (entryName.equals(name)) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(", ");
                }
                stringBuilder.append(entryPhone);
            }
        }
        if (stringBuilder.length() > 0) {
            contacts.add(name + " - " + stringBuilder.toString());
        }
        return contacts;
    }

    public Set<String> getAllContacts() {
        Set<String> contacts = new TreeSet<>();
        for (Map.Entry<String, String> entry: phoneBookStringTreeMaps.entrySet()) {
            contacts.addAll(getContactByName( entry.getValue()));
        }
        return contacts;
    }
}