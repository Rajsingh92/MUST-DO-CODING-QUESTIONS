// activity selection problem
public class Solution {

    private static class Pair implements Comparable<Pair> {
        int start;
        int finish;

        public Pair(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        public int compareTo(Pair o) {
            return this.finish - o.finish;
        }
    }

    public static void solve(int[] start, int[] end) {

        Pair[] pairs = new Pair[start.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = new Pair(start[i], end[i]);
        }

        Arrays.sort(pairs);

        System.out.println(pairs[0].start + " " + pairs[0].finish);
        int i = 0;
        for (int j = 1; j < pairs.length; j++) {
            if (pairs[j].start >= pairs[i].finish) {
                System.out.println(pairs[j].start + " " + pairs[j].finish);
                i = j;
            }
        }

    }

}


// job sequencing problem
public class Solution {
	static class Job implements Comparable<Job> {
		char JobID;
		int deadline;
		int Profit;

		public Job(char JobID, int deadline, int profit) {
			this.JobID = JobID;
			this.deadline = deadline;
			this.Profit = profit;
		}

		@Override
		public int compareTo(Job o) {
			return o.Profit - this.Profit;
		}
	}

	public static void solve(Job[] jobs) {
		Arrays.sort(jobs);

		Character[] result = new Character[jobs.length];
		for (int i = 0; i < jobs.length; i++) {
			if (result[jobs[i].deadline - 1] == null) {
				result[jobs[i].deadline - 1] = jobs[i].JobID;
			} else {
				int index = jobs[i].deadline - 1;
				while (index >= 0) {
					if (result[index] == null) {
						result[index] = jobs[i].JobID;
						break;
					}
					index--;
				}
			}
		}
	}
}



/**
Minimum Platforms 
Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required 
for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the 
same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of 
time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need 
different platforms,

 

Example 1:

Input: N = 6 
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: 
Minimum 3 platforms are required to 
safely arrive and depart all trains.
 */





class Platform {
    
    public static class pair {
        int first;
        char second;
    
        pair(int key1, char key2) {
            this.first = key1;
            this.second = key2;
        }
    
        public int compareTo(Pair o){
            if(this.first == o.first){
                return Character.compare(this.second, o.second);  
            }
            return p1.first - p2.first;
        }
    }

    
    static int findPlatform(int arr[], int dep[], int n) {
        ArrayList<pair> map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.add(new pair(arr[i], 'a'));
            map.add(new pair(dep[i], 'd'));
        }

        int result = 1;
        int platformRequired = 0;

        for (int i = 0; i < map.size(); i++) {
            pair p = map.get(i);
            if (p.second == 'a')
                platformRequired++;
            else
                platformRequired--;

            if (platformRequired > result)
                result = platformRequired;
        }
        return result;

    }

    static int findPlatform1(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int ans = 0;
        int platformRequired = 0;

        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platformRequired++;
                i++;
            } else if (arr[i] > dep[j]) {
                platformRequired--;
                j++;
            }

            ans = Math.max(ans, platformRequired);
        }

        return ans;

    }

}

