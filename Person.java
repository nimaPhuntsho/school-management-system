public abstract class Person {
    private String name;
    private String email;
    private int age;
    public Person() {
    }
    public Person(String name, String email, int age) {
        setName(name);
        setEmail(email);
        setAge(age);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (checkInteger(name)) {
            throw new IllegalArgumentException("Name cannot have integer values");
        } else {
            this.name = name;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!checkRateSymbol(email)) {
            throw new IllegalArgumentException("Invalid Email Address");
        } else {
            this.email = email;
        }
    }

    public int getAge() {
        return age;
    }

    //an Illegal Argument exception is thrown with a message on using invalid input.
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be less than 0");
        } else {
            this.age = age;
        }
    }

    //The method will check for any integer values in the string.
    public boolean checkInteger (String name) {
        boolean result = false;
        char [] args = name.toCharArray();

        for (char elements: args)
            if (Character.isDigit(elements)) return true;
        return result;
    }

    //The method will check if the email is valid, if the string value contains '@' symbol, it will return true.
    public boolean checkRateSymbol (String email) {
        boolean result = false;
        char [] emailArray = email.toCharArray();
        Character rate = '@';

        for (int i = 0; i < emailArray.length; i++) {
            if (rate.equals(emailArray[i])) {
                return true;
            }
        }
        return result;
    }
}
