public class Principal {
    public static void main(String[] args) {
        System.out.println("Termina thread main");

        // Comportament 1: execució intercalada
        System.out.println("\n=== Comportament 1 ===");
        executarFils(9, 9, false, false);

        // Comportament 2: Pepe primer, després Juan
        System.out.println("\n=== Comportament 2 ===");
        executarFils(9, 9, true, false);

        // Comportament 3: alternança estricta
        System.out.println("\n=== Comportament 3 ===");
        executarFils(9, 9, false, true);
    }

    public static void executarFils(int iteracionsJuan, int iteracionsPepe, boolean pepePrimer, boolean alternStricta) {
        Fil juan = new Fil("Juan", iteracionsJuan);
        Fil pepe = new Fil("Pepe", iteracionsPepe);

        if (pepePrimer) {
            pepe.start();
            try {
                pepe.join(); // Espera que acabi Pepe
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            juan.start(); // Comença Juan després que Pepe acabi
        } else if (alternStricta) {
            // Alternança estricta utilitzant un monitor comú
            Object lock = new Object();

            Thread juanThread = new Thread(() -> {
                synchronized (lock) {
                    for (int i = 1; i <= iteracionsJuan; i++) {
                        System.out.println("Juan " + i);
                        lock.notify(); // Notifica Pepe
                        try {
                            if (i < iteracionsJuan) lock.wait(); // Espera que Pepe imprimeixi
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("Termina el fil Juan");
            });

            Thread pepeThread = new Thread(() -> {
                synchronized (lock) {
                    for (int i = 1; i <= iteracionsPepe; i++) {
                        System.out.println("Pepe " + i);
                        lock.notify(); // Notifica Juan
                        try {
                            if (i < iteracionsPepe) lock.wait(); // Espera que Juan imprimeixi
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("Termina el fil Pepe");
            });

            juanThread.start();
            pepeThread.start();
        } else {
            // Comportament intercalat (aleatori)
            juan.start();
            pepe.start();
        }

        try {
            juan.join();
            pepe.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
