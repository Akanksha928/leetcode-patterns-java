import java.util.Arrays;

class JobSequencing {
    public int[] JobScheduling(int[][] jobs) {
        // Sort jobs by profit descending 
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);

        // Find the maximum deadline to determine the timeline size
        int maxDeadline = 0;
        for (int[] job : jobs) {
            maxDeadline = Math.max(maxDeadline, job[1]); 
        }

        boolean[] slots = new boolean[maxDeadline + 1];

        int jobCount = 0;
        int totalProfit = 0;

        // Try to schedule each job on the latest available day <= its deadline
        for (int[] job : jobs) {
            int deadline = job[1];
            int profit = job[2];

            for (int day = deadline; day >= 1; day--) {
                if (!slots[day]) {
                    slots[day] = true;        // mark the day as taken
                    jobCount++;
                    totalProfit += profit;   // add profit
                    break;                   // move to next job
                }
            }
        }

        return new int[]{jobCount, totalProfit};
    }

    public static void main(String[] args) {
        JobSequencing sol = new JobSequencing();

        int[][] jobs = {
            {1, 2, 100},
            {2, 1, 19},
            {3, 2, 27},
            {4, 1, 25},
            {5, 3, 15}
        };

        int[] result = sol.JobScheduling(jobs);
        System.out.println("Jobs done: " + result[0] + ", Total Profit: " + result[1]);
    }
}
