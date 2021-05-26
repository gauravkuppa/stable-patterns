public class EmailPerson implements Person {

    private String name;
    private String gender;
    private String country;

    public static void main(String[] args) {
        EmailPerson p1 = new EmailPerson("Gaurav Kuppa", 0, "USA");
    }

    public EmailPerson() {
        System.out.println("Created a person with no characterstics.");
    }

    public EmailPerson(String _name, int _gender, String _country) {
        createPerson(_name, _gender, _country);
        System.out.println("Created a person for " + name + " who is a " + gender + " and from " + country + ".");
    }

    public void createPerson(String _name, int _gender, String _country) {
        name = _name;
        country = _country;

        if (_gender == 0) {
            gender = "male";
        } else if (_gender == 1) {
            gender = "female";
        } else if (_gender == 2) {
            gender = "non-binary";
        } else {
            throw new RuntimeException("Gender value is out of bounds.");
        }
    }
}