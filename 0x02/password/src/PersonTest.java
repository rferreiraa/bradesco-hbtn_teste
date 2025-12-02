public class PersonTest {
    @ParameterizedTest
    @ValueSource(strings = { "PaulMcCartney2", "NeilArms2" })
    void check_user_valid(String username) {
        assertTrue(Person.checkUser(username));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Paul#McCartney", "Neil@Arms" })
    void check_user_not_valid(String username) {
        assertFalse(Person.checkUser(username));
    }

    @ParameterizedTest
    @ValueSource(strings = { "123456789", "#$%1234" })
    void does_not_have_letters(String password) {
        assertFalse(Person.checkPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Abcabcdefgh@", "#hbtn@%tc" })
    void does_not_have_numbers(String password) {
        assertFalse(Person.checkPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Abc@123", "12$@hbt" })
    void does_not_have_eight_chars(String password) {
        assertFalse(Person.checkPassword(password));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "abC123456$",
            "Hbtn@1234",
            "Betty@1#2",
            "Hbtn@123"
    })
    void check_password_valid(String password) {
        assertTrue(Person.checkPassword(password));
    }
}
