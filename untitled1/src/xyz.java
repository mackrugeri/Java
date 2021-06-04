class xyz {

    private final String name;

    xyz(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        int counter = 0;
        // Launching 4 parallel threads
        for (int i = 1; i <= 8; i++) {
            // `start` method will call the `run` method
            // of CountAndPrint in another thread
            for (int n=0; n < 10000; n++) {
                counter = counter + 1;
            }
            System.out.println("counter = " + counter);

        }
    }
}