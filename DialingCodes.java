import java.util.Map;
import java.util.Map.Entry;

public class DialingCodes {
    private Map<Integer, String> dialingCodes = new java.util.HashMap<>();

    public Map<Integer, String> getCodes() {
        return dialingCodes;
    }

    public void setDialingCode(Integer code, String country) {
        dialingCodes.put(code, country);
    }

    public String getCountry(Integer code) {
        return dialingCodes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (dialingCodes.containsKey(code)) {
            return;
        }
        if (dialingCodes.values().contains(country)) {
            return;
        }
        setDialingCode(code, country);
    }

    public Integer findDialingCode(String country) {
        for (Entry<Integer, String> entry : dialingCodes.entrySet()) {
            if (entry.getValue().equals(country)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        Integer existingCode = findDialingCode(country);
        if (existingCode == null) {
            return;
        }

        dialingCodes.remove(existingCode);
        setDialingCode(code, country);
    }

    public static void main(String[] args) {
        DialingCodes dialingCodes = new DialingCodes();
        System.out.println("Initial dialing codes: " + dialingCodes.getCodes());

        dialingCodes.addNewDialingCode(61, "Australia");
        dialingCodes.addNewDialingCode(1000, "Australia");
        System.out.println("Next dialing codes: " + dialingCodes.getCodes());

        dialingCodes.setDialingCode(1, "United States");
        dialingCodes.setDialingCode(44, "United Kingdom");
        dialingCodes.setDialingCode(91, "India");

        System.out.println("Country for code 1: " + dialingCodes.getCountry(1));
        System.out.println("Country for code 44: " + dialingCodes.getCountry(44));
        System.out.println("Country for code 91: " + dialingCodes.getCountry(91));

        dialingCodes.addNewDialingCode(81, "Japan");
        System.out.println("Country for code 81: " + dialingCodes.getCountry(81));

        Integer codeForIndia = dialingCodes.findDialingCode("India");
        System.out.println("Dialing code for India: " + codeForIndia);

        dialingCodes.updateCountryDialingCode(92, "India");
        System.out.println("Updated country for code 92: " + dialingCodes.getCountry(92));
    }
}
