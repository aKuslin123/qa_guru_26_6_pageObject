package data;

public enum FormKeys {
    Name("Student Name"),
    Email("Student Email"),
    Gender("Gender"),
    Mobile("Mobile"),
    Birth("Date of Birth"),
    Subject("Subjects"),
    Hobby("Hobbies"),
    Picture("Picture"),
    Address("Address"),
    StateAndCity("State and City");

    FormKeys(String key) {
        this.key = key;
    }

    private final String key;

    public String getKey() {
        return key;
    }
}