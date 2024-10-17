package designpattern;

public class SomeComplexClass {
    private final String name;
    private final String address;
    private final String pinCode;
    private final String landmark;
    private final String city;

    // Private constructor to force usage of Builder
    private SomeComplexClass(Builder builder) {
        this.name = builder.name;
        this.address = builder.address;
        this.pinCode = builder.pinCode;
        this.landmark = builder.landmark;
        this.city = builder.city;
    }

    // Builder class
    public static class Builder {
        private String name;
        private String address;
        private String pinCode;
        private String landmark;
        private String city;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPinCode(String pinCode) {
            this.pinCode = pinCode;
            return this;
        }

        public Builder setLandmark(String landmark) {
            this.landmark = landmark;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        // Build method to return the final object
        public SomeComplexClass build() {
            return new SomeComplexClass(this);
        }
    }

    @Override
    public String toString() {
        return "SomeComplexClass{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", landmark='" + landmark + '\'' +
                ", city='  " + city + '\'' +
                '}';


    }
}
