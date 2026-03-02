public class timeMethods {
    public static int N = 10000; 

    public static void main(String args[]) {
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        int repetitions = 30;

        // Time chained hashing
        double runTime = 0, runTime2 = 0;
        for (int repetition = 0; repetition < repetitions; repetition++) {
            TableHashChained H = new TableHashChained(N);

            long start = System.currentTimeMillis();

            for (int k = 0; k < N; k++) {
                H.hashInsert("item" + k);
            }
            for (int k = 0; k < N; k++) {
                H.hashSearch("item" + k);
            }

            long finish = System.currentTimeMillis();
            double time = (double)(finish - start);
            runTime += time;
            runTime2 += (time*time);
        }

        double aveRuntime = runTime/repetitions;
        double stdDeviation =
            Math.sqrt(runTime2 - repetitions*aveRuntime*aveRuntime)/(repetitions-1);

        System.out.printf("\n\nStatistics for Chained Hashing\n");
        System.out.println("________________________________________________");
        System.out.println("Total time   = " + runTime/1000 + "s.");
        System.out.println("Average time = " + fiveD.format(aveRuntime/1000) + "s ± "
                           + fourD.format(stdDeviation) + "ms.");
        System.out.println("n            = " + N);
        System.out.println("Repetitions  = " + repetitions);
        System.out.println("________________________________________________");

        // Time open hashing
        runTime = 0; runTime2 = 0;
        for (int repetition = 0; repetition < repetitions; repetition++) {
            TableHashOpen H = new TableHashOpen(N*2); 

            long start = System.currentTimeMillis();

            for (int k = 0; k < N; k++) {
                H.hashInsert("item" + k);
            }
            for (int k = 0; k < N; k++) {
                H.hashSearch("item" + k);
            }

            long finish = System.currentTimeMillis();
            double time = (double)(finish - start);
            runTime += time;
            runTime2 += (time*time);
        }

        aveRuntime = runTime/repetitions;
        stdDeviation =
            Math.sqrt(runTime2 - repetitions*aveRuntime*aveRuntime)/(repetitions-1);

        System.out.printf("\n\nStatistics for Open Hashing (Linear Probing)\n");
        System.out.println("________________________________________________");
        System.out.println("Total time   = " + runTime/1000 + "s.");
        System.out.println("Average time = " + fiveD.format(aveRuntime/1000) + "s ± "
                           + fourD.format(stdDeviation) + "ms.");
        System.out.println("n            = " + N);
        System.out.println("Repetitions  = " + repetitions);
        System.out.println("________________________________________________");
    }
}
