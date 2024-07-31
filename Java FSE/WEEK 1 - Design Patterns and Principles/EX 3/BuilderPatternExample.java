public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer PC1 = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .build();
        Computer PC2 = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .build();
        System.out.println("PC 1 Configuration: " + PC1);
        System.out.println("PC 2 Configuration: " + PC2);
    }
}
class Computer {
    private String CPU;
    private String RAM;
    private String Storage;
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.Storage = builder.Storage;
    }
    @Override
    public String toString() {
        return "Computer [CPU = " + CPU + ", RAM = " + RAM + ", Storage = " + Storage + "]";
    }
    public static class Builder {
        private String CPU;
        private String RAM;
        private String Storage;
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }
        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }
        public Builder setStorage(String Storage) {
            this.Storage = Storage;
            return this;
        }
        public Computer build() {
            return new Computer(this);
        }
    }
}