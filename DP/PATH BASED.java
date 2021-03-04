/**

    //Path Set.==============================================================
    public static int mazePath_HVD(int sr,int sc,int er,int ec,int[][] dp,int[][] dir){
        if(sr==er && sc==ec){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0) return dp[sr][sc];

        int count = 0;
        for(int d=0;d<dir.length;d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r <= er && c <= ec)
              count += mazePath_HVD(r,c,er,ec,dp,dir); 
        }

        return dp[sr][sc] = count;
    }


    public static int mazePath_HVD_Multi(int sr,int sc,int er,int ec,int[][] dp,int[][] dir){
        if(sr==er && sc==ec){
            return dp[sr][sc]=1;
        }
        if(dp[sr][sc]!=0) return dp[sr][sc];

        int count = 0;
        for(int d=0;d<dir.length;d++){
            for(int rad = 1;rad <= dp.length;rad++){
               int r = sr + rad*dir[d][0];
               int c = sc + rad*dir[d][1];

               if(r <= er && c <= ec)
                count += mazePath_HVD_Multi(r,c,er,ec,dp,dir);
               else break;
            } 
        }

        return dp[sr][sc] = count;
    }

    public static int mazePath_HVD_DP(int sr,int sc,int er,int ec,int[][] dp,int[][] dir){
        for(sr = er;sr>=0;sr--){
            for(sc = ec;sc>=0;sc--){
                if(sr==er && sc==ec){
                    dp[sr][sc]=1;
                    continue;
                }

                
                int count = 0;
                for(int d=0;d<dir.length;d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
        
                    if(r <= er && c <= ec)
                      count += dp[r][c]; 
                }
        
                dp[sr][sc] = count;
            }
        }

        return dp[0][0];
    }


    public static int mazePath_HVD_Multi_DP(int sr,int sc,int er,int ec,int[][] dp,int[][] dir){
        for(sr = er;sr>=0;sr--){
            for(sc = ec;sc>=0;sc--){
                
                if(sr==er && sc==ec){
                    dp[sr][sc]=1;
                    continue;
                }

                int count = 0;
                for(int d=0;d<dir.length;d++){
                    for(int rad = 1;rad <= dp.length;rad++){
                       int r = sr + rad*dir[d][0];
                       int c = sc + rad*dir[d][1];
        
                       if(r <= er && c <= ec)
                        count += dp[r][c];
                       else break;
                    } 
                }
        
                dp[sr][sc] = count;
            }
        }

        return dp[0][0];
    }

    public static int boardPath(int si,int ei,int[] dp){
        if(si==ei){
            return dp[si] = 1;
        }
        if(dp[si]!=0) return dp[si];

        int count=0;
        for(int dice = 1;dice <= 6 && si+dice<=ei ; dice++){
            count+=boardPath(si+dice,ei,dp);
        }

        return dp[si] = count;
    }

    public static int boardPath_DP(int si,int ei,int[] dp){ 
        for(si = ei; si>=0;si--){
            if(si==ei){
                dp[si] = 1;
                continue;
            }

            int count=0;
            for(int dice = 1;dice <= 6 && si+dice<=ei ; dice++){
                count += dp[si+dice];
            }
    
            dp[si] = count;
        }

        return dp[0];
    }

    public static int boardPath_Opti(int si,int ei){ 
        LinkedList<Integer> ll = new LinkedList<>();
        for(si = ei; si>=0;si--){
            if(si >= ei-1){
                ll.addFirst(1);
                continue;
            }

            if(ll.size()<=6) 
              ll.addFirst(2*ll.getFirst());
            else
               ll.addFirst((2 * ll.getFirst()) - ll.removeLast());
        }

        return ll.getFirst();
    }

    public static int boardPath_Opti2(int ei){ 
        int[] ans = {1,1,2,4,8,16,32};
        int idx = 6;
        if(ei<=6) return ans[ei];

        for(int i=7;i<=ei;i++){
            int val = 2*ans[idx];
            idx = (idx+1) % 7;
            val -= ans[idx];

            ans[idx] = val;     
        }

        return ans[idx];
    }

    //Leetcode 64
    public int minPathSum(int[][] grid,int sr,int sc,int[][] dp) {
        if(sr == grid.length - 1 && sc == grid[0].length - 1){
            return dp[sr][sc] = grid[sr][sc];
        }

        if(dp[sr][sc]!=0) return dp[sr][sc];
        
        int minAns = (int) 1e9;
        if(sr + 1 < grid.length) minAns = Math.min(minAns, minPathSum(grid,sr+1,sc,dp));
        if(sc + 1 < grid[0].length) minAns = Math.min(minAns, minPathSum(grid,sr,sc+1,dp));

        return dp[sr][sc]=minAns;
    }

    
    public int minPathSum_DP(int[][] grid,int sr,int sc,int[][] dp) {
        for(sr = grid.length-1;sr>=0;sr--){
            for(sc = grid[0].length-1;sc>=0;sc--){
                if(sr == grid.length - 1 && sc == grid[0].length - 1){
                    dp[sr][sc] = grid[sr][sc];
                }
                
                int minAns = (int) 1e9;
                if(sr + 1 < grid.length) minAns = Math.min(minAns, dp[sr+1][sc]);
                if(sc + 1 < grid[0].length) minAns = Math.min(minAns,dp[sr][sc+1]);
        
                dp[sr][sc]=minAns;
            }
        }

        return dp[0][0];
    }

    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int ans= minPathSum(grid,0,0,dp);         
        return ans;
    }

    public static int goldMine(int[][] grid,int sr,int sc,int[][] dp,int[][] dir){
        if(sc==grid[0].length-1){
            return dp[sr][sc] = grid[sr][sc];
        }

        if(dp[sr][sc]!=0) return dp[sr][sc];

        int maxAns = 0;
        for(int d=0;d<dir.length;d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            
            if(r>=0 && c>=0 && r< grid.length && c<grid[0].length)
              maxAns = Math.max(maxAns,goldMine(grid,r,c,dp,dir));
        }

        return dp[sr][sc] = maxAns + grid[sr][sc];
    }

    public static void goldMineP_DP(int[][] grid,int sr,int sc,int[][] dp,int[][] dir){
        for(sr = grid.length-1;sr>=0;sr--){
            for(sc = grid[0].length-1;sc>=0;sc--){
                if(sr == grid.length-1 && sc == grid[0].length-1){
                     dp[sr][sc] = grid[sr][sc];
                     continue;
                }
        
                int maxAns = 0;
                for(int d=0;d<dir.length;d++){
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    
                    if(r>=0 && c>=0 && r< grid.length && c<grid[0].length)
                      maxAns = Math.max(maxAns,dp[r][c]);
                }
        
                dp[sr][sc] = maxAns + grid[sr][sc];
            }
        }

        int maxRes =0;
        for(int i=0;i<grid.length;i++)
          maxRes = Math.max(maxRes, dp[i][0]);

        System.out.println(maxRes);
        
    }



    public static void goldMine(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m]; 
        
        int maxAns = 0;
        int[][] dir = {{-1,1},{0,1},{1,1}};

        for(int i=0;i<n;i++)
          maxAns = Math.max(maxAns, goldMine(grid,i,0,dp,dir));
        
        System.out.println(maxAns);
    }


    public static void mazePath(){
        // int n = 3;
        // int m = 3;

        // int[][] dp = new int[n][m];
        // int[][] dir = {{1,0},{0,1},{1,1}};

        // System.out.println(mazePath_HVD(0,0,n-1,m-1,dp,dir));
        // System.out.println(mazePath_HVD_Multi(0,0,n-1,m-1,dp,dir));

        // System.out.println(mazePath_HVD_DP(0,0,n-1,m-1,dp,dir));
        // System.out.println(mazePath_HVD_Multi_DP(0,0,n-1,m-1,dp,dir));

        // int n = 1;
        // int[] dp = new int[n+1];
        // System.out.println(boardPath(0,n,dp));
        // System.out.println(boardPath_DP(0,n,dp));
        // System.out.println(boardPath_Opti2(n));

        int n = 5;
        int k = 3;
        int[][] dp = new int[n+1][k+1];
        for(int[] a : dp) Arrays.fill(a,0);
        System.out.println(countWays_DP(n,k,dp));

        // print(dp);
        print2D(dp);
    }


    //PathSeries.=============================================================

	public static int mazePathHV_rec(int sr, int sc, int er, int ec, int[][] dp) {
		if (sr == er && sc == ec) {
			dp[sr][sc] = 1;
			return 1;
		}

		if (dp[sr][sc] != 0) return dp[sr][sc];

		int count = 0;
		if (sr + 1 <= er) count += mazePathHV_rec(sr + 1, sc, er, ec, dp);

		if (sr + 1 <= er && sc + 1 <= ec) count += mazePathHV_rec(sr + 1, sc + 1, er, ec, dp);

		if (sc + 1 <= ec) count += mazePathHV_rec(sr, sc + 1, er, ec, dp);

		return dp[sr][sc] = count;
	}

	public static int mazePathHV_DP(int sr, int sc, int er, int ec, int[][] dp) {

		for (sr = er; sr >= 0; sr--) {
			for (sc = ec; sc >= 0; sc--) {

				if (sr == er && sc == ec) {
					dp[sr][sc] = 1;
					continue;
				}

				int count = 0;
				if (sr + 1 <= er) count += dp[sr + 1][sc];

				if (sr + 1 <= er && sc + 1 <= ec) count += dp[sr + 1][sc + 1];

				if (sc + 1 <= ec) count += dp[sr][sc + 1];

				dp[sr][sc] = count;
			}
		}
		return dp[0][0];
	}

	public static int mazePathMulti_rec(int sr, int sc, int er, int ec, int[][] dp) {
		if (sr == er && sc == ec) {
			dp[sr][sc] = 1;
			return 1;
		}

		if (dp[sr][sc] != 0) return dp[sr][sc];

		int count = 0;
		for (int jump = 1; sr + jump <= er; jump++)
		count += mazePathMulti_rec(sr + jump, sc, er, ec, dp);

		for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++)
		count += mazePathMulti_rec(sr + jump, sc + jump, er, ec, dp);

		for (int jump = 1; sc + jump <= ec; jump++)
		count += mazePathMulti_rec(sr, sc + jump, er, ec, dp);

		return dp[sr][sc] = count;
	}

	public static int mazePathMulti_DP(int sr, int sc, int er, int ec, int[][] dp) {

		for (sr = er; sr >= 0; sr--) {
			for (sc = ec; sc >= 0; sc--) {

				if (sr == er && sc == ec) {
					dp[sr][sc] = 1;
					continue;
				}

				int count = 0;
				for (int jump = 1; sr + jump <= er; jump++)
				count += dp[sr + jump][sc];

				for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++)
				count += dp[sr + jump][sc + jump];

				for (int jump = 1; sc + jump <= ec; jump++)
				count += dp[sr][sc + jump];

				dp[sr][sc] = count;
			}
		}

		return dp[0][0];
	}

	public static int boradPath(int si, int ei, int[] dp) {
		if (si == ei) return dp[si] = 1;

		if (dp[si] != 0) return dp[si];

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			if (si + dice <= ei) {
				count += boradPath(si + dice, ei, dp);
			}
		}

		return dp[si] = count;
	}

	public static int boradPath_DP(int si, int ei, int[] dp) {

		for (int i = ei; i >= si; i--) {
			if (i == ei) {
				dp[i] = 1;
				continue;
			}

			int count = 0;
			for (int dice = 1; dice <= 6; dice++) {
				if (i + dice <= ei) {
					count += dp[i + dice];
				}
			}

			dp[i] = count;
		}

		return dp[0];
	}

	public static int boradPath_02_DP(int si, int ei, int[] steps, int[] dp) {

		for (int i = ei; i >= si; i--) {
			if (i == ei) {
				dp[i] = 1;
				continue;
			}

			int count = 0;
			for (int j = 0; j < steps.length; j++) {
				if (i + steps[j] <= ei) {
					count += dp[i + steps[j]];
				}
			}

			dp[i] = count;
		}

		return dp[0];
	}

	public static int boradPath_opti(int si, int ei, int[] dp) {
		LinkedList < Integer > ll = new LinkedList < >();

		for (int i = ei; i >= si; i--) {
			if (i > ei - 2) {
				ll.addFirst(1);
				continue;
			}

			ll.addFirst(2 * ll.getFirst());
			if (ll.size() == 8) {
				int lastValue = ll.removeLast();
				ll.addFirst(ll.removeFirst() - lastValue);
			}
		}

		return ll.getFirst();
	}

	

	public static int minCostPath(int[][] cost, int sr, int sc, int[][] dp) {
		if (sr == cost.length - 1 && sc == cost[0].length - 1) return dp[sr][sc] = cost[sr][sc];

		int minAns = (int) 1e7;
		if (sr + 1 < cost.length) minAns = Math.min(minAns, minCostPath(cost, sr + 1, sc, dp));
		if (sc + 1 < cost[0].length) minAns = Math.min(minAns, minCostPath(cost, sr, sc + 1, dp));
		if (sr + 1 < cost.length && sc + 1 < cost[0].length) minAns = Math.min(minAns, minCostPath(cost, sr + 1, sc + 1, dp));

		return dp[sr][sc] = minAns + cost[sr][sc];
	}

	public static int minCostPath_DP(int[][] cost, int sr, int sc, int[][] dp) {

		for (sr = cost.length - 1; sr >= 0; sr--) {
			for (sc = cost[0].length - 1; sc >= 0; sc--) {
				if (sr == cost.length - 1 && sc == cost[0].length - 1) {
					dp[sr][sc] = cost[sr][sc];
					continue;
				}

				int minAns = (int) 1e7;
				if (sr + 1 < cost.length) minAns = Math.min(minAns, dp[sr + 1][sc]);
				if (sc + 1 < cost[0].length) minAns = Math.min(minAns, dp[sr][sc + 1]);
				if (sr + 1 < cost.length && sc + 1 < cost[0].length) minAns = Math.min(minAns, dp[sr + 1][sc + 1]);

				return dp[sr][sc] = minAns + cost[sr][sc];
			}
		}

		return dp[0][0];

	}

	public static int goldMineRec_(int[][] mat, int sr, int sc, int[][] dp) {
		if (sc == mat[0].length - 1) return dp[sr][sc] = mat[sr][sc];

		if (dp[sr][sc] != 0) return dp[sr][sc];

		int cost = 0;
		cost = Math.max(cost, (sr - 1) < 0 ? 0 : goldMineRec_(mat, sr - 1, sc + 1, dp));
		cost = Math.max(cost, goldMineRec_(mat, sr, sc + 1, dp));
		cost = Math.max(cost, (sr + 1) >= mat.length ? 0 : goldMineRec_(mat, sr + 1, sc + 1, dp));

		return dp[sr][sc] = cost + mat[sr][sc];
	}

	public static int goldMineDP(int[][] mat, int[][] dp) {

		for (int sc = mat[0].length - 1; sc >= 0; sc--) {
			for (int sr = mat.length - 1; sr >= 0; sr--) {

				if (sc == mat[0].length - 1) {
					dp[sr][sc] = mat[sr][sc];
					continue;
				}

				int cost = 0;
				cost = Math.max(cost, (sr - 1) < 0 ? 0 : dp[sr - 1][sc]);
				cost = Math.max(cost, dp[sr][sc]);
				cost = Math.max(cost, (sr + 1) >= mat.length ? 0 : dp[sr + 1][sc]);

				dp[sr][sc] = cost + mat[sr][sc];

			}
		}

		int maxAns = 0;
		for (int i = 0; i < mat.length; i++) {
			maxAns = Math.max(maxAns, dp[i][0]);
		}

		return maxAns;

	}

	public static int goldMine(int[][] mat) {
		int[][] dp = new int[mat.length][mat[0].length];
		int maxAns = 0;
		for (int i = 0; i < mat.length; i++) {
			maxAns = Math.max(maxAns, goldMineRec_(mat, i, 0, dp));
		}

		// maxAns=goldMineDP(mat,dp);

		return maxAns;
	}

	public static int pairAndSingle_01(int n, int[] dp) {
		if (n <= 1) return dp[n] = 1;
		if (dp[n] != 0) return dp[n];

		int singleWays = pairAndSingle_01(n - 1, dp);
		int pairUpWays = pairAndSingle_01(n - 2, dp) * (n - 1);

		return dp[n] = singleWays + pairUpWays;
	}

	public static int pairAndSingle_DP(int N, int[] dp) {

		for (int n = 0; n <= N; n++) {

			if (n <= 1) {
				dp[n] = 1;
				continue;
			}

			int singleWays = dp[n - 1];
			int pairUpWays = dp[n - 2] * (n - 1);

			dp[n] = singleWays + pairUpWays;
		}

		return dp[N];
	}

	public static int pairAndSingle_fast(int n) {
		if (n <= 1) return 1;

		int a = 1;
		int b = 1;
		int ans = 1;

		for (int i = 2; i <= n; i++) {
			ans = b + a * (i - 1); // b is (n-1) and a is (n-2)
			a = b;
			b = ans;
		}

		return ans;
	}


     public static int mazePath_HVD(int sr,int sc,int er,int ec,int[][] dp){
        if(sr==er && sc==ec){
            return dp[sr][sc] = 1;
        }

        if(dp[sr][sc]!=0) return dp[sr][sc];
        int count=0;
        
        if(sc+1 <= ec) count+=mazePath_HVD(sr,sc+1,er,ec,dp);
        if(sr+1 <= er && sc+1 <= ec)count+=mazePath_HVD(sr+1,sc+1,er,ec,dp);
        if(sr+1 <= er)count+=mazePath_HVD(sr+1,sc,er,ec,dp);
        
        return dp[sr][sc] = count;
    }

    public static int mazePath_HVD_DP(int sr,int sc,int er,int ec,int[][] dp){
     
        for(sr=er;sr>=0;sr--){
            for(sc=ec;sc>=0;sc--){
                if(sr==er && sc==ec){
                    dp[sr][sc] = 1;
                    continue;
                }
        
                int count=0;
                
                if(sc+1 <= ec) count+=dp[sr][sc+1];//mazePath_HVD(sr,sc+1,er,ec,dp);
                if(sr+1 <= er && sc+1 <= ec)count+=dp[sr+1][sc+1];//mazePath_HVD(sr+1,sc+1,er,ec,dp);
                if(sr+1 <= er)count+=dp[sr+1][sc];//mazePath_HVD(sr+1,sc,er,ec,dp);
                
               dp[sr][sc] = count;
            }
        }
        return dp[0][0];
    }

    public static int mazePath_HVDJump_DP(int sr,int sc,int er,int ec,int[][] dp){
     
        for(sr=er;sr>=0;sr--){
            for(sc=ec;sc>=0;sc--){
                if(sr==er && sc==ec){
                    dp[sr][sc] = 1;
                    continue;
                }
        
                int count=0;
                
                for(int jump=1; sc+jump <= ec; jump++) count+=dp[sr][sc+jump];//mazePath_HVD(sr,sc+1,er,ec,dp);
                for(int jump=1; sr+jump <= er && sc+jump <= ec; jump++)count+=dp[sr+jump][sc+jump];//mazePath_HVD(sr+1,sc+1,er,ec,dp);
                for(int jump=1; sr+jump <= er; jump++)count+=dp[sr+jump][sc];//mazePath_HVD(sr+1,sc,er,ec,dp);
                
               dp[sr][sc] = count;
            }
        }
        return dp[0][0];
    }

    public static int boardPath(int si,int ei,int[] dp){
        if(si==ei){
            return dp[si] = 1;
        }

        if(dp[si]!=0) return dp[si];

        int count=0;
        for(int dice = 1; dice <= 6 && si + dice <= ei ; dice++){
            count+=boardPath(si+dice,ei,dp);
        }

        return dp[si] = count;
    }

    public static int boardPath_DP(int si,int ei,int[] dp){
        for(si=ei;si>=0;si--){
            if(si==ei){
                dp[si] = 1;
                continue;
            }
    
            int count=0;
            for(int dice = 1; dice <= 6 && si + dice <= ei ; dice++){
                count+=dp[si+dice]; //boardPath(si+dice,ei,dp);
            }

            dp[si] = count;
        }
        
        return dp[0];
    }

    public static int boardPath_Opti(int si,int ei,int[] dp){
        LinkedList<Integer> ll = new LinkedList<>();
        for(si=ei;si>=0;si--){
            if(si>=ei-1){
                ll.addFirst(1);
                continue;
            }

            if(ll.size()<=6) ll.addFirst(ll.getFirst()*2);
            else{
                int lval = ll.removeLast();
                ll.addFirst(ll.getFirst()*2 - lval);
            }
        }
        
        return ll.getFirst();
    }


    
    


    public static int boardPath_Moves(int si,int ei,int[] moves,int[] dp){
        Arrays.sort(moves);
        for(si=ei;si>=0;si--){
            if(si==ei){
                dp[si] = 1;
                continue;
            }
    
            int count=0;
            for(int i = 0; si + moves[i] <= ei ; i++){
                count+=dp[si + moves[i]]; //boardPath(si+dice,ei,dp);
            }

            dp[si] = count;
        }
        
        return dp[0];
    }

    //Leetcode 64    
    public static int minPathSum(int[][] grid,int sr,int sc,int[][] dp) {
        if(sr==grid.length-1 && sc==grid[0].length-1){
            return dp[sr][sc] = grid[sr][sc];
        }

        if(dp[sr][sc]!=0) return dp[sr][sc];

        int minCost = (int)1e8;
        if(sr + 1 < grid.length) minCost = Math.min(minCost,minPathSum(grid,sr+1,sc,dp));
        if(sc + 1 < grid[0].length) minCost = Math.min(minCost,minPathSum(grid,sr,sc+1,dp));
        
        return dp[sr][sc] = minCost + grid[sr][sc];
    }

    
    public static int minPathSum_DP(int[][] grid,int sr,int sc,int[][] dp) {
        
        for(sr=grid.length-1;sr>=0 ;sr--){
            for(sc=grid[0].length-1; sc>=0 ; sc--){
               if(sr==grid.length-1 && sc==grid[0].length-1){
                    dp[sr][sc] = grid[sr][sc];
                    continue;
                }
                int minCost = (int)1e8;
                if(sr + 1 < grid.length) minCost = Math.min(minCost,dp[sr+1][sc]);
                if(sc + 1 < grid[0].length) minCost = Math.min(minCost,dp[sr][sc+1]);
        
                dp[sr][sc] = minCost + grid[sr][sc];         
            }
        }

        return dp[0][0];
    }

    
    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        // int ans= minPathSum(grid,0,0,dp);
        int ans= minPathSum_DP(grid,0,0,dp);

        return ans;
    }

    public static int goldMineProblem(int[][] coins,int sr,int sc,int[][] dp,int[][] dir){
        if(sc==coins[0].length-1){
            return dp[sr][sc] = coins[sr][sc];
        }

        if(dp[sr][sc]!=0) return dp[sr][sc];

        for(int d=0;d<3;d++){
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if(r>=0 && c>=0 && r < coins.length && c < coins[0].length){
                dp[sr][sc] = Math.max(dp[sr][sc], goldMineProblem(coins,r,c,dp,dir) + coins[sr][sc]);
            }
        }

        return dp[sr][sc];
    }

    
    public static int goldMineProblem_DP(int[][] coins,int sr,int sc,int[][] dp,int[][] dir){
        for(sc = coins[0].length - 1;sc>=0;sc--){
            for(sr = coins.length - 1; sr>=0;sr--){
                if(sc==coins[0].length-1){
                    dp[sr][sc] = coins[sr][sc];
                    continue; 
                }
                
                for(int d=0;d<3;d++){
                     int r = sr + dir[d][0];
                     int c = sc + dir[d][1];
         
                     if(r>=0 && c>=0 && r < coins.length && c < coins[0].length){
                        dp[sr][sc] = Math.max(dp[sr][sc], dp[r][c]  + coins[sr][sc]);
                     }
                 }
            }
        }

        int max = 0;
        for(int i=0;i<coins.length;i++){
            max = Math.max(max, dp[i][0]);
        }

        return max;
    }

    public static int goldMineProblem(){
        int[][] coins={{10, 33, 13, 15},
                        {22, 21, 04, 1},
                        {5, 0, 2, 3},
                        {0, 6, 14, 2}};
        int[][] dp = new int[coins.length][coins[0].length];
        int[][] dir = {{-1,1},{0,1},{1,1}};

        int max = 0;
        // for(int i=0;i<coins.length;i++){
        //     max = Math.max(max, goldMineProblem(coins,i,0,dp,dir));
        // }

        max=goldMineProblem_DP(coins,0,0,dp,dir);

        print2D(dp);
        return max;
    }


     public static int mazePath_Rec_01(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        if (sr + 1 <= er)
            count += mazePath_Rec_01(sr + 1, sc, er, ec, dp);
        if (sc + 1 <= ec)
            count += mazePath_Rec_01(sr, sc + 1, er, ec, dp);
        if (sr + 1 <= er && sc + 1 <= ec)
            count += mazePath_Rec_01(sr + 1, sc + 1, er, ec, dp);

        return dp[sr][sc] = count;
    }

    public static int mazePath_Rec_02(int sr, int sc, int er, int ec, int[][] dp) {
        if (sr == er && sc == ec) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];

        int count = 0;
        for (int jump = 1; sr + jump <= er; jump++)
            count += mazePath_Rec_02(sr + jump, sc, er, ec, dp);
        for (int jump = 1; sc + jump <= ec; jump++)
            count += mazePath_Rec_02(sr, sc + jump, er, ec, dp);
        for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++)
            count += mazePath_Rec_02(sr + jump, sc + jump, er, ec, dp);

        return dp[sr][sc] = count;
    }

    public static int mazePath_DP_01(int sr, int sc, int er, int ec, int[][] dp) {
        for (sr = er; sr >= 0; sr--) {
            for (sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                if (sr + 1 <= er)
                    count += dp[sr + 1][sc];// mazePath_Rec_01(sr + 1, sc, er, ec, dp);
                if (sc + 1 <= ec)
                    count += dp[sr][sc + 1];// mazePath_Rec_01(sr, sc + 1, er, ec, dp);
                if (sr + 1 <= er && sc + 1 <= ec)
                    count += dp[sr + 1][sc + 1];// mazePath_Rec_01(sr + 1, sc + 1, er, ec, dp);

                dp[sr][sc] = count;
            }
        }

        return dp[0][0];
    }

    public static int mazePath_DP_02(int sr, int sc, int er, int ec, int[][] dp) {
        for (sr = er; sr >= 0; sr--) {
            for (sc = ec; sc >= 0; sc--) {
                if (sr == er && sc == ec) {
                    dp[sr][sc] = 1;
                    continue;
                }

                int count = 0;
                for (int jump = 1; sr + jump <= er; jump++)
                    count += dp[sr + jump][sc];
                for (int jump = 1; sc + jump <= ec; jump++)
                    count += dp[sr][sc + jump];
                for (int jump = 1; sr + jump <= er && sc + jump <= ec; jump++)
                    count += dp[sr + jump][sc + jump];

                dp[sr][sc] = count;
            }
        }

        return dp[0][0];
    }

    // to_Be_done------------------------------------------->62_and_63_of_leetcode.

    public static int boardPath_Rec_01(int si, int ei, int[] dp) {
        if (si == ei) {
            return dp[si] = 1;
        }

        if (dp[si] != 0)
            return dp[si];

        int count = 0;
        for (int dice = 1; dice <= 6 && si + dice <= ei; dice++) {
            count += boardPath_Rec_01(si + dice, ei, dp);
        }

        return dp[si] = count;
    }

    public static int boardPath_DP_01(int si, int ei, int[] dp) {

        for (si = ei; si >= 0; si--) {
            if (si == ei) {
                dp[si] = 1;
                continue;
            }

            int count = 0;
            for (int dice = 1; dice <= 6 && si + dice <= ei; dice++) {
                count += dp[si + dice];// boardPath_Rec_01(si + dice, ei, dp);
            }

            dp[si] = count;
        }

        return dp[0];
    }

    public static int boardPath_opti(int ei) {
        LinkedList<Integer> ll = new LinkedList<>();

        for (int si = 0; si <= ei; si++) {
            if (si < 2) {
                ll.addFirst(1);
                continue;
            }

            if (ll.size() <= 6)
                ll.addFirst(2 * ll.getFirst());
            else {
                ll.addFirst(2 * ll.getFirst() - ll.getLast());
                ll.removeLast();
            }
        }

        return ll.getFirst();
    }

    public static int boardPath_DP_02(int si, int ei, int[] moves, int[] dp) {
        for (si = ei; si >= 0; si--) {
            if (si == ei) {
                dp[si] = 1;
                continue;
            }

            int count = 0;
            for (int i = 0; i < moves.length; i++) {
                if (si + moves[i] <= ei)
                    count += dp[si + moves[i]];// boardPath_Rec_01(si + moves[i], ei, dp);
            }

            dp[si] = count;
        }

        return dp[0];
    }

    

    // Leetcode 64

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int sr = grid.length - 1; sr >= 0; sr--) {
            for (int sc = grid[0].length - 1; sc >= 0; sc--) {
                if (sr == grid.length - 1 && sc == grid[0].length - 1) {
                    dp[sr][sc] = grid[sr][sc];
                    continue;
                }

                int minCoins = (int) 1e8;
                if (sc + 1 < grid[0].length)
                    minCoins = Math.min(minCoins, dp[sr][sc + 1]);
                if (sr + 1 < grid.length)
                    minCoins = Math.min(minCoins, dp[sr + 1][sc]);

                dp[sr][sc] = minCoins + grid[sr][sc];
            }
        }

        return dp[0][0];
    }
 */